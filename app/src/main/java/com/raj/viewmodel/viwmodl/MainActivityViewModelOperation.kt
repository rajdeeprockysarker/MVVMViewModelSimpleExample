package com.raj.viewmodel.viwmodl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.raj.viewmodel.Repository.MainActivityRepository
import com.raj.viewmodel.model.User

class MainActivityViewModelOperation : ViewModel() {


    private val _userId: MutableLiveData<Int> = MutableLiveData()

    val user: LiveData<User> = Transformations
        .switchMap(_userId){
            MainActivityRepository.getUser((_userId.value).toString())
        }

    fun setUserId(userId: Int){
        val update = userId
        if (_userId.value == update) {
            return
        }
        _userId.value = update
    }

}