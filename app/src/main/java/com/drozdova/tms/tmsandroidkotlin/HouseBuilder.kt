package com.drozdova.tms.tmsandroidkotlin

class HouseBuilder (val builder: Builder) {

    fun hasSwPool() = builder.swimmingpool

    fun howManyStocks() = builder.stock

    companion object Builder {
        var stock: Int = 0
        var swimmingpool: Boolean = true

        fun setStock(stock: Int) = apply { this.stock = stock }
        fun setSwimmingPool(swPool: Boolean) = apply { this.swimmingpool = swPool }

        fun build(): HouseBuilder {
            return HouseBuilder(this)
        }
    }
}