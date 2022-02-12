package com.example.tt_hh

fun getSortedArray(n: Int): String {
    var index = 1
    var result = ""

    val checkSizeItem: MutableSet<Int> = mutableSetOf()

    while (index <= n) {

        val item = Array((2..(n + 5)).random()) { (0..99).random() }

        if (checkSizeItem.add(item.size)){
            val sortedItem : List<Int> = if (index % 2 == 0) {
                item.toList().sortedBy { it }
            }else
                item.toList().sortedByDescending { it }
            result += "$sortedItem \n"
            index++
        }
    }

    return "press enter to start over \n $result"
}
