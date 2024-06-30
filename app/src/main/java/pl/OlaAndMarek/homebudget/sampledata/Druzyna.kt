package pl.OlaAndMarek.homebudget.sampledata

data class Druzyna(
    val iddruzyny:String ?= null,
    val grupa:String ?= null,
    val punkty:Int = 0,
    val idmeczu1: List<String>,
    val idmeczu2: List<String>,
    val idmeczu3: List<String>)
