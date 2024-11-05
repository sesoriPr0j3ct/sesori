package com.sesori.null4u.entity

import java.util.*
import jakarta.persistence.*;

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userIdx: Int? = null,
    @Column(name = "user_name", nullable = false, unique = true)
    val userName: String,
    @Column(name = "user_passwd", nullable = false)
    val userPasswd: String,
    @Column(name = "user_email", nullable = false, unique = true)
    val userEmail: String,
    @Column(name = "reg_date", nullable = false)
    val regDate: Date,
    @Column(name = "phone_num", nullable = false)
    val phoneNum: String
)
