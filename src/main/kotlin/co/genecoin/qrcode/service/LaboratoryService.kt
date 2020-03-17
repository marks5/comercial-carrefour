package co.genecoin.qrcode.service

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.LaboratoryRegistry
import co.genecoin.qrcode.model.State
import co.genecoin.qrcode.model.Tracker
import co.genecoin.qrcode.repository.BasicCrud
import co.genecoin.qrcode.repository.LaboratoryReposityImplement
import co.genecoin.qrcode.repository.QRCodeReposityImplement
import co.genecoin.qrcode.repository.TrackerReposityImplement
import org.springframework.stereotype.Service
import java.util.*

@Service
class LaboratoryService(val dao: LaboratoryReposityImplement) : BasicCrud<String, LaboratoryRegistry> {

    override fun getById(id: String): Optional<LaboratoryRegistry> = dao.findById(id)

    fun findByAccount(address: String): Optional<LaboratoryRegistry> = dao.findByAccount(address)

    override fun insert(obj: LaboratoryRegistry): LaboratoryRegistry = dao.insert(obj)

    fun getAll(): List<LaboratoryRegistry> = dao.findAll()

    override fun update(obj: LaboratoryRegistry): LaboratoryRegistry {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<LaboratoryRegistry> {
        TODO("Not yet implemented")
    }
}