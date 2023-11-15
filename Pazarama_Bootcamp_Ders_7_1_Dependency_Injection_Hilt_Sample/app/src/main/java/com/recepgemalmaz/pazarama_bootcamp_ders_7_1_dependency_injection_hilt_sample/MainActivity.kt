package com.recepgemalmaz.pazarama_bootcamp_ders_7_1_dependency_injection_hilt_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.recepgemalmaz.pazarama_bootcamp_ders_7_1_dependency_injection_hilt_sample.ui.theme.Pazarama_Bootcamp_Ders_7_1_Dependency_Injection_Hilt_SampleTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Aralarinda dependency olan siniflarin constructorlarina @Inject eklenir
    @Inject
    lateinit var hesap1: BankaHesabi
    //Kullanmaya gerek kalmadi
    //@Inject lateinit var musteri1: Musteri


    //Interface implemente eden siniflarin injectionlarina dair ornek
    @ASample2//ya da ASample2,3 hangisini kullanmissa sample'in dinamik turu o sinif olacaktir.
    @Inject lateinit var sample: ISample


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // musteri1 = Musteri() Ihtiyac kalmadi
        //musteri1.adi = "Recep"
        //musteri1.soyadi = "Gemalmaz"

        // hesap1 = BankaHesabi(musteri1) ihtiyac kalmadi
        hesap1.iban = "TR123456789"
        hesap1.bakiye = 1000L
        hesap1.musteri.adi = "Recep"
        hesap1.musteri.soyadi = "Gemalmaz"


        setContent {
            Pazarama_Bootcamp_Ders_7_1_Dependency_Injection_Hilt_SampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(p1 = hesap1.DisplayHesap(), p2= sample.Foo())
                }
            }
        }
    }
}

@Composable
fun MainScreen(p1: String, p2: String, modifier: Modifier = Modifier) {

    Column {
        Text(
            text = " $p1!",
            modifier = modifier
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))

        Text(text = " $p2!",
            color = Color.Red,
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pazarama_Bootcamp_Ders_7_1_Dependency_Injection_Hilt_SampleTheme {
        MainScreen("Android",  "Bankasi")
    }
}