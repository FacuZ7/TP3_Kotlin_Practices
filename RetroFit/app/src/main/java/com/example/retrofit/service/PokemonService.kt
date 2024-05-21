package com.example.retrofit.service


import com.example.retrofit.model.PaginateResponse
import com.example.retrofit.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET("api/v2/pokemon")
    fun getPokemon(): Call<PaginateResponse<Pokemon>>
    @GET("api/v2/ability")
    fun getPokemonAbility(): Call<PaginateResponse<Pokemon>>
}