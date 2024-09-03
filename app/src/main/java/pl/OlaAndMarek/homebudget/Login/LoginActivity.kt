package pl.OlaAndMarek.homebudget.Login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import pl.OlaAndMarek.homebudget.MainActivity
import pl.OlaAndMarek.homebudget.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    val fbAuth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        // Sprawdzamy czy uzytkownik jest zalogowany
        isCurrentUser()

        val email: String = binding.email.toString().trim()
        val password: String = binding.password.toString().trim()
        binding.loginbtn.setOnClickListener {
            fbAuth.signInWithEmailAndPassword(email, password)
            startApp()
        }

        binding.registrationbtn.setOnClickListener {
            registrationActivityStart()
        }
    }



    private fun isCurrentUser() {

        if (fbAuth.currentUser != null) {
            startApp()

        }
        
    }
    private fun startApp(){
        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)

    }
    private fun registrationActivityStart(){
        val intent = Intent(applicationContext, Register::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)

    }
}
