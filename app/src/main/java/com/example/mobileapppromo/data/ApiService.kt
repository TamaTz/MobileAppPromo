package com.example.mobileapppromo.data

import android.util.Log
import com.example.mobileapppromo.data.model.DetailPromo
import com.example.mobileapppromo.data.model.Promo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val api: Api){

    suspend fun getPromo(): List<Promo>{

        return withContext(Dispatchers.IO){
            val api = api.getPromo()
            api.body() ?: emptyList()
        }
    }

    suspend fun getPromoById(id:  Int): DetailPromo {
        return withContext(Dispatchers.IO){
            Log.d("ApiService", "Fetching With ID $id")

            val apiResponse = api.getPromoById(id)
            val apiResponseBody = apiResponse.body()

            if(apiResponse.isSuccessful){
                Log.d("ApiService", "Api Response Code: ${apiResponse.code()}")
                Log.d("ApiService", "Api Response Body: $apiResponseBody")

                apiResponseBody ?: throw Exception("Api response body is null")
            }else{
                val errorBody = apiResponse.errorBody()?.string()
                Log.e("ApiService", "Api Error Response Code: ${apiResponse.code()}")
                Log.e("ApiService", "Api Error Response Body: $errorBody")
                throw Exception("Api request failed with code ${apiResponse.code()}")
            }
        }
    }
}