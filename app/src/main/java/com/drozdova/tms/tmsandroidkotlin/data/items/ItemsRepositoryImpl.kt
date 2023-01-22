package com.drozdova.tms.tmsandroidkotlin.data.items

import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ItemsRepository {
    override suspend fun getData() : List<UserInfo> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getData()
            return@withContext response.body() ?: kotlin.run { emptyList() }
//            listOf(
//                Item(R.drawable.hh, "Hip-hop", "it is cool dance style",""),
//                Item(R.drawable.contemp, "Contemporary", "it is cool dance style",""),
//                Item(R.drawable.krump, "Krump", "it is cool dance style",""),
//                Item(R.drawable.locking, "Locking", "it is cool dance style",""),
//                Item(R.drawable.house, "House", "it is cool dance style",""),
//                Item(R.drawable.belly, "Belly", "it is cool dance style",""),
//                Item(R.drawable.break_dance, "Break dance", "it is cool dance style",""),
//                Item(R.drawable.house, "House", "it is cool dance style",""),
//                Item(R.drawable.hh, "Hip-hop", "it is cool dance style",""),
//                Item(R.drawable.locking, "Locking", "it is cool dance style",""),
//                Item(R.drawable.krump, "Krump", "it is cool dance style","")
//            )
        }
    }
}