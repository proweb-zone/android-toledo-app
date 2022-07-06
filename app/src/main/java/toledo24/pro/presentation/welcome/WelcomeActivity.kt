package toledo24.pro.presentation.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import toledo24.pro.databinding.ActivityWelcomeBinding
import toledo24.pro.presentation.MainActivity
import toledo24.pro.presentation.autorization.AutorizationActivity


class WelcomeActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityWelcomeBinding

    private val viewModel by viewModel<WelcomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        lifecycleScope.launchWhenStarted {
            viewModel.transitionWindow.onEach { value ->
                if(value) {
                    Log.d("tag", " авторизован ")
                    val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Log.d("tag", " не авторизован ")
                    val intent = Intent(this@WelcomeActivity, AutorizationActivity::class.java)
                    startActivity(intent)

                }
            }.collect()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.toastData.onEach { value ->
                Log.d("tag", " выполняю toastData ${value}")
                Toast.makeText(application, value, Toast.LENGTH_SHORT).show()
            }.collect()
        }

    }

}