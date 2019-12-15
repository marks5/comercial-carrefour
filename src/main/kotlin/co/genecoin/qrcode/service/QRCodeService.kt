package co.genecoin.qrcode.service

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.State
import co.genecoin.qrcode.repository.BasicCrud
import co.genecoin.qrcode.repository.QRCodeDAO
import org.springframework.stereotype.Service
import java.util.*

@Service
class QRCodeService(val qrcodeDAO: QRCodeDAO) : BasicCrud<String, Asset> {

    override fun getById(id: String): Optional<Asset> = qrcodeDAO.findById(id)

    override fun insert(obj: Asset): Asset = qrcodeDAO.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Asset): Asset {
        return if (qrcodeDAO.existsById(obj.uuid!!)) {
            qrcodeDAO.save(obj)
        } else {
            throw object : Exception("QRCode não encontrado.") {}
        }
    }

    override fun deleteById(id: String): Optional<Asset> {
        return qrcodeDAO.findById(id).apply {
            this.ifPresent {
                if(it.state == State.ATIVO){
                    it.state = State.DESATIVADO
                    qrcodeDAO.save(it)
                }
            }
        }
    }

    fun getAll(): List<Asset> = qrcodeDAO.findAll()
}