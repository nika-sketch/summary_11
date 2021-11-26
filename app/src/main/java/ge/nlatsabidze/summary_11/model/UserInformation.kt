package ge.nlatsabidze.summary_11.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserInformation(
    @Json(name = "avatar")
    val avatar: String?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "first_name")
    val firstName: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "is_typing")
    val isTyping: Boolean?,
    @Json(name = "last_message")
    val lastMessage: String?,
    @Json(name = "last_name")
    val lastName: String?,
    @Json(name = "message_type")
    val messageType: String?,
    @Json(name = "unrea_message")
    val unreaMessage: Int?,
    @Json(name = "updated_date")
    val updatedDate: Long?
)