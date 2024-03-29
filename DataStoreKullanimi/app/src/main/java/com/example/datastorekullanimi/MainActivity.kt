package com.example.datastorekullanimi

import android.graphics.CornerPathEffect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.datastorekullanimi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim= ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val ap = AppPref(this)

        val job = CoroutineScope(Dispatchers.Main).launch {
            ap.kayitAd("Ahmet")
            ap.kayitYas(23)
            ap.kayitBoy(1.78)
            ap.kayitBekar(true)

            val liste = HashSet<String>()
            liste.add("Ali")
            liste.add("Ece")

            ap.kayitArkadasListe(liste)


            val gelenAd = ap.okuAd()
            val gelenYas = ap.okuYas()
            val gelenBoy = ap.okuBoy()
            val gelenBekar = ap.okuBekar()

            Log.e("Gelen Ad", gelenAd)
            Log.e("Gelen Yaş", gelenYas.toString())
            Log.e("Gelen Boy", gelenBoy.toString())
            Log.e("Gelen Bekar", gelenBekar.toString())

            val gelenListe = ap.okuArkadasListe()
            if(gelenListe != null)
                for(a in gelenListe){
                    Log.e("Gelen Arkadaş",a)
            }

            var gelenSayac = ap.okuSayac()

            ap.kayitSayac(++gelenSayac)

            tasarim.textViewSonuc.text = "Açılış Sayısı : $gelenSayac"
        }
    }
}