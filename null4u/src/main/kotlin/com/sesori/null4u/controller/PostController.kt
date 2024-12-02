package com.sesori.null4u.controller

import com.sesori.null4u.dto.PostRequestDto
import com.sesori.null4u.entity.Post
import com.sesori.null4u.service.PostService
import com.sesori.null4u.util.DateTimeUtil
import com.sesori.null4u.vo.*
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")

class PostController(val postService: PostService) {

    @GetMapping("/lists")
    fun getPosts(): List<PostListVo> {
        val posts = postService.getAllSortedByPostIdx()

        return posts.map { post ->
            val formattedCreatedAt = DateTimeUtil.formatDate(post.createdAt)

            post.toListVo().copy(createdAt = formattedCreatedAt)
        }
    }

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

    @GetMapping("/view/{postIdx}")
    fun getPostDetail(@PathVariable postIdx: Long): PostViewVo {
        val post = postService.getPostDetail(postIdx)
        return post.toViewVo()
    }

}