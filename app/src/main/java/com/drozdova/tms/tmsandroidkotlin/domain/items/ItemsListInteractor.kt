package com.drozdova.tms.tmsandroidkotlin.domain.items

import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import javax.inject.Inject

class ItemsListInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    suspend fun getData() : List<UserInfo>{
        return itemsRepository.getData()
    }
}