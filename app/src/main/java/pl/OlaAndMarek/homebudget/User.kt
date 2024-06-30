package pl.OlaAndMarek.homebudget

import pl.OlaAndMarek.homebudget.sampledata.zaklady

public class User {
   private var uid: String? = null
    private var nick: String? = null
    private var pkt: Int = 0
    private var email: String?= null
    private var obstawienia: List<zaklady>? = null

    fun User(uid: String,nick: String,pkt: Int, email: String, obstawienia: List<zaklady>) {
        this.uid = uid
        this.nick = nick
        this.pkt = pkt
        this.email = email
        this.obstawienia = obstawienia
    }
}