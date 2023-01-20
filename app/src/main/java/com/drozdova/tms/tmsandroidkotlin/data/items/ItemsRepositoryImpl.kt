package com.drozdova.tms.tmsandroidkotlin.data.items

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.ApiServiceSecond
import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import javax.inject.Inject
import javax.inject.Named

class ItemsRepositoryImpl @Inject constructor(
    @Named("FIRST") private val apiService: ApiService,
    @Named("SECOND") private val apiServiceSecond: ApiServiceSecond,
) : ItemsRepository {
    override suspend fun getItemsList() : List<Item> {
        val responseSecond = apiServiceSecond.getPhotoById(13)
        Log.w("SECOND RESPONSE", responseSecond.body()?.title.toString())

        val responseSecondQuery = apiServiceSecond.getPhotoByTitle("iusto sunt nobis quasi veritatis quas expedita voluptatum deserunt")
        Log.w("THIRD RESPONSE", responseSecondQuery.body()!!.get(0).toString())

        val response = apiService.getData()
        return withContext(Dispatchers.IO) {
            response.body()?.sampleList?.let {
                it.map {
                    Item(it.description, it.imageUrl)
                }
                } ?: kotlin.run {
                emptyList()
            }
        }
//        return withContext(Dispatchers.IO){
//            listOf(
//                Item(
//                    R.drawable.android,
//                    "Android",
//                    "26.02.2022"
//                ),
//                Item(
//                    R.drawable.apple,
//                    "IOS",
//                    "26.02.2022"
//                ),
//                Item(
//                    R.drawable.dot_net,
//                    ".Net",
//                    "26.02.2022"
//                ),
//                Item(
//                    R.drawable.delphi,
//                    "Delphi",
//                    "26.02.2022"
//                ),
//                Item(
//                    R.drawable.java,
//                    "Java",
//                    "26.02.2022"
//                ),
//                Item(
//                    R.drawable.python,
//                    "Python",
//                    "26.02.2022"
//                ),
//                Item(
//                    R.drawable.js,
//                    "Java Script",
//                    "26.02.2022"
//                ),
//                Item(
//                    R.drawable.android,
//                    "Android",
//                    "26.02.2022"
//                ),
//                Item(
//                    R.drawable.apple,
//                    "IOS",
//                    "26.02.2022"
//                )
//            )
//        }
    }
}