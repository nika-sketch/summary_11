package ge.nlatsabidze.summary_11.repository


import ge.nlatsabidze.summary_11.Resource
import ge.nlatsabidze.summary_11.model.UserInformation
import ge.nlatsabidze.summary_11.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private var apiService: Api) {

    suspend fun getItems(): Flow<Resource<List<UserInformation>>> {
        return flow {
            emit(handleResponse {
                apiService.getItems()
            })
        }.flowOn(Dispatchers.IO)
    }
}

suspend fun <T> handleResponse(apiCall: suspend() -> Response<T>): Resource<T> {
    try {
        val response = apiCall()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            return Resource.Success(body)
        }
        return Resource.Error("exception")

    }catch (e: Exception) {
        return Resource.Error("exception")
    }
}