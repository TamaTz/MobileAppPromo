package com.example.mobileapppromo.domain.item

import android.util.Log
import com.example.mobileapppromo.data.model.DetailPromo
import com.example.mobileapppromo.repository.PromoRepository
import javax.inject.Inject

class GetPromoByIdUseCase @Inject constructor(private val promoRepository: PromoRepository){

    suspend operator fun invoke(id: Int): DetailPromo {
        val promoItem = promoRepository.getPromoById(id)
        Log.d("GetPromoByIdUseCase", "Promo Item Retrieved: $promoItem")
        return promoRepository.getPromoById(id)

    }
}