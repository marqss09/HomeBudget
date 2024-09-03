package pl.OlaAndMarek.homebudget.Zaklady


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pl.OlaAndMarek.homebudget.MainActivity
import pl.OlaAndMarek.homebudget.databinding.ActivityZakladyBinding


public class zaklady : AppCompatActivity() {



    private lateinit var binding: ActivityZakladyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakladyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wyslijwynik.setOnClickListener {
            Toast.makeText(this, "Wynik wyslano", Toast.LENGTH_SHORT).show()
            backToMain()
            binding.tabela.visibility = View.GONE
            binding.wynikmeczu.visibility = View.GONE


        }
    }


    private fun backToMain() {
        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

}
