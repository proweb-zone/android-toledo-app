package toledo24.pro.presentation.welcome

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import toledo24.pro.data.network.InternetCheck
import toledo24.pro.data.room.UserEntity
import toledo24.pro.domain.usecase.welcome.CheckingUserUseCase

class WelcomeViewModel(
    private val checkingUserUseCase: CheckingUserUseCase
    ): ViewModel() {

    private val _transitionWindow = MutableStateFlow<Boolean>(true)
    val transitionWindow = _transitionWindow.asStateFlow()

    private val _toastData = MutableSharedFlow<String>()
    val toastData = _toastData.asSharedFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {

            var userEntity = UserEntity(
                98437,
                "Semen",
                "sfdsf8dsfn4",
                "нижний Новогород",
                "Алексеевская 26"
            )

            checkingUserUseCase.insertUserRoom(userEntity)
            //checkingUserUseCase.deleteUserRoom(userEntity)
            var userItemRoom = checkingUserUseCase.getUserRoom()

            Log.d("tag", "результат от use case ${userItemRoom}")

            if(userItemRoom == null) {
                _transitionWindow.emit(false)
                Log.d("tag", "запись не найдена перехожу на авторизацию")
            } else {
                Log.d("tag", "Запись найдена отправляю запрос на сервер ${userItemRoom}")

                try {
                    var result = checkingUserUseCase.checkingUserToken(userItemRoom)
                    Log.d("tag", "результат из сети ${result}")
                    _transitionWindow.emitAll(
                        flow {
                            emit(result.result)
                        }
                    )
                } catch (e: Exception) {

                    var internet = InternetCheck().execute()

                    if (internet) {
                        _toastData.emitAll(
                            flow {
                                emit("Ошибка сервиса")
                            }
                        )
                    } else {
                        _toastData.emitAll(
                            flow {
                                emit("Нет интернета")
                            }
                        )
                    }

                // e.printStackTrace()
                }
            }
        }
    }



}