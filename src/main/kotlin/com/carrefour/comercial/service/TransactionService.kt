package com.carrefour.comercial.service

import com.carrefour.comercial.model.Transaction
import com.carrefour.comercial.repository.TransactionRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(val dao: TransactionRepository) : CrudRepository<Transaction, String> {
    override fun <S : Transaction> save(entity: S) = dao.save(entity)

    override fun <S : Transaction?> saveAll(entities: MutableIterable<S>): MutableIterable<S> = dao.saveAll(entities)

    override fun findById(id: String) = dao.findById(id)

    override fun existsById(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<Transaction> = dao.findAll()

    override fun count() = dao.count()
    override fun deleteAllById(ids: MutableIterable<String>) {
        dao.deleteAllById(ids)
    }

    override fun deleteAll() = dao.deleteAll()

    override fun deleteAll(entities: MutableIterable<Transaction>) = dao.deleteAll(entities)

    override fun delete(entity: Transaction) = dao.delete(entity)

    override fun deleteById(id: String) = dao.deleteById(id)

    override fun findAllById(ids: MutableIterable<String>): MutableIterable<Transaction> = dao.findAllById(ids)


}
