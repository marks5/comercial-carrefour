package co.genecoin.qrcode.repository

import co.genecoin.qrcode.model.Asset
import co.genecoin.qrcode.model.Biomass
import co.genecoin.qrcode.model.BiomassRegistry
import co.genecoin.qrcode.model.Tracker
import org.springframework.data.mongodb.repository.MongoRepository

interface BiomassReposityImplement : MongoRepository<BiomassRegistry, String>