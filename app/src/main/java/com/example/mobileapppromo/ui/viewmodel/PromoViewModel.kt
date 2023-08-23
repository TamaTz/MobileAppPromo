package com.example.mobileapppromo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapppromo.data.model.DetailPromo
import com.example.mobileapppromo.domain.item.GetPromoByIdUseCase
import com.example.mobileapppromo.domain.item.GetPromoUseCase
import com.example.mobileapppromo.domain.item.ItemPromo
import kotlinx.coroutines.launch
import javax.inject.Inject

class PromoViewModel @Inject constructor(

    private val getPromosUseCase: GetPromoUseCase,
    private val getPromoByIdUseCase: GetPromoByIdUseCase

) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _promos = MutableLiveData<List<ItemPromo>>()
    val promos: LiveData<List<ItemPromo>> get() = _promos

    private val _promo = MutableLiveData<DetailPromo>()
    val promo: LiveData<DetailPromo> get() = _promo

    init {
        getPromo()
    }

    private fun getPromo() {

        viewModelScope.launch {

            try {
                _isLoading.value = true
                val promos = getPromosUseCase()
                _promos.value = promos

            } catch (_: Exception) {

            } finally {
                _isLoading.value = false
            }

        }

    }

    fun getPromoById(id: Int) {

        viewModelScope.launch {

            try {

                val promo = getPromoByIdUseCase(id)
                _promo.value = promo
                Log.d("PromoViewModel", "Promo loaded: $promo")

            } catch (e: Exception) {
                Log.d("PromoViewModel", "Promo Id: $id")
                Log.e("PromoViewModel", "Error loading promo", e)
            }

        }

    }

}