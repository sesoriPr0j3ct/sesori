package com.sesori.null4u.repo


import com.sesori.null4u.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo : JpaRepository<Post, Long> {
    fun findAllByOrderByPostIdxDesc(): List<Post>
}