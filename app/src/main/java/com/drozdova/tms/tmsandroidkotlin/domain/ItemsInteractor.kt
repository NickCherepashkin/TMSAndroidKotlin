package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {
    fun getData() : List<ItemsModel> {
        return itemsRepository.getData()
    }
}