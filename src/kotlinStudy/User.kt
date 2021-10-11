package kotlinStudy

import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String)

fun User.saveUser(user: User) {
    fun validation(value: String, fieldName: String) {
        if (value.isEmpty()) throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
    }

    validation(user.name, "Name")
    validation(user.address, "Address")
}


