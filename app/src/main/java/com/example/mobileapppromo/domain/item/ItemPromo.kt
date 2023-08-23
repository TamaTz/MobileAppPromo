package com.example.mobileapppromo.domain.item

import com.example.mobileapppromo.data.model.Image

data class ItemPromo(
    val id: Int,
    val nama: String,
    val img: Image,
    val desc: String
)