package co.genecoin.qrcode.repository

import co.genecoin.qrcode.model.*
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ProductReposityImplement : MongoRepository<Product, String>{
    fun findByToken(bioType: Int): Optional<Product>
}