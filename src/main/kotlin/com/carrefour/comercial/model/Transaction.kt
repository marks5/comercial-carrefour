package com.carrefour.comercial.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity(name = "Transaction")
data class Transaction (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val debito: Boolean,
    val valor: Double,
    val data: Date
)


