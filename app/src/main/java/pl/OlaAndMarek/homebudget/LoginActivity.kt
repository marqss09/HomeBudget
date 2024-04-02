package pl.OlaAndMarek.homebudget

import android.os.Bundle
import android.view.LayoutInflater

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import pl.OlaAndMarek.homebudget.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

   // private lateinit var binding: LoginActivityBinding
    private lateinit var binding:ActivityLoginBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
//binding = ActivitySignUpBinding.inflate(layoutInflater)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}