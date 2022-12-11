package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository

class ListInteractor(private val itemsRepository: ItemsRepository) {
    fun getData() : List<Item>{
        return itemsRepository.getData()
    }
}