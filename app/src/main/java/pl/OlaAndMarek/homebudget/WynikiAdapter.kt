package pl.OlaAndMarek.homebudget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import pl.OlaAndMarek.homebudget.databinding.WynikiBinding
import pl.OlaAndMarek.homebudget.sampledata.User
import pl.OlaAndMarek.homebudget.sampledata.mecz

class WynikiAdapter(private val mecze:List<mecz>) :RecyclerView.Adapter<WynikiAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: WynikiBinding): ViewHolder(binding.root){
        val druzyna1 = binding.druzyna1
        val druzyna2 = binding.druzyna2
        val wynik = binding.wynik
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val wb = WynikiBinding.inflate(inflater,parent,false)
        return MyViewHolder(wb)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.druzyna1.text = mecze[position].gosc
        holder.wynik.text = mecze[position].wynik
        holder.druzyna2.text = mecze[position].gospodarz
    }

    override fun getItemCount(): Int {
        return mecze.size
    }



}