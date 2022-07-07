package toledo24.pro.presentation.autorization

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class AutorizationViewModel(): ViewModel() {

    private val resultLiveData = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveData

    private val setToastLiveData = MutableLiveData<String>()
    val toastLiveData: LiveData<String> = setToastLiveData

    init {
        Log.d("tag", "VM created")
    }


    /**
     * get autorization code on phone
     */
    fun getAutorizationCode(phone: String) {
        Log.d("tag", "Сообщение какое-нибудь ${phone}")
    }

    /**
     * Validation User Phone
     */
    fun validationUserPhone(phone: String): Boolean {
        val REG = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}\$"
        return phone.matches(Regex(REG))
    }

    override fun onCleared() {
        Log.d("tag", "VM cleared")
        super.onCleared()
    }

}