package com.syfsdi.ch6_dependencyinjctmvvm.network

import com.syfsdi.ch6_dependencyinjctmvvm.model.ResponseDataMakeupItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulAPI {

    @GET("api/v1/products.json")
    fun getAllMakeup(): Call<List<ResponseDataMakeupItem>>

}