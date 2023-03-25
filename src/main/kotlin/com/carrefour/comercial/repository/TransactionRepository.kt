package com.carrefour.comercial.repository

import com.carrefour.comercial.model.Transaction
import org.springframework.data.repository.CrudRepository


interface TransactionRepository : CrudRepository<Transaction, String>
