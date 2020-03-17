package co.genecoin.qrcode.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Product(
        @JsonIgnore
        @Id
        val uuid: String? = null,
        val biomass: Biomass,
        val name: String,
        val token: Int = 0,
        val harvester: Harvester
)