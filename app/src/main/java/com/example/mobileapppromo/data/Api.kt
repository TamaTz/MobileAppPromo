package com.example.mobileapppromo.data

import com.example.mobileapppromo.data.model.DetailPromo
import com.example.mobileapppromo.data.model.Promo
import com.example.mobileapppromo.utility.BaseUrl.Companion.PROMOS_ENDPOINT
import com.example.mobileapppromo.utility.BaseUrl.Companion.PROMO_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(PROMOS_ENDPOINT)
    suspend fun getPromo(): Response<List<Promo>>

    @GET(PROMO_ID_ENDPOINT)
    suspend fun getPromoById(@Query(value = "id")id:  Int) : Response<DetailPromo>
}