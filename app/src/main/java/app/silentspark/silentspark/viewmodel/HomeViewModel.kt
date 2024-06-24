package app.silentspark.silentspark.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.silentspark.silentspark.data.Repository
import app.silentspark.silentspark.model.Course
import app.silentspark.silentspark.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Course>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Course>>> get() = _uiState

    fun getAllCourse(){
        viewModelScope.launch {
            repository.getAllCourse()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect{ course ->
                    _uiState.value = UiState.Success(course)
                }
        }
    }

}