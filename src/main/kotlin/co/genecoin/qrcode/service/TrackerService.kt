package co.genecoin.qrcode.service

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.State
import co.genecoin.qrcode.model.Tracker
import co.genecoin.qrcode.repository.BasicCrud
import co.genecoin.qrcode.repository.QRCodeReposityImplement
import co.genecoin.qrcode.repository.TrackerReposityImplement
import org.springframework.stereotype.Service
import java.util.*

@Service
class TrackerService(val dao: TrackerReposityImplement) : BasicCrud<String, Tracker> {

    override fun getById(id: String): Optional<Tracker> = dao.findById(id)

    override fun insert(obj: Tracker): Tracker = dao.insert(obj)

    fun getAll(): List<Tracker> = dao.findAll()

    override fun update(obj: Tracker): Tracker {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<Tracker> {
        TODO("Not yet implemented")
    }
}