package toledo24.pro.presentation.autorization

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class AutorizationViewModel(): ViewModel() {

    private val resultLiveData = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveData

    private val setToastLiveData = MutableLiveData<String>()
    val toastLiveData: LiveData<String> = setToastLiveData


    /**
     * get autorization code on phone
     */
    fun getAutorizationCode(phone: String) {


    }

    /**
     * Validation User Phone
     */
    fun validationUserPhone(phone: String): Boolean {
        val REG = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}\$"
        return phone.matches(Regex(REG))
    }

    override fun onCleared() {
        super.onCleared()
    }

}