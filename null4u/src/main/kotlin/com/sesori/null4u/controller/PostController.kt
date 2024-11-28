package com.sesori.null4u.controller

import com.sesori.null4u.dto.PostRequestDto
import com.sesori.null4u.entity.Post
import com.sesori.null4u.service.PostService
import com.sesori.null4u.util.DateTimeUtil
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")

class PostController(val postService: PostService) {

    @GetMapping("/lists")
    fun getPosts(): List<Post> {
        return postService.getAll()
    }

    /*@PostMapping("/create")
    fun createPost(@RequestBody post: Post) {
        return postService.createPost(post)
    }*/

    @PostMapping("/create")
    fun createPost(@RequestBody postRequest: PostRequestDto) {
        if (postRequest.contentTitle.isBlank()) {
            throw IllegalArgumentException("Title cannot be null or empty")
        }
        postService.createPost(
            Post(
                userIdx = postRequest.userIdx,
                contentTitle = postRequest.contentTitle,
                contentText = postRequest.contentText,
                createdAt = DateTimeUtil.getCurrentKST()
            )
        )
    }


}