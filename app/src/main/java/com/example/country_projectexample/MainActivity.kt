package com.example.country_projectexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.country_projectexample.datamodel.Country_Response
import com.example.country_projectexample.recyclerview.Recyclerview_Model
import com.example.country_projectexample.recyclerview.Recyclerview_Adapter
import com.example.country_projectexample.retrofit.CountriesApi
import com.example.country_projectexample.retrofit.CountriesService.retrofit

import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitService = retrofit.create(CountriesApi::class.java)


        retrofitService.getCountries().enqueue(object : retrofit2.Callback<Country_Response> {
            override fun onResponse(
                call: Call<Country_Response>,
                response: Response<Country_Response>
            ) {
                if (response.isSuccessful) {

                    val body = response.body()
                    body?.let { it ->

                        val CountryList = ArrayList<Recyclerview_Model>()

                        /*
                            Countries API로 부터 가져온 데이터 파싱
                         */
//                        val officialName = it.forEach {  it.name.toString().substring(14, it.name.toString().length-1) }
//                        val capital = it.forEach { it.capital.toString().substring(1,it.capital.toString().length-1) }
//                        val korName_common =  it.forEach { it.translations?.kor.toString().substring(13,it.translations?.kor.toString().length-1)}
//                        val picture = it.forEach { it.flags?.png.toString() }


                        it.forEach { CountryList.add(Recyclerview_Model(
                            it.capital.toString().substring(1,it.capital.toString().length-1) // 수도 이름
                            ,it.name.toString().substring(14, it.name.toString().length-1) // 공식 이름
//                            ,it.translations?.kor.toString().substring(13,it.translations?.kor.toString().length-1) // official 한국 이름
                            ,it.translations?.kor?.korName_Common.toString() // 흔한 한국 이름
                            ,it.flags?.png.toString())) //국기 png

                        }

                        setAdapter(CountryList)

                    }
                }
            }

            override fun onFailure(call: Call<Country_Response>, t: Throwable) {
                Log.d("this is error", t.message!! )
            }
        })
    }


    private fun setAdapter(CountryList : ArrayList<Recyclerview_Model>) {
        val recyclerview = findViewById<RecyclerView>(R.id.countriesList)
        val mAdapter = Recyclerview_Adapter(this, CountryList )
        recyclerview.adapter = mAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)

    }
}
