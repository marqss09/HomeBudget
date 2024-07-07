package pl.OlaAndMarek.homebudget.sampledata

import android.os.Parcel
import android.os.Parcelable

data class User(
    val uid: String? = null,
    val nick: String? = null,
    val pkt: Int = 0,
    val email: String?= null,
    val obstawienia: List<zaklady>? = null
)
