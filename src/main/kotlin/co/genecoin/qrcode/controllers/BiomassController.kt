package co.genecoin.qrcode.controllers

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.Biomass
import co.genecoin.qrcode.model.BiomassRegistry
import co.genecoin.qrcode.model.ZXingHelper
import co.genecoin.qrcode.service.BiomassService
import co.genecoin.qrcode.service.QRCodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.io.OutputStream
import java.util.*
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/api/biomass")
class BiomassController {

    @Autowired
    lateinit var service: BiomassService

    @GetMapping
    fun getAll(): List<BiomassRegistry> = service.getAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id:String): Optional<BiomassRegistry> = service.getById(id)

    @PostMapping
    fun insert(@RequestBody asset: BiomassRegistry): BiomassRegistry = service.insert(asset)
}