package pl.OlaAndMarek.homebudget.FirebaseRepository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import pl.OlaAndMarek.homebudget.Zaklady.zaklady
import pl.OlaAndMarek.homebudget.sampledata.Druzyna
import pl.OlaAndMarek.homebudget.sampledata.User
import pl.OlaAndMarek.homebudget.sampledata.mecz
import pl.OlaAndMarek.homebudget.sampledata.Zaklady as Zaklady

class FirebaseRepository {
    private val REPO_DEBUG = "REPO_DEBUG"
    private val auth = FirebaseAuth.getInstance()
    private val cloud = FirebaseFirestore.getInstance()



    fun getUserData(): LiveData<User?> {
        val cloudResult = MutableLiveData<User?>()
        val uid = auth.currentUser?.uid

        cloud.collection("users")
            .document(uid!!)
            .get()
            .addOnSuccessListener {
                val user = it.toObject(User::class.java)
                cloudResult.postValue(user)
            }
            .addOnFailureListener{
                Log.d(REPO_DEBUG, it.message.toString())
            }

        return cloudResult
    }
    fun getTeamsData(): LiveData<Druzyna?> {
        val cloudResult = MutableLiveData<Druzyna?>()
        val iddruzyny = cloud.collection("druzyny").document("nazwaDruzyny")


        cloud.collection("druzyny")
            .document(iddruzyny!!.toString())
            .get()
            .addOnSuccessListener {
                val druzyna = it.toObject(Druzyna::class.java)
                cloudResult.postValue(druzyna)
            }
            .addOnFailureListener{
                Log.d(REPO_DEBUG, it.message.toString())
            }

        return cloudResult
    }
    fun getGameData(): LiveData<mecz?> {
        val cloudResult = MutableLiveData<mecz?>()

        cloud.collection("mecze")
            .document(idmeczu!!)
            .get()
            .addOnSuccessListener {
                val mecz = it.toObject(mecz::class.java)
                cloudResult.postValue(mecz)
            }
            .addOnFailureListener{
                Log.d(REPO_DEBUG, it.message.toString())
            }

        return cloudResult
    }
    fun getGameBet(): MutableLiveData<zaklady?> {
        val cloudResult = MutableLiveData<zaklady?>()

        cloud.collection("obstawienia")
            .document(meczid!!)
            .get()
            .addOnSuccessListener {
                val obstawienia = it.toObject(Zaklady::class.java)
                cloudResult.postValue(obstawienia)
            }
            .addOnFailureListener{
                Log.d(REPO_DEBUG, it.message.toString())
            }

        return cloudResult
    }

}


