package com.drozdova.tms.tmsandroidkotlin.domain.items

import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import javax.inject.Inject

class ItemsListInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    fun getData() : List<Item>{
        return itemsRepository.getData()
    }
}