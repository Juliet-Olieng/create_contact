package com.juliet.contact2app.database

import androidx.room.TypeConverter

class IntArrayConverter {
    @TypeConverter
    fun fromIntArray(intArray: Array<Int>): String {
        return intArray.joinToString(",")
    }

    @TypeConverter
    fun toIntArray(intArrayString: String): Array<Int> {
        return intArrayString.split(",").map { it.toInt() }.toTypedArray()
    }

}


