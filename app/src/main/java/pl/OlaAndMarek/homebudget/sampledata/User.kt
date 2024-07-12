package pl.OlaAndMarek.homebudget.sampledata

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class User(
    val uid: String? = null,
    val pkt: Int? = 0 ,
    val email: String? = null,
    val obstawienia1: List<String>? = null,
    val obstawienia2: List<String>? = null,
    val obstawienia3: List<String>? = null
)
