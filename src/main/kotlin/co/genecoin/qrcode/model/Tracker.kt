package co.genecoin.qrcode.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Tracker(

        @JsonIgnore
        @Id
        val uuid: String? = null,
        val latLng: LatLng,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
        var date: Date? = null,
        val product: Product,
        val owner: Owner,

        val laboratory: LaboratoryRegistry? = null
        //val shipping: ShippingCompany? = null,
)

data class TrackerRequest(
        val latLng: LatLng,
        val ownerAddress: String,
        val harvesterAddress: String,
        val laboratoryAddress: String?,
        val productToken: Int,
        val biomassTypeId: Int
)