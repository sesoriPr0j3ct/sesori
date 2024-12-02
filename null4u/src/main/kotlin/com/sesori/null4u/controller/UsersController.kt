package com.sesori.null4u.controller

import com.sesori.null4u.config.JwtUtil
import com.sesori.null4u.dto.UsersLoginDTO
import com.sesori.null4u.entity.User
import com.sesori.null4u.service.UsersService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
class UsersController(
    val usersService: UsersService,
    private val jwtUtil: JwtUtil,
    private val passwordEncoder: PasswordEncoder
) {

    @GetMapping("/list")
    fun getUsers(): List<User> {
        return usersService.getAllUsers()
    }

    @PostMapping("/register")
    fun register(@RequestBody user: User) {
        usersService.register(user)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: UsersLoginDTO): ResponseEntity<String> {
        val foundUser = usersService.getUserByEmail(request.userEmail)
            ?: return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이메일 또는 비밀번호가 잘못되었습니다.")

        if (!passwordEncoder.matches(request.userPasswd, foundUser.userPasswd)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이메일 또는 비밀번호가 잘못되었습니다.")
        }

        // JWT 생성
        val token = jwtUtil.generateToken(foundUser.userEmail)

        // JWT를 Authorization 헤더에 포함
        return ResponseEntity.ok()
            .header("Authorization", "Bearer $token") // 헤더에 토큰 포함
            .body("로그인 성공")
    }

}