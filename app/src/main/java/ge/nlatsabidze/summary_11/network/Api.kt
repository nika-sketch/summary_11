package ge.nlatsabidze.summary_11.network

import ge.nlatsabidze.summary_11.Constants.ConstantsUrl
import ge.nlatsabidze.summary_11.model.UserInformation
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(ConstantsUrl.END_POINT)
    suspend fun getItems(): Response<List<UserInformation>>
}