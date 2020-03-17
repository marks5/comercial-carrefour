package co.genecoin.qrcode.service

import co.genecoin.qrcode.model.*
import co.genecoin.qrcode.repository.*
import org.springframework.stereotype.Service
import java.util.*

@Service
class OwnerService(val dao: OwnerReposityImplement) : BasicCrud<String, Owner> {

    override fun getById(id: String): Optional<Owner> = dao.findById(id)

    fun findByAccount(address: String): Optional<Owner> = dao.findByAccount(address)

    override fun insert(obj: Owner): Owner = dao.insert(obj)

    fun getAll(): List<Owner> = dao.findAll()

    override fun update(obj: Owner): Owner {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<Owner> {
        TODO("Not yet implemented")
    }
}