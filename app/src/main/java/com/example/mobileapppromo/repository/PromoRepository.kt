package com.example.mobileapppromo.repository

import android.util.Log
import com.example.mobileapppromo.data.ApiService
import com.example.mobileapppromo.data.model.DetailPromo
import com.example.mobileapppromo.domain.item.ItemPromo
import com.example.mobileapppromo.domain.item.toItemDetailPromo
import javax.inject.Inject

class PromoRepository @Inject constructor(private val api: apiservice) {

    suspend fun getPromo(): List<ItemPromo> {

        return ApiService.getPromo().map {
            it.toItemPromo()
        }

    }

    suspend fun getPromoById(id: Int): DetailPromo {
        Log.d("PromoRepository", "Id: $id")
        val response = apiService.getPromoById(id)
        Log.d("PromoRepository", "Response: $response")
        return api.getPromoById(id).toItemDetailPromo()

    }
}