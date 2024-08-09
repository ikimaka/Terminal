package com.ikimaka.terminal.data

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("results")
    val barList: List<Bar>
)
