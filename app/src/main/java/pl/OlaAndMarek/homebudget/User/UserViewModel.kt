package pl.OlaAndMarek.homebudget.User


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pl.OlaAndMarek.homebudget.FirebaseRepository.FirebaseRepository
import pl.OlaAndMarek.homebudget.sampledata.User

class UserViewModel: ViewModel(

) {

    private val repository  = FirebaseRepository()

    val user = repository.getUserData()





}