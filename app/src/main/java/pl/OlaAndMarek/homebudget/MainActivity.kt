package pl.OlaAndMarek.homebudget


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import pl.OlaAndMarek.homebudget.Login.LoginActivity
import pl.OlaAndMarek.homebudget.databinding.ActivityMainBinding
import pl.OlaAndMarek.homebudget.User.UserActivity
import pl.OlaAndMarek.homebudget.Wyniki.wyniki
import pl.OlaAndMarek.homebudget.Zaklady.zaklady

class MainActivity : AppCompatActivity() {
    private fun goToProfil() {

        val intent = Intent(this, UserActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            val uid = auth.uid.toString()

        }
        startActivity(intent)
    }
    private fun goToTabela() {
        val intent = Intent(applicationContext, tabelagraczy::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }
    private fun goToZaklady() {
        val intent = Intent(applicationContext, zaklady::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

    private fun goToWyniki() {
        val intent = Intent(applicationContext, wyniki::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

    private fun backToLogin() {
        val intent = Intent(applicationContext, LoginActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

    private lateinit var binding: ActivityMainBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
       // firebaseRef = FirebaseDatabase.getInstance().getReference("letsSee")

        setContentView(binding.root)


        binding.zaklady.setOnClickListener{goToZaklady()}
        binding.wyniki.setOnClickListener{goToWyniki()}
        //binding.tabelagraczy.setOnClickListener{goToTabela()}
        binding.mojprofil.setOnClickListener{goToProfil()}
        binding.buttwyloguj.setOnClickListener{
            auth.signOut()
            if (auth.currentUser == null ){
                Toast.makeText(this, "Zostales wylogowany", Toast.LENGTH_SHORT).show()
                // Sign-out successful.
                backToLogin()
            }
        }
    }
}

