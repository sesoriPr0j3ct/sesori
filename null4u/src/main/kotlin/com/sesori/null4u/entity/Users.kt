package com.sesori.null4u.entity

import java.util.*
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userIdx: Long? = null,
    @Column(name = "user_name", nullable = false, unique = true)
    val userName: String,
    @Column(name = "user_passwd", nullable = false)
    val userPasswd: String,
    @Column(name = "user_email", nullable = false, unique = true)
    val userEmail: String,
    @Column(name = "reg_date", nullable = false)
    var regDate: Date = Date(),  // 기본값으로 현재 날짜 설정
    @Column(name = "phone_num", nullable = false)
    val phoneNum: String
) {
    @PrePersist
    fun prePersist() {
        regDate = Date()
    }
}
