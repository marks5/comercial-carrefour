package co.genecoin.qrcode.controllers

import co.genecoin.qrcode.model.*
import co.genecoin.qrcode.service.TrackerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/tracker")
class TrackerController {

    @Autowired
    lateinit var service: TrackerService

    @GetMapping
    fun getAll(): List<Tracker> = service.getAll()

    @GetMapping("{id}")
    fun getByAddress(@PathVariable id:String): Optional<Tracker> = service.getById(id)

    @PostMapping
    fun insert(@RequestBody asset: Tracker): Tracker = service.insert(asset)
}