package co.genecoin.qrcode.service

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.Harvester
import co.genecoin.qrcode.model.State
import co.genecoin.qrcode.model.Tracker
import co.genecoin.qrcode.repository.BasicCrud
import co.genecoin.qrcode.repository.HarvesterReposityImplement
import co.genecoin.qrcode.repository.QRCodeReposityImplement
import co.genecoin.qrcode.repository.TrackerReposityImplement
import org.springframework.stereotype.Service
import java.util.*

@Service
class HarvesterService(val dao: HarvesterReposityImplement) : BasicCrud<String, Harvester> {

    override fun getById(id: String): Optional<Harvester> = dao.findById(id)

    fun findByAccount(address: String): Optional<Harvester> = dao.findByAccount(address)

    override fun insert(obj: Harvester): Harvester = dao.insert(obj)

    fun getAll(): List<Harvester> = dao.findAll()

    override fun update(obj: Harvester): Harvester {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<Harvester> {
        TODO("Not yet implemented")
    }
}