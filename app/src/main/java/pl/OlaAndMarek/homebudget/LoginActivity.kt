package pl.OlaAndMarek.homebudget

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import pl.OlaAndMarek.homebudget.databinding.ActivityLoginBinding
import pl.OlaAndMarek.homebudget.databinding.ActivityMainBinding
import pl.OlaAndMarek.homebudget.databinding.ActivityRegisterBinding


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
            //.addOnSuccessListener { authRes ->
            //    if (authRes.user != null) startApp()
            // }
            // .addOnFailureListener { exc ->
            // Log.d(DEBUG,exc.message.toString())
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
