package co.genecoin.qrcode.model

data class Product(
    val biomass: Biomass,
    val name: String,
    val harvester: Harvester,
    val laboratory: LaboratoryRegistry? = null
)