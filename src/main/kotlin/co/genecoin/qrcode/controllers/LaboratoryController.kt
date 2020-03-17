package co.genecoin.qrcode.controllers

import co.genecoin.qrcode.model.*
import co.genecoin.qrcode.service.LaboratoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import java.util.*


@RestController
@RequestMapping("/api/laboratory")
class LaboratoryController {

    @Autowired
    lateinit var service: LaboratoryService

    @GetMapping
    fun getAll(): List<LaboratoryRegistry> = service.getAll()

    @GetMapping("{address}")
    fun getByAddress(@PathVariable address:String): Optional<LaboratoryRegistry> = service.findByAccount(address)

    @PostMapping
    fun insert(@RequestBody asset: LaboratoryRegistry): LaboratoryRegistry {
        if(service.findByAccount(asset.account).isPresent) return service.insert(asset)
        else throw IllegalArgumentException()
    }
}