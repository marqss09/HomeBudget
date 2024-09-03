package pl.OlaAndMarek.homebudget.Wyniki

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pl.OlaAndMarek.homebudget.MainActivity
import pl.OlaAndMarek.homebudget.R
import pl.OlaAndMarek.homebudget.databinding.ActivityWynikiBinding
import pl.OlaAndMarek.homebudget.sampledata.mecz

class wyniki: AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var wynikiAdapter: WynikiAdapter
    private val meczeList = mutableListOf<mecz>()

    private lateinit var binding: ActivityWynikiBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var firebaseRef : DatabaseReference

    private val TAG = "wyniki"
    private val db: FirebaseFirestore = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityWynikiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.powrot.setOnClickListener{

            backToMenu()
        }
        fetchUsers()
    }
    private fun fetchUsers() {
        val db = Firebase.firestore
        db.collection("mecze").get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val gosc = document.toObject(mecz::class.java)
                    meczeList.add(gosc)
                }
                wynikiAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("MainActivity", "Error getting documents: ", exception)
            }
    }

    private fun backToMenu(){
        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }


}

