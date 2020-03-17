package co.genecoin.qrcode.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Harvester(
        @JsonIgnore
        @Id
        val uuid: String? = null,
        val account: String,
        val name: String,
        val email: String,
        @JsonIgnore
        val active: Boolean
)