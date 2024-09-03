package pl.OlaAndMarek.homebudget.Zaklady

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pl.OlaAndMarek.homebudget.FirebaseRepository.FirebaseRepository
import pl.OlaAndMarek.homebudget.sampledata.Zaklady

class zakladyViewModel: ViewModel() {

    private val repository  = FirebaseRepository()


    val zaklady = repository.getGameBet()
}