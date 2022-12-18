package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import javax.inject.Inject

class ListInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    fun getData() : List<Item>{
        return itemsRepository.getData()
    }
}