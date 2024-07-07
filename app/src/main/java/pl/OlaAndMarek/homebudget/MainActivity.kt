package pl.OlaAndMarek.homebudget


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import pl.OlaAndMarek.homebudget.databinding.ActivityLoginBinding
import pl.OlaAndMarek.homebudget.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp;
import pl.OlaAndMarek.homebudget.sampledata.User

class MainActivity : AppCompatActivity() {
    private fun goToProfil() {
        //zmienic docelowo na klase profilu
        val intent = Intent(this, UserActivity::class.java).apply {
            //flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            val uid = auth.uid.toString()
            //intent.putExtra(uid)
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
    private lateinit var firebaseRef : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
       // firebaseRef = FirebaseDatabase.getInstance().getReference("letsSee")

        setContentView(binding.root)

        if (auth.currentUser != null){
            Toast.makeText(this, "Zostales zalogowany", Toast.LENGTH_SHORT).show()
        }
        binding.zaklady.setOnClickListener{goToZaklady()}
        binding.wyniki.setOnClickListener{goToWyniki()}
        binding.tabelagraczy.setOnClickListener{goToTabela()}
        binding.mojprofil.setOnClickListener{goToProfil()}
        binding.buttwyloguj.setOnClickListener{
            auth.signOut()
            if (auth.currentUser == null ){
                Toast.makeText(this, "Zostales wylogowany", Toast.LENGTH_SHORT).show()
                // Sign-out successful.
                backToLogin()
            }
        }

/*
        fun onStart() {
            super.onStart()
            isCurentUser()
        }
    }

    private fun isCurentUser() {
        auth.currentUser?.let {
            val intent: Intent = Intent(applicationContext, LoginActivity::class.java).apply {
                flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            startActivity(intent)
        }*/
    }


}

