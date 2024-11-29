package com.sesori.null4u.vo

import com.sesori.null4u.entity.Post
import java.time.LocalDateTime

data class PostListVo(
    val postIdx: Long,
    val userName: String?,
    val contentTitle: String,
    val createdAt: String?,
    val viewCount: Int,
    val likeCount: Int,
    val commentCount: Int
)

fun Post.toListVo() = PostListVo(
    postIdx = postIdx,
    userName = user?.userName,
    contentTitle = contentTitle,
    createdAt = createdAt.toString(),
    viewCount = viewCount,
    likeCount = likeCount,
    commentCount = commentCount
)

