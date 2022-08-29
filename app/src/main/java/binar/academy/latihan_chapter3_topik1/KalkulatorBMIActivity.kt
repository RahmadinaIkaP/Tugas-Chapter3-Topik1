package binar.academy.latihan_chapter3_topik1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kalkulatorbmi.*

class KalkulatorBMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulatorbmi)

        btnHitung.setOnClickListener {
            when {
                etUmur.text.isEmpty() -> etUmur.error = "Umur tidak boleh kosong!"
                etTinggiBadan.text.isEmpty() -> etTinggiBadan.error = "Tinggi badan tidak boleh kosong!"
                etBeratBadan.text.isEmpty() -> etBeratBadan.error = "Berat badan tidak boleh kosong"
                else -> {
                    tvUmur.text = "Umur anda: " + etUmur.text + " tahun"
                    tvTinggi.text = "Tinggi:  " + etTinggiBadan.text + " cm"
                    tvBeratBadan.text = "Berat Badan: " + etBeratBadan.text + " kg"
                    hitungBmi()
                }
            }
        }

        btnReset.setOnClickListener {
            etUmur.setText("")
            etTinggiBadan.setText("")
            etBeratBadan.setText("")
        }

        btnPindahSiswa.setOnClickListener {
            startActivity(Intent(this, KalkulatorNilaiMahasiswa::class.java))
        }
    }

    private fun hitungBmi() {
        val tinggiToDouble = etTinggiBadan.text.toString().toDouble()
        val bbToDouble = etBeratBadan.text.toString().toDouble()

        val rumusBmi = bbToDouble/((tinggiToDouble*tinggiToDouble)*0.0001)

        tvBmi.text = "BMI anda: ${rumusBmi.toInt()}"

        hasilKategori(rumusBmi)
    }

    private fun hasilKategori(hasilBmi : Double) {
        when {
            hasilBmi < 16.0 -> tvKategoriBmi.text = "Kategori: Terlalu Kurus"
            hasilBmi in 16.0..17.0 -> tvKategoriBmi.text = "Kategori: Cukup Kurus"
            hasilBmi in 17.0..18.5 -> tvKategoriBmi.text = "Kategori: Sedikit Kurus"
            hasilBmi in 18.5..25.0 -> tvKategoriBmi.text = "Kategori: Normal"
            hasilBmi in 25.0..30.0 -> tvKategoriBmi.text = "Kategori: Gemuk"
            hasilBmi in 30.0..35.0 -> tvKategoriBmi.text = "Kategori: Obesitas Kelas I"
            hasilBmi in 35.0..40.0 -> tvKategoriBmi.text = "Kategori: Obesitas Kelas II"
            hasilBmi > 40.0 -> tvKategoriBmi.text = "Kategori: Obesitas Kelas III"
        }
    }
}