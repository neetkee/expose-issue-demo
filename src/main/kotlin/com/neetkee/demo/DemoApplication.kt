package com.neetkee.demo

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@SpringBootApplication
@ConfigurationPropertiesScan
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

object Demos : IntIdTable() {
    val demoName = text("demo_name")
}

class Demo(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Demo>(Demos)

    var demoName by Demos.demoName
}

@Service
class DemoService {

    @Transactional
    fun addDemo(name: String): String {
        val savedName = Demo.new {
            this.demoName = name + "_saved"
        }.demoName
        return savedName
    }
}
