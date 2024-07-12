package pl.OlaAndMarek.homebudget

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import pl.OlaAndMarek.homebudget.Register

abstract class BaseFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transInflater = TransitionInflater.from(requireContext())
    }
    protected fun startApp(){
        val intent = Intent(requireContext(), Register::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }
}