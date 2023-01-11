package com.drozdova.tms.tmsandroidkotlin.domain.items

import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import javax.inject.Inject

class ItemsListInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    suspend fun getData() : List<Item>{
        val list = itemsRepository.getData()
        if(list.isEmpty()) {
            throw Exception()
        } else return list
    }
}