package toledo24.pro.presentation.autorization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import toledo24.pro.databinding.ActivityAutorizationBinding

class AutorizationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAutorizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}