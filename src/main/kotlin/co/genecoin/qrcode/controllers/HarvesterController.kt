package co.genecoin.qrcode.controllers

import co.genecoin.qrcode.model.*
import co.genecoin.qrcode.service.HarvesterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import java.util.*


@RestController
@RequestMapping("/api/harvester")
class HarvesterController {

    @Autowired
    lateinit var service: HarvesterService

    @GetMapping
    fun getAll(): List<Harvester> = service.getAll()

    @GetMapping("{address}")
    fun getByAddress(@PathVariable address:String): Optional<Harvester> = service.findByAccount(address)

    @PostMapping
    fun insert(@RequestBody asset: Harvester): Harvester? {
        if(!service.findByAccount(asset.account).isPresent) return service.insert(asset)
        else throw IllegalArgumentException()
    }
}