package com.ikimaka.terminal.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("aggs/ticker/AAPL/range/{timeframe}/2022-01-09/2023-01-09?adjusted=true&sort=desc&limit=50001&apiKey=G00m4ojxMdILuS6AOxEZuBRDMuiJHoEB")
    suspend fun loadBars(
        @Path("timeframe") timeFrame: String
    ): Result
}