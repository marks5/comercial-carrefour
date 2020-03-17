package co.genecoin.qrcode.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Owner(
        val account: String,
        val name: String,
        val email: String
)