package co.genecoin.qrcode.repository

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.Harvester
import co.genecoin.qrcode.model.Tracker
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface HarvesterReposityImplement : MongoRepository<Harvester, String>{
    fun findByAccount(address: String?): Optional<Harvester>
}