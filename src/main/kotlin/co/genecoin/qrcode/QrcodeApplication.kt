package co.genecoin.qrcode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QrcodeApplication

fun main(args: Array<String>) {
	runApplication<QrcodeApplication>(*args)
}
