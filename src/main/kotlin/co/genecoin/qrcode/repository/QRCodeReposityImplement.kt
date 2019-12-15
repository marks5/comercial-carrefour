package co.genecoin.qrcode.repository

import co.genecoin.qrcode.model.Asset
import org.springframework.data.mongodb.repository.MongoRepository

interface QRCodeDAO : MongoRepository<Asset, String>