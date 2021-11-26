package ge.nlatsabidze.summary_11.homeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ge.nlatsabidze.summary_11.model.UserInformation
import ge.nlatsabidze.summary_11.repository.RetrofitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val retrofitRepository: RetrofitRepository): ViewModel() {

    private val _userInfo = MutableStateFlow<List<UserInformation>>(mutableListOf())
    val userInfo: MutableStateFlow<List<UserInformation>> get() = _userInfo

    fun setResult() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                retrofitRepository.getItems().collect {
                    _userInfo.value = it.data!!
                }
            }
        }
    }
}