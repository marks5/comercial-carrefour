package co.genecoin.qrcode.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.format.annotation.DateTimeFormat
import java.sql.Timestamp
import java.util.*

@Document
data class Asset(
        /**
        *
        * Identificador único
        *
        *  */
        @Id
        val uuid: String? = null,
        /**
        *
        * Utilizado para visualizar onde foi feita a criação desse Asset.
        *
        *  */
        val latLng: LatLng,
        /**
        *
        * Utilizado para listagem de peso de um asset.
        * Para que cada inserção de peso fosse inserida uma nova latLng afim de mapear os locais mais frutiferos
        * ** necessidade deste cliente atual **
        *
        *  */
        var weight: AssetWeight,
        /**
        *
        * Data da coleta, uma vez não nulo, não poderá ser alterado novamente.
        *
        *  */
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
        var collectDate: Date? = null,
        /**
        *
        * Data da chegada, uma vez não nulo, não poderá ser alterado novamente.
        *
        *  */
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
        var arrivalDate: Date? = null,
        /**
        *
        * Data do armazenamento, uma vez não nulo, não poderá ser alterado novamente.
        *
        *  */
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
        var storedDate: Date? = null,
        /**
        *
        * Usuário dono do ativo.
        *
        *  */
        val owner: User,
        /**
        *
        * Nome do ativo.
        *
        *  */
        val assetName: String,
        /**
        *
        * Utilizado para observações extras diretamente no aparelho.
        *
        *  */
        var obs: String? = null,
        /**
        *
        * Utilizado com o cron job no Ethereum. Se o dado estiver = finalizado não poderá mais alterar qualquer informação da mesma forma o desativado.
        * Se estiver finalizado significa que o cron job já passou e enviou ao ethereum
        *
        *  */
        var state: State = State.ATIVO,
        /**
         *
         * Qualidade do produto coletado
         *
         *  */
        var quality: AssetQuality? = null,
        /**
         *
         * Imagem do ativo
         *
         *  */
        var assetPhoto: String
)

data class LatLng(val lat: Double, val lng: Double)
data class User(val email: String)
data class AssetWeight(val weight: Double, val type: String)

enum class AssetQuality{
        MUITO_RUIM,
        RUIM,
        BOM,
        MUITO_BOM
}

enum class State {
        ATIVO,
        DESATIVADO,
        FINALIZADO
}
