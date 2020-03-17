package co.genecoin.qrcode.service

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.BiomassRegistry
import co.genecoin.qrcode.model.State
import co.genecoin.qrcode.model.Tracker
import co.genecoin.qrcode.repository.BasicCrud
import co.genecoin.qrcode.repository.BiomassReposityImplement
import co.genecoin.qrcode.repository.QRCodeReposityImplement
import co.genecoin.qrcode.repository.TrackerReposityImplement
import org.springframework.stereotype.Service
import java.util.*

@Service
class BiomassService(val dao: BiomassReposityImplement) : BasicCrud<String, BiomassRegistry> {

    override fun getById(id: String): Optional<BiomassRegistry> = dao.findById(id)

    override fun insert(obj: BiomassRegistry): BiomassRegistry = dao.insert(obj)

    fun getAll(): List<BiomassRegistry> = dao.findAll()

    override fun update(obj: BiomassRegistry): BiomassRegistry {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<BiomassRegistry> {
        TODO("Not yet implemented")
    }
}