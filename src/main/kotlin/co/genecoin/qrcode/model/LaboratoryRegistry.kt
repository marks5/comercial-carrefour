package co.genecoin.qrcode.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class LaboratoryRegistry(
        @JsonIgnore
        @Id
        val uuid: String? = null,
        val account: String,
        val name: String,
        val email: String,
        @JsonIgnore
        val active: Boolean
) {
    @JsonIgnore
    val produce: List<Capacity>? = null
}

interface CapacityCheck {
    fun isValid(): Boolean
}

class Laboratory(reg: LaboratoryRegistry) : CapacityCheck{
    val laboratory: LaboratoryRegistry = reg
    val quantity: Int = 0
    val biomassType: Int = 0

    override fun isValid(): Boolean {
        var isValid = false
        laboratory.produce?.let {
            for (b in it){
                if(b.biomassType == biomassType && b.capacity >= quantity) isValid = true
            }
        }
        return isValid
    }


}

data class Capacity (
        val biomassType: Int,
        val capacity: Int
)