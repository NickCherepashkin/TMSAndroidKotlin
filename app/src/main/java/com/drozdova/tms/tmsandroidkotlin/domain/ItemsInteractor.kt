package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository

class ItemsInteractor(private val itemsRepository: ItemsRepository) {
    fun getItemslist() : List<Item>{
        return itemsRepository.getItemsList()
    }
}