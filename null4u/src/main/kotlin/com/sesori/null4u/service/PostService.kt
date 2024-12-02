package com.sesori.null4u.service

import com.sesori.null4u.entity.Post
import com.sesori.null4u.repo.PostRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(
    private val postRepo: PostRepo
) {

    fun getAll(): List<Post> {
        return postRepo.findAll()
    }

    fun createPost(post: Post) {
        postRepo.save(post)
    }

    fun updatePost(post: Post) {
        postRepo.save(post)
    }

    fun deletePost(post: Post) {
        postRepo.delete(post)
    }

    fun getAllSortedByPostIdx(): List<Post> {
        return postRepo.findAllByOrderByPostIdxDesc()
    }

    fun getPostDetail(idx: Long): Post {
        return postRepo.findById(idx).orElseThrow {
            IllegalArgumentException("Post not found with id: $idx")
        }
    }
}