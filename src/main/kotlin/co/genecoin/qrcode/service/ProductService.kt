package co.genecoin.qrcode.service

import co.genecoin.qrcode.model.*
import co.genecoin.qrcode.repository.*
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(val dao: ProductReposityImplement) : BasicCrud<String, Product> {

    override fun getById(id: String): Optional<Product> = dao.findById(id)

    fun getByToken(type: Int): Optional<Product> = dao.findByToken(type)

    override fun insert(obj: Product): Product = dao.insert(obj)

    fun getAll(): List<Product> = dao.findAll()

    override fun update(obj: Product): Product {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<Product> {
        TODO("Not yet implemented")
    }
}