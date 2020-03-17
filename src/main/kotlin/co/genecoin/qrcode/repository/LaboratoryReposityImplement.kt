package co.genecoin.qrcode.repository

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.Laboratory
import co.genecoin.qrcode.model.LaboratoryRegistry
import co.genecoin.qrcode.model.Tracker
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface LaboratoryReposityImplement : MongoRepository<LaboratoryRegistry, String>{
    fun findByAccount(address: String?): Optional<LaboratoryRegistry>
}