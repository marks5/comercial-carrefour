package com.carrefour.comercial.controllers

import com.carrefour.comercial.model.Transaction
import com.carrefour.comercial.repository.TransactionRepository
import com.carrefour.comercial.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/transaction")
class ControlController {

    @Autowired
    private lateinit var controlService: TransactionRepository

    @GetMapping
    fun getAll(): MutableIterable<Transaction> = controlService.findAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id:String): Optional<Transaction> = controlService.findById(id)

    @PostMapping
    fun insert(@RequestBody transaction: Transaction): Transaction = controlService.save(transaction)
}