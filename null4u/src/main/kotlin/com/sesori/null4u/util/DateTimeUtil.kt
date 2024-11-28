package com.sesori.null4u.util

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateTimeUtil {
    private val KST_ZONE: ZoneId = ZoneId.of("Asia/Seoul")
    private val DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    fun getCurrentKST(): LocalDateTime {
        return LocalDateTime.now(KST_ZONE)
    }

    fun getFormattedCurrentKST(): String {
        return getCurrentKST().format(DATE_TIME_FORMATTER)
    }
}
