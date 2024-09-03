package pl.OlaAndMarek.homebudget.User

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import pl.OlaAndMarek.homebudget.MainActivity
import pl.OlaAndMarek.homebudget.databinding.ActivityProfileBinding
import pl.OlaAndMarek.homebudget.sampledata.User




public class UserActivity : AppCompatActivity() {


    private lateinit var profilename: TextView
    private lateinit var emailname: TextView

    private lateinit var binding : ActivityProfileBinding

    //private val userVm by viewModels<UserViewModel>()

    private var nick: String? = null
    private var pkt: Int = 0
    private var email: String?= null


    private val PROFILE_DEBUG = "PROFILE_DEBUG"


   // val cloudResult = MutableLiveData<User?>()



    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.powrot.setOnClickListener {

            backToMain()

        }
    }


    private fun backToMain() {
        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }
/*
        emailname = binding.emailid
        profilename = binding.profilname

        userVm.user.observe(this, Observer {


                bindUser(user = "userod")


                //emailname =userVm.user.uid
                //profilename = it.email

            // Actualize interfejs użytkownika na podstawie danych użytkownika
            // Przykład:
            // textViewUserEmail.text = user.email

            //}
        })
 */
}
    /*

        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        db = FirebaseFirestore.getInstance()

        val ref = db.collection("user").document("SKotlwZRFKzpfNN2XZqA")


        ref.get().addOnSuccessListener { document ->
            if(document != null){
                Log.d("Firestore", "DocumentSnapshot data: " + document.getData());
                //val profilname = ref.get()
                //val profilname = it.data?.get("uid").toString()
               // val profileemail = it.data?.get("email").toString()

                //profilename.text = profilname
                //emailname.text = profileemail

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

    */






