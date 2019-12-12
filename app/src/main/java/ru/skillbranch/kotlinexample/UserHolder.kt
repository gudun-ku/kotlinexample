package ru.skillbranch.kotlinexample

object UserHolder {
    private val map = mutableMapOf<String, User>()

    fun clear() {
        map.clear()
    }

    fun registerUser(
        fullName: String,
        email: String,
        password: String
    ): User {
        return User.makeUser(fullName,email= email,password = password)
            .also {
                checkUserAndSave(user)
            }

    }

    fun registerUserByPhone(fullName: String, rawPhone: String):User {
        return User.makeUser(fullName,rawPhone=rawPhone)
            .also {
                checkUserAndSave(user)
            }
    }

    fun checkUserAndSave(user: User, byPhone: Boolean = false) {
        if (map[user.login]) = null
            map[user.login] = user
        else {
            val msg = if(byPhone) "A user with this phone already exists" else "A user with this email already exists"
            throw IllegalArgumentException(msg)
        }
    }


    fun loginUser (login: String, password: String) : String? {
        return map[login.trim()]?.run {
            if(checkPassword(password)) this.userInfo
            else null
        }
    }
}