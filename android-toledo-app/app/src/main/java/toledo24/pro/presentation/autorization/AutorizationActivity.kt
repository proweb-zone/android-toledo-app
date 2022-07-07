package toledo24.pro.presentation.autorization

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.koin.androidx.viewmodel.ext.android.viewModel
import toledo24.pro.databinding.ActivityAutorizationBinding
import toledo24.pro.presentation.welcome.WelcomeViewModel

class AutorizationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAutorizationBinding
    private lateinit var vm: AutorizationViewModel

    // private val viewModel by viewModel<AutorizationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("tag", "Activity created")
        vm = ViewModelProvider(this).get(AutorizationViewModel::class.java)
        //vm = AutorizationViewModel()

        binding.btnAutorization.setOnClickListener{
           // Log.d("tag", binding.phoneInput.text.toString())
            vm.getAutorizationCode(binding.phoneInput.text.toString())
        }

    }

}