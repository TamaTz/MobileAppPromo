package com.example.mobileapppromo.domain.item

import com.example.mobileapppromo.repository.PromoRepository
import javax.inject.Inject

class GetPromoUseCase @Inject constructor(private val promoRepository: PromoRepository){
    suspend operator fun invoke(): List<ItemPromo> {

        return promoRepository.getPromo().shuffled()
    }
}