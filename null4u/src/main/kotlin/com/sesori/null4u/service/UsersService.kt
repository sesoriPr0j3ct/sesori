package com.sesori.null4u.service

import com.sesori.null4u.config.JwtUtil
import com.sesori.null4u.entity.User
import com.sesori.null4u.repo.UsersRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsersService @Autowired constructor(
    private val usersRepo: UsersRepo,
    private val jwtUtil: JwtUtil,
    private val passwordEncoder: PasswordEncoder
) {

    fun getAllUsers(): List<User> {
        return usersRepo.findAll()
    }

    fun createUser(user: User) {
        usersRepo.save(user)
    }

    fun register(user: User): User {
        val encodedPassword = passwordEncoder.encode(user.userPasswd)
        val newUser = user.copy(userPasswd = encodedPassword)

        return usersRepo.save(newUser)
    }

    fun getUserByEmail(email: String): User? {
        return usersRepo.findByUserEmail(email)
    }

    fun authenticateUser(email: String, password: String): String {
        val foundUser = usersRepo.findByUserEmail(email)
            ?: throw IllegalArgumentException("이메일 또는 비밀번호가 잘못되었습니다.")

        if (!passwordEncoder.matches(password, foundUser.userPasswd)) {
            throw IllegalArgumentException("이메일 또는 비밀번호가 잘못되었습니다.")
        }

        return jwtUtil.generateToken(foundUser.userEmail)
    }
}