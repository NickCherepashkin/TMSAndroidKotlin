package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    fun getItemslist() : List<Item>{
        return itemsRepository.getItemsList()
    }
}