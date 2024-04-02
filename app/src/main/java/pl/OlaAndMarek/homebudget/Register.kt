package pl.OlaAndMarek.homebudget

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import pl.OlaAndMarek.homebudget.databinding.ActivityLoginBinding
import pl.OlaAndMarek.homebudget.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    // private lateinit var binding: LoginActivityBinding
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
//binding = ActivitySignUpBinding.inflate(layoutInflater)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}