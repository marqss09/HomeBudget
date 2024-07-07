package pl.OlaAndMarek.homebudget

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pl.OlaAndMarek.homebudget.databinding.ActivityLoginBinding
import pl.OlaAndMarek.homebudget.databinding.ActivityMainBinding
import pl.OlaAndMarek.homebudget.databinding.ActivityProfileBinding
import pl.OlaAndMarek.homebudget.sampledata.zaklady



public class UserActivity : AppCompatActivity() {

    private lateinit var etemail: EditText
    private lateinit var etuserid: EditText
    private lateinit var wyslij: Button
    private lateinit var profilename: TextView
    private lateinit var emailname: TextView

    private lateinit var binding : ActivityProfileBinding

    private var uid: String? = null
    private var nick: String? = null
    private var pkt: Int = 0
    private var email: String?= null
    private var obstawienia: List<zaklady>? = null

    val user = hashMapOf(
        "uid" to uid,
        "nick" to nick,
        "pkt" to pkt,
        "email" to email,
        "obstawienia" to obstawienia
    )

    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db2 =

        etemail = binding.email
        etuserid = binding.userid
        wyslij = binding.wyslij
        profilename = binding.profilname
        emailname = binding.emailid

        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("user").document("SKotlwZRFKzpfNN2XZqA ")

        ref.get().addOnSuccessListener {
            if(it != null){
                val profilname = it.data?.get("uid").toString()
                val profileemail = it.data?.get("email").toString()

                profilename.text = profilname
                emailname.text = profileemail

            }

        }
        .addOnFailureListener{

        }

        /*wyslij.setOnClickListener{
            val semail = etemail.text.toString()
            val suserid = etuserid.text.toString()

            val usermap = hashMapOf(
                "email" to semail,
                "uid" to suserid
            )
            db.collection("user").document().set(usermap)
                .addOnSuccessListener {
                    Toast.makeText(this,"Sucesfull",Toast.LENGTH_LONG).show()
                }
        }*/
    }

    override fun onStart() {
        super.onStart()
        /*
        var auth: FirebaseAuth = FirebaseAuth.getInstance()
        val userid = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("users").document(userid)
        ref.get().addOnSuccessListener {
            if(it != null){
                uid = it.data?.get("uid")?.toString()
                email = it.data?.get("email")?.toString()

                binding.profilname.text = uid
                binding.emailid.text = email
            }

        }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }


        }

         */}
}



