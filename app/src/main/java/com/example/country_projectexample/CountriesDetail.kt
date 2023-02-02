package com.example.country_projectexample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.example.country_projectexample.datamodel_detail.Country_Response_Detail
import com.example.country_projectexample.retrofit.CountriesService.retrofitService
import retrofit2.Call
import retrofit2.Response

class CountriesDetail : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "WrongViewCast", "CutPasteId", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries_detail)

        val enName_Common = intent.getStringExtra("enName_Common").toString() //리사이클러뷰의 나라를 클릭하면 해당하는 나라의 enName_Common의 값을 intent를 통해 가지고 옴
        val enName_Official = intent.getStringExtra("enName_Official").toString() //리사이클러뷰의 나라를 클릭하면 해당하는 나라의 enName_Official 값을 intent를 통해 가지고 옴
        val korName_Common = intent.getStringExtra("korName_Common").toString() //리사이클러뷰의 나라를 클릭하면 해당하는 나라의 korName_Common 값을 intent를 통해 가지고 옴
        val flag = intent.getStringExtra("flag").toString() //리사이클러뷰의 나라를 클릭하면 해당하는 나라의 korName_Common 값을 intent를 통해 가지고 옴

        val backBtn_Detail = findViewById<ImageView>(R.id.backBtn_Detail)
        val image_GoogleMap = findViewById<WebView>(R.id.image_GoogleMap)
        val country_Flag_Detail = findViewById<ImageView>(R.id.country_Flag_Detail)
        val korName_Detail = findViewById<TextView>(R.id.korName_Detail)
        val enName_Official_Detail = findViewById<TextView>(R.id.enName_Official_Detail)
        val nativeNameCommon_Input_Detail = findViewById<TextView>(R.id.nativeNameCommon_Input_Detail)
        val cioc_Input_Detail = findViewById<TextView>(R.id.cioc_Input_Detail)
        val continent_Input_Detail = findViewById<TextView>(R.id.continent_Input_Detail)
        val capital_Input_Detail = findViewById<TextView>(R.id.capital_Input_Detail)
        val population_Input_Detail = findViewById<TextView>(R.id.population_Input_Detail)
        val currency_Input_Detail = findViewById<TextView>(R.id.currency_Input_Detail)
        val language_Input_Detail = findViewById<TextView>(R.id.language_Input_Detail)

        /*
            WebView 사용을 위한 설정
         */
        image_GoogleMap.settings.javaScriptEnabled = true
        image_GoogleMap.webViewClient = WebViewClient()
        image_GoogleMap.webChromeClient = WebChromeClient()


        korName_Detail.text = korName_Common //클릭시 해당 리사이클러뷰의 값 korName_Common을 intent로 받은 후 korName_Detail에 넣어준다.
        enName_Official_Detail.text = enName_Official //클릭시 해당 리사이클러뷰의 enName_Official을 intent로 받은 후 enName_Official에 넣어준다.
        Glide.with(this) //클릭시 해당 리사이클러뷰의 flag를 intent로 받은 후 Glide를 통해 country_Flag_Detail에 넣어준다.
            .load(flag)
            .into(country_Flag_Detail)

        /*
        object 클래스로부터 retrofitService를 가져온다. 이 retrofitService는 CountriesApi 형태로 반환이 되는데 CountriesApi는 인터페이스 형식이다.
        CountriesApi에 있는 메서드들은 직접적으로 데이터를 가져올 수 있게 해주는 @GET, @PATH, @QUERY 등을 이용해 작성하고 원하는 URL에 있는 데이터를 가져 올 수 있게 해준다,
         MainActivity에서는 CountriesApi 인터페이스 안에 있는 메서드들 중 getDetailCountries()를 사용하여
         https://restcountries.com/v3.1/name/{countries-name} 의 url에 값을 가져온다.
         여기서 중요한 것은 url 형식을 내가 원하는 값을 고정이 아닌 유동적으로 바꿔줘야 한다는 것이다.
         여기서는 {countries-name} 이 부분인데, 리사이클러뷰의 어떠한 나라를 클릭했을때 그 나라의 대한 정보를 가지고 와야한다.
         이때 클릭을 했을때 해당하는 나라의 enName_Common의 데이터 값을 url에 넣으면 쉽게 그 해당하는 나라에 대한 정보만을 가지고 올 수 있어 이 url 주소는 클릭한 리사이클러뷰 나라의 enName_Common을
         가지고 와야만 한다. 이것을 intent를 통해 받아왔고 이 값을 @Path 어노테이션을 통해 매개변수 처럼 이용하게 한 것이다.
         즉, @Path 어노테이션을 이용을 하여 고정값이 아닌 유동적으로 바뀌어야하는 url 주소에 매개변수에 넣어 사용하였다.
         또한, 여기 위에 있는 url에 있는 값들은 json 형식이다. 이것을 자동적으로 변환을 해줘야하는데 이것은 retrofitService를 만들때 GsonConverterFactory를 이용하여 자동 변환을 하게 만들어줬다.
         */
        retrofitService.getDetailCountries(enName_Common).enqueue(object : retrofit2.Callback<Country_Response_Detail> {

            @SuppressLint("SetJavaScriptEnabled")
            override fun onResponse( //restrofit2 통신 성공했을 때(데이터 가져옴)
                call: Call<Country_Response_Detail>,
                response: Response<Country_Response_Detail>
            ) {
                val body = response.body() //가져오는 데이터는 response인데, 이것은 Country_Response_Detail 형태이다.
                body?.let { it ->

                    it.forEach {
                        //통신으로 받아온 nativeName-common 데이터 정제
                        val nativeName_Index1 = it.name?.nativeName.toString().indexOf("common") + 7
                        val nativeName_Index2 = it.name?.nativeName.toString().indexOf(",",nativeName_Index1)
                        val nativeName_Common = it.name?.nativeName.toString().substring(nativeName_Index1, nativeName_Index2) //activity_countries_detail.xml 사용 할 nativeName_Common(흔한 현지이름)변수

                        val nativeNameTolanguage = it.name?.nativeName.toString().substring(it.name?.nativeName.toString().indexOf("common")-4,it.name?.nativeName.toString().indexOf("common")-1) //nativeName으로부터 language에 입력될 언어 필드를 빼옴

                        val cioc = it.cioc //activity_countries_detail.xml 사용 할 cioc(국가코드) 변수

                        val continent = it.region //activity_countries_detail.xml 사용 할 continent(대륙) 변수

                        //통신으로 받아온 capital 데이터 정제
                        if(it.capital==null) {
                            val capital = ""
                        }
                        else {
                            val capital = it.capital.toString().substring(1,it.capital.toString().length-1) //activity_countries_detail.xml 사용 할 capital(수도) 변수
                            capital_Input_Detail.text = capital //capital_Input_Detail이라는 TextView와 capital 변수 연결
                        }

                        val population = it.population //activity_countries_detail.xml 사용 할 population(인구) 변수

                        //통신으로 받아온 currencies 데이터 정제
                        if (it.currencies==null) {
                            currency_Input_Detail.text = "" //currency_Input_Detail이라는 TextView와 currency 변수 연결
                        } else {
                            val currency_Index1 = it.currencies.toString().indexOf("name") + 5
                            val currency_Index2 = it.currencies.toString().indexOf(",",currency_Index1)
                            val currency_Index3 = it.currencies.toString().indexOf("symbol") + 7
                            val currency_Index4 = it.currencies.toString().indexOf(")",currency_Index1)

                            val currencies_Name = it.currencies.toString().substring(currency_Index1,currency_Index2)
                            val currencies_Symbol = it.currencies.toString().substring(currency_Index3,currency_Index4)
                            val currency = StringBuilder().append(currencies_Symbol).append("(").append(currencies_Name).append(")").toString() //activity_countries_detail.xml 사용 할 currency(화폐) 변수
                            println("currency_Input : ${currency}")
                            currency_Input_Detail.text = currency //currency_Input_Detail이라는 TextView와 currency 변수 연결
                        }

                        nativeNameCommon_Input_Detail.text = nativeName_Common //nativeNameCommon_Input_Detail이라는 TextView와 nativeName_Common 변수 연결
                        cioc_Input_Detail.text = cioc //cioc_Input_Detail이라는 TextView와 cioc 변수 연결
                        continent_Input_Detail.text = continent //continent_Input_Detail이라는 TextView와 continent 변수 연결
                        population_Input_Detail.text = population.toString() //population_Input_Detail이라는 TextView와 population 변수 연결
                        it.maps?.openStreetMaps.toString().let { googleMapUrl -> image_GoogleMap.loadUrl(googleMapUrl) } //webView에 구글 지도 넣기

                        println("language : ${it.languages.toString()}")
                        println("language : ${it.languages.toString().indexOf(nativeNameTolanguage)}")

                        //language 데이터 정제
                       if(it.languages.toString().isEmpty()) {

                        }
                        else {
                            val languageIndex = it.languages.toString().indexOf(nativeNameTolanguage)
                            val languageIndex2 = it.languages.toString().indexOf(",", languageIndex)
                            val languageSubstring = it.languages.toString().substring(languageIndex,languageIndex2)
                            language_Input_Detail.text = languageSubstring
                        }



                    }

               }
            }

            override fun onFailure(call: Call<Country_Response_Detail>, t: Throwable) { //restrofit2 통신 실패했을 때(데이터 못가져옴)
                Log.d("this is error", t.message!! )
            }

        })

        backBtn_Detail.setOnClickListener{ //backBtn_Detail 클릭했을 시 뒤로가기
            finish()
        }

    }

}


