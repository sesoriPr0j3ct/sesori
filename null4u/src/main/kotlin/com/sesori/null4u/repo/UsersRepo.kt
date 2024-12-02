package com.sesori.null4u.repo

import com.sesori.null4u.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepo : JpaRepository<User, Long> {
    fun findByUserEmail(email: String): User?
}