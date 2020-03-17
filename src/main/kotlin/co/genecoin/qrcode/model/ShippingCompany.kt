package co.genecoin.qrcode.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class ShippingCompany (
        @JsonIgnore
        @Id
        val uuid: String? = null,
        val account: String,
        val name: String,
        @JsonIgnore
        val active: Boolean
)