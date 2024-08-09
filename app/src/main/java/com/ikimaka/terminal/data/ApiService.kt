package com.ikimaka.terminal.data

import retrofit2.http.GET

interface ApiService {

    @GET("aggs/ticker/AAPL/range/1/hour/2022-01-09/2023-01-09?adjusted=true&sort=asc&limit=50001&apiKey=G00m4ojxMdILuS6AOxEZuBRDMuiJHoEB")
    suspend fun loadBars(): Result
}