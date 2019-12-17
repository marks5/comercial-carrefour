package co.genecoin.qrcode.controllers

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.ZXingHelper
import co.genecoin.qrcode.service.QRCodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.io.OutputStream
import java.util.*
import javax.servlet.http.HttpServletResponse


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

    @RequestMapping(value = ["qrcode/{id}"], method = [RequestMethod.GET])
    @Throws(Exception::class)
    fun qrcode(@PathVariable("id") id: String?, @RequestParam("w") width: Int?, @RequestParam("h") height: Int?, response: HttpServletResponse) {
        response.contentType = "image/png"
        val outputStream: OutputStream = response.outputStream
        ZXingHelper.getQRCodeImage(id, width?:200, height?:200)?.apply {
            outputStream.write(this)
            outputStream.flush()
            outputStream.close()
        }

    }
}