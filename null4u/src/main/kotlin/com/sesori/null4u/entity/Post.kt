package com.sesori.null4u.entity;

import com.sesori.null4u.util.DateTimeUtil
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "post")
data class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "post_idx")
        val postIdx: Long = 0,

        @Column(name = "user_idx", nullable = false)
        val userIdx: Long,

        @Column(name = "content_title", length = 50, nullable = false)
        val contentTitle: String,

        @Column(name = "content_text", columnDefinition = "TEXT", nullable = false)
        val contentText: String,

        @Column(name = "created_at", nullable = false)
        val createdAt: LocalDateTime = DateTimeUtil.getCurrentKST(),

        @Column(name = "view_count", nullable = false)
        val viewCount: Int = 0,

        @Column(name = "like_count", nullable = false)
        val likeCount: Int = 0,

        @Column(name = "comment_count", nullable = false)
        val commentCount: Int = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_idx", insertable = false, updatable = false)
        val user: User? = null // `User` 엔티티와 매핑
)
