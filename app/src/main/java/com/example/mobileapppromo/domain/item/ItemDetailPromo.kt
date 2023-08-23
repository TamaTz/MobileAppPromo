package com.example.mobileapppromo.domain.item

import com.example.mobileapppromo.data.model.DetailPromo
import com.example.mobileapppromo.data.model.Image

data class ItemDetailPromo(

    val id: Int,
    val nama: String,
    val img: Image,
    val desc: String

)

fun DetailPromo.toItemDetailPromo() = ItemDetailPromo(id, nama, img, desc)