package com.example.retrofit.activities

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.R
import com.example.retrofit.model.PaginateResponse
import com.example.retrofit.model.Pokemon
import com.example.retrofit.service.ActivityServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var activityText1: TextView
    private lateinit var activityText2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityText1 = findViewById(R.id.act_txt1)
        activityText2 = findViewById(R.id.act_txt2)

        loadPokemon()
    }

    fun loadPokemon(){

        val service = ActivityServiceApiBuilder.create()

        service.getPokemon().enqueue(object : Callback<PaginateResponse<Pokemon>> {
            override fun onResponse(call: Call<PaginateResponse<Pokemon>>, response: Response<PaginateResponse<Pokemon>>) {
                Log.e("Example", "Esta va segundo")

                if (response.isSuccessful) {
                    val responsePokemon = response.body()

                    activityText1.text = responsePokemon?.count.toString()
                    activityText2.text = responsePokemon?.results?.get(3)?.name.toString()
                }

            }

            override fun onFailure(call: Call<PaginateResponse<Pokemon>>, t: Throwable) {
                Log.e("Example", t.stackTraceToString())
            }
        })

    }
}