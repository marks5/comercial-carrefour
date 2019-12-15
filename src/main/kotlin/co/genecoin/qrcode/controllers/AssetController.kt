package co.genecoin.qrcode.controllers

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.service.QRCodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/asset")
class AssetController {

    @Autowired
    lateinit var authorService: QRCodeService

    @GetMapping
    fun getAll(): List<Asset> = authorService.getAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id:String): Optional<Asset> = authorService.getById(id)

    @PostMapping
    fun insert(@RequestBody asset: Asset): Asset = authorService.insert(asset)

    @PutMapping
    fun update(@RequestBody asset: Asset): Asset = authorService.update(asset)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: String): Optional<Asset>  = authorService.deleteById(id)
}