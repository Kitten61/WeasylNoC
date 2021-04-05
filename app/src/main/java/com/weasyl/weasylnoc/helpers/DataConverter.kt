package com.weasyl.weasylnoc.helpers

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DataConverter {

    fun convert(time: String) : String {
        val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Locale.getDefault())
        val date = dateFormatter.parse("2020-08-26T21:04:30+00:00Z")
        val dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.getDefault())
        return dateFormat.format(date ?: Date())
    }

}