package com.sesori.null4u.config

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtUtil {
    @Value("\${jwt.secret-key}")
    private lateinit var SECRET_KEY: String


    fun generateToken(email: String): String {
        val claims = HashMap<String, Any>()
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(email)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10시간
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY.toByteArray()) // SECRET_KEY를 ByteArray로 변환
            .compact()
    }

    fun validateToken(token: String, email: String): Boolean {
        val extractedEmail = extractUsername(token)
        return (extractedEmail == email && !isTokenExpired(token))
    }

    fun extractUsername(token: String): String {
        return extractAllClaims(token).subject
    }

    private fun extractAllClaims(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(SECRET_KEY.toByteArray())
            .parseClaimsJws(token)
            .body
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractAllClaims(token).expiration.before(Date())
    }
}
