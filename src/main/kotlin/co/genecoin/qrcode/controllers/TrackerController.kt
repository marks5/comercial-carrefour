package co.genecoin.qrcode.controllers

import co.genecoin.qrcode.model.*
import co.genecoin.qrcode.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import java.util.*


@RestController
@RequestMapping("/api/tracker")
class TrackerController {

    @Autowired
    lateinit var service: TrackerService

    @Autowired
    lateinit var ownerService: OwnerService

    @Autowired
    lateinit var laboratoryService: LaboratoryService

    @Autowired
    lateinit var biomassService: BiomassService

    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun getAll(): List<Tracker> = service.getAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id:String): Optional<Tracker> = service.getById(id)

    @PostMapping
    fun insert(@RequestBody asset: TrackerRequest): Tracker {
        var laboratory: LaboratoryRegistry? = null

        val owner = ownerService.findByAccount(asset.ownerAddress)
        if(!owner.isPresent) throw IllegalArgumentException("Endereço não encontrado")

        val product = productService.getByToken(asset.productToken)
        if(!product.isPresent) throw IllegalArgumentException("Token do produto não encontrado")

        val biomass = biomassService.getByBioType(asset.biomassTypeId)
        if(!biomass.isPresent) throw IllegalArgumentException("Biomassa ID não encontrado")

        asset.laboratoryAddress?.let { laboratory = laboratoryService.findByAccount(it).get() }

        val tracker = Tracker(owner = owner.get(), latLng = asset.latLng, laboratory = laboratory, product = product.get())

        return service.insert(tracker)
    }
}