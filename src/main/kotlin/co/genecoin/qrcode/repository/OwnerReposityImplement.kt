package co.genecoin.qrcode.repository

import co.genecoin.qrcode.model.*
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface OwnerReposityImplement : MongoRepository<Owner, String>{
    fun findByAccount(address: String?): Optional<Owner>
}