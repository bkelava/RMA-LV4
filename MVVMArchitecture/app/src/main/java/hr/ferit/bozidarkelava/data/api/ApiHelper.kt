package hr.ferit.bozidarkelava.data.api

class ApiHelper(private val apiService: ApiService) {
    fun getUsers()=apiService.getUsers()
}