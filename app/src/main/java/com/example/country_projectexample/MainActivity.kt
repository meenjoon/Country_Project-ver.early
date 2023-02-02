package com.example.country_projectexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.country_projectexample.datamodel.Country_Response
import com.example.country_projectexample.recyclerview.Recyclerview_Model
import com.example.country_projectexample.recyclerview.Recyclerview_Adapter
import com.example.country_projectexample.retrofit.CountriesService.retrofitService

import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var RecyclerviewAdapter: Recyclerview_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val searchView = findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(searchViewTextListener)


//        val CountryList = ArrayList<Recyclerview_Model>()
//        CountryList.add(Recyclerview_Model("서울","Republic Of Korea","대한민국","국기","Korea"))
//        CountryList.add(Recyclerview_Model("서울","Republic Of Korea","미국","국기","Korea"))
//        CountryList.add(Recyclerview_Model("서울","Republic Of Korea","멕시코","국기","Korea"))
//        CountryList.add(Recyclerview_Model("서울","Republic Of Korea","아프리카","국기","Korea"))
//        setAdapter(CountryList)


        /*
        object 클래스로부터 retrofitService를 가져온다. 이 retrofitService는 CountriesApi 형태로 반환이 되는데 CountriesApi는 인터페이스 형식이다.
        CountriesApi에 있는 메서드들은 직접적으로 데이터를 가져올 수 있게 해주는 @GET, @PATH, @QUERY 등을 이용해 작성하고 원하는 URL에 있는 데이터를 가져 올 수 있게 해준다,
         MainActivity에서는 CountriesApi 인터페이스 안에 있는 메서드들 중 getCountries()를 사용하여
         https://restcountries.com/v3.1/all?fields=name,capital,translations,flags 의 url에 값을 가져온다.
        여기 위에 있는 url에 있는 값들은 json 형식이다. 이것을 자동적으로 변환을 해줘야하는데 이것은 retrofitService를 만들때 GsonConverterFactory를 이용하여 자동 변환을 하게 만들어줬다.
         */
        retrofitService.getCountries().enqueue(object : retrofit2.Callback<Country_Response> {

            override fun onResponse( //restrofit2 통신 성공했을 때(데이터 가져옴)
                call: Call<Country_Response>,
                response: Response<Country_Response>
            ) {
                if (response.isSuccessful) { //가져오는 데이터는 response인데, 이것은 Country_Response 형태이다.

                    val body = response.body() //response안의 데이터를 가져오기 위한 body 변수
                    body?.let { it ->

                        val CountryList = ArrayList<Recyclerview_Model>() //리사이클러뷰에 넣기 위한 Recycleview_Model 형식을 갖춘 ArrayList 생성


                        /*
                            Countries API로 부터 가져온 데이터 파싱(capital, enName_Official, korName_common, flag, enName_Common)
                         */
//                        val enName_Official = it.forEach {  it.name.toString().substring(14, it.name.toString().length-1) }
//                        val capital = it.forEach { it.capital.toString().substring(1,it.capital.toString().length-1) }
//                        val korName_common =  it.forEach { it.translations?.kor.toString().substring(13,it.translations?.kor.toString().length-1)}
//                        val flag = it.forEach { it.flags?.png.toString() }
//                        val enName_Common = it.forEach { it.name?.enName_Common.toString() }


                        /*리사이클러뷰에 연결을 위한 데이터모델인 CountryList에 (capital, enName_Official, korName_common, flag, enName_Common)을 넣어준다.
                        */
                        it.forEach {
                            CountryList.add(Recyclerview_Model(
                            it.capital.toString().substring(1,it.capital.toString().length-1) // 수도 이름
                            ,it.name?.enName_Official.toString().substring(0, it.name?.enName_Official.toString().length) // 공식 이름
//                            ,it.translations?.kor.toString().substring(13,it.translations?.kor.toString().length-1) // official 한국 이름
                            ,it.translations?.kor?.korName_Common.toString() // common 한국 이름
                            ,it.flags?.png.toString() //국기 png
                        ,it.name?.enName_Common.toString())) //흔한 국가 이름(리사이클러뷰를 통해 국가를 클릭했을때 자세한 정보를 보여주기 위해 정보를 넣었음)
                        }

                        setAdapter(CountryList) //리사이클러뷰에 연결을 위한 데이터모델인 CountryList를 연결시켜준다.(이미 CountryList에는 값이 들어 있음)
                    }
                }
            }

            override fun onFailure(call: Call<Country_Response>, t: Throwable) { //restrofit2 통신 실패했을 때(데이터 못가져옴)
                Log.d("this is error", t.message!! )

            }
        })
    }

    /*
      리사이클러뷰와 리사이클러뷰 데이터모델(Recyclerview_Model)과 연결시켜주는 함수 생성
     */
    private fun setAdapter(CountryList : ArrayList<Recyclerview_Model>) {

        val recyclerview = findViewById<RecyclerView>(R.id.countriesList) //xml의 리사이클러뷰 아이템 부분 인스턴스 획득
        RecyclerviewAdapter = Recyclerview_Adapter(this, CountryList ) //리사이클러뷰 어댑터 인스턴스를 생성해주기 위해 매개변수인 context와 리사이클러뷰 데이터 모델인 Recyclerview_Model을 매개변수로 받는다.
        recyclerview.adapter = RecyclerviewAdapter //xml 리사이클러뷰의 인스턴스의 내부 함수인 .adapter 함수를 통해 만든 어댑터 인스턴스 연결해주기
        recyclerview.layoutManager = LinearLayoutManager(this) //수평,수직으로 배치시켜주는 레이아웃 매니저 설정

    }

    var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("Recyclerview", "newText: $newText")
                RecyclerviewAdapter.filter.filter(newText)
                return true
            }
        }
}
