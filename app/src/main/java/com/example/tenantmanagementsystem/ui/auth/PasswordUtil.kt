package com.example.tenantmanagementsystem.ui.auth

import java.security.MessageDigest

fun hashPassword(password: String): String =
    MessageDigest.getInstance("SHA-256")
        .digest(password.toByteArray())
        .joinToString("") { "%02x".format(it) }