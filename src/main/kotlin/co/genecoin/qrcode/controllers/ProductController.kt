package co.genecoin.qrcode.controllers

import co.genecoin.qrcode.model.*
import co.genecoin.qrcode.service.HarvesterService
import co.genecoin.qrcode.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import java.util.*


@RestController
@RequestMapping("/api/product")
class ProductController {

    @Autowired
    lateinit var service: ProductService

    @GetMapping
    fun getAll(): List<Product> = service.getAll()

    @GetMapping("{token}")
    fun getByToken(@PathVariable token:Int): Optional<Product> = service.getByToken(token)

    @PostMapping
    fun insert(@RequestBody asset: Product): Product? {
        if(!service.getByToken(asset.token).isPresent) return service.insert(asset)
        else throw IllegalArgumentException("Já existe um produto registrado com esse TOKEN")
    }
}