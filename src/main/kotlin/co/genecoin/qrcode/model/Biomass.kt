package co.genecoin.qrcode.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

interface Bio {
    @JsonIgnore
    fun isValid(): Boolean
}

@Document
data class BiomassRegistry(@Id val uuid: String? = null, val bioName: String, val bioType: Int)

class Biomass : Bio {
    @JsonIgnore
    val registry: BiomassRegistry? = null
    val quantity: Int = 0

    override fun isValid(): Boolean {
        when (registry?.bioType) {
            else -> return BreuBranco(this).isValid()
        }
    }

}

class BreuBranco(val biomass: Biomass) : Bio {

    override fun isValid(): Boolean {
        if (biomass.quantity > 0) return true
        return false
    }

}