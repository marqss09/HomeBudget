package pl.OlaAndMarek.homebudget

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
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

        auth = FirebaseAuth.getInstance()

        binding.buttonRegister.setOnClickListener{
            val email = binding.Email.text.toString()
            val password = binding.Password.text.toString()
            if(checkAllField()){
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    //when acc is created
                    // is also signed in
                    if(it.isSuccessful){
                        auth.signOut()
                        Toast.makeText(this, "Konto założone", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        // acc not ended with succesfull
                        Log.e("Error",it.exception.toString())
                    }
                }
            }

        }
    }

    private fun checkAllField(): Boolean {
        val email = binding.Email.text.toString()
        if (binding.Email.text.toString() == "") {
            binding.textInputLayoutEmail.error = "Pole jest wymagane"
            return false
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.textInputLayoutEmail.error = "Sprawdz adres email"
            return false
        }
        if(binding.Password.text.toString() == ""){
            binding.textInputLayoutPassword.error == "Pole jest wymagane "
        }
        if(binding.Confirm.text.toString() == ""){
            binding.textInputLayoutPassword.error == "Pole jest wymagane "
        }
        if(binding.Password.text.toString() != binding.Confirm.text.toString()){
            binding.textInputLayoutConfirm.error = "Hasla musza byc takie same"
        }

        return true
    }



}
