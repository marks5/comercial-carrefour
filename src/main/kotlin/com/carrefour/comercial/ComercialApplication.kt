package com.carrefour.comercial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("com.carrefour.comercial.model")
@EnableJpaRepositories("com.carrefour.comercial.repository")
class ComercialApplication

fun main(args: Array<String>) {
	runApplication<ComercialApplication>(*args)
}
