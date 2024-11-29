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

    fun formatDate(createdAt: LocalDateTime): String? {
        val now = LocalDateTime.now()

        // 오늘 날짜와 비교
        return if (createdAt.toLocalDate() == now.toLocalDate()) {
            // 오늘 날짜라면 시간만 표시
            createdAt.format(DateTimeFormatter.ofPattern("HH:mm"))
        } else {
            // 아닐 경우 날짜만 표시
            createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        }
    }
}
