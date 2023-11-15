package com.recepgemalmaz.pazarama_bootcamp_ders_7_1_dependency_injection_hilt_sample

import javax.inject.Inject

class Musteri @Inject constructor(){
    var adi: String = ""
    var soyadi: String = ""

}



class BankaHesabi  @Inject constructor(var musteri: Musteri){
    var iban: String = ""
    var bakiye: Long = 0L
    //var mstr: Musteri? = null

    //init bloguna gerrek kalmadi
    /*
    init {
        this.mstr = musteri
    }

     */



    fun DisplayHesap():String
    {
        return "Hesap: ${this.iban} Bakiye: ${this.bakiye} Adi: ${musteri!!.adi} Soyadi: ${musteri!!.soyadi}"
    }
}