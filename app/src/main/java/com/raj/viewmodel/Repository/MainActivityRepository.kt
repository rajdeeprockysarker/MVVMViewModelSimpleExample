package com.raj.viewmodel.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raj.viewmodel.model.User
import com.raj.viewmodel.storage.GetStaticValue
import kotlinx.coroutines.*

object MainActivityRepository {

    var job: CompletableJob? = null

    fun getUser(userId: String): LiveData<User> {
        job = Job()
        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(Dispatchers.IO + theJob).launch {
                        val user = GetStaticValue.UserList[userId.toInt()]
                        withContext(Dispatchers.Main){
                            value = user
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }

}

