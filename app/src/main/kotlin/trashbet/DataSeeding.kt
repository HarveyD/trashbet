package trashbet

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun seedData() {
    transaction {
        val userService = UserService()
        SchemaUtils.create(Users)
        SchemaUtils.create(Bets)
        SchemaUtils.create(Wagers)

        Users.insert {
            it[name] = "John"
            it[amount] = 20
            it[password_hash] = userService.hashPassword("John")
            it[admin] = true
        }
        Users.insert {
            it[name] = "Jack"
            it[amount] = 20
            it[password_hash] = userService.hashPassword("Jack")
            it[admin] = true
        }
        Users.insert {
            it[name] = "Jill"
            it[amount] = 20
            it[password_hash] = userService.hashPassword("Jill")
            it[admin] = false
        }

        Bets.insert {
            it[description] = "Seeded incomplete bet"
            it[complete] = false
        }
        Bets.insert {
            it[description] = "Seeded complete bet"
            it[complete] = true
            it[outcome] = true
        }
    }
}