package com.raj.viewmodel.storage

import com.raj.viewmodel.model.User

object GetStaticValue {

    val UserList by lazy {
        listOf<User>(User("Ram"),User("123"))
    }

}