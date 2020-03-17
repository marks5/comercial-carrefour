package co.genecoin.qrcode.repository

import co.genecoin.qrcode.model.*
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface BiomassReposityImplement : MongoRepository<BiomassRegistry, String>{
    fun findByBioType(bioType: Int): Optional<BiomassRegistry>
}