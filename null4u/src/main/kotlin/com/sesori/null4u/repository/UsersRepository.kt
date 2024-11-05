package com.sesori.null4u.repository

import com.sesori.null4u.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<User, Long> {
}