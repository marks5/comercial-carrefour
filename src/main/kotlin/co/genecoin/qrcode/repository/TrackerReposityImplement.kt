package co.genecoin.qrcode.repository

import co.genecoin.qrcode.model.Tracker
import org.springframework.data.mongodb.repository.MongoRepository

interface TrackerReposityImplement : MongoRepository<Tracker, String>