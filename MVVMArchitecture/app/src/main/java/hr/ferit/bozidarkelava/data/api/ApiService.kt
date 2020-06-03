package hr.ferit.bozidarkelava.data.api

import hr.ferit.bozidarkelava.data.model.User
import io.reactivex.Single

interface ApiService {
    fun getUsers(): Single<List<User>>
}