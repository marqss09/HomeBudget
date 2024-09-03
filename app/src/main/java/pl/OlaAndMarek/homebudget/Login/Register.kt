package pl.OlaAndMarek.homebudget.Login

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

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener{
            val email = binding.email.text.toString()
            val password = binding.passwd.text.toString()
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
        val email = binding.email.text.toString()
        if (binding.email.text.toString() == "") {
            Toast.makeText(getApplicationContext(),
                "Please enter email!!",
                Toast.LENGTH_LONG)
                .show();
            return false
        }
        if(binding.passwd.text.toString() == ""){
            Toast.makeText(getApplicationContext(),
                "Please enter password!!",
                Toast.LENGTH_LONG)
                .show();
            return false
        }
        if(binding.passwd2.text.toString() == ""){
            Toast.makeText(getApplicationContext(),
                "You need confirm your password!!",
                Toast.LENGTH_LONG)
                .show();
            return false
        }
        if(binding.passwd.text.toString() != binding.passwd2.text.toString()){
            Toast.makeText(getApplicationContext(),
                "Hasla musza byc takie same!!",
                Toast.LENGTH_LONG)
                .show();
            return false
        }

        return true
    }



}
