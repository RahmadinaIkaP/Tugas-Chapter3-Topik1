package binar.academy.latihan_chapter3_topik1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kalkulator_nilai_mahasiswa.*
import kotlinx.android.synthetic.main.activity_kalkulatorbmi.*

class KalkulatorNilaiMahasiswa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_nilai_mahasiswa)

        btnHitungMhs.setOnClickListener {
           dataMahasiswa()
        }

        btnResetMhs.setOnClickListener {
            etNamaMhs.setText("")
            etNimMhs.setText("")
            etNilaiUas.setText("")
            etNilaiUts.setText("")
            etNilaiTugas.setText("")
        }
    }

    private fun dataMahasiswa(){
        when{
            etNamaMhs.text.isEmpty() -> etNamaMhs.error = "Nama Mahasiswa Tidak Boleh Kosong!"
            etNimMhs.text.isEmpty() -> etNimMhs.error = "Nim Tidak Boleh Kosong!"
            etNilaiUas.text.isEmpty() -> etNilaiUas.error = "Nilai UAS Tidak Boleh Kosong!"
            etNilaiUts.text.isEmpty() -> etNilaiUts.error = "Nilai UTS Tidak Boleh Kosong!"
            etNilaiTugas.text.isEmpty() -> etNilaiTugas.error = "Nilai Tugas Tidak Boleh Kosong!"
            else -> {
                tvNamaMhs.text = "Nama Mahasiswa: " + etNamaMhs.text
                tvNimMhs.text = "Nim: " + etNimMhs.text
                tvUasMhs.text = "UAS: " + etNilaiUas.text
                tvUtsMhs.text = "UTS: " + etNilaiUts.text
                tvTugasMhs.text = "Tugas: " + etNilaiTugas.text

                hitungTotaldanRataNilai()
            }
        }
    }

    private fun hitungTotaldanRataNilai() {
        val nUastoInt = etNilaiUas.text.toString().toInt()
        val nUtstoInt = etNilaiUts.text.toString().toInt()
        val nTugastoInt = etNilaiTugas.text.toString().toInt()

        val nilaiTotal = nUastoInt + nUtstoInt + nTugastoInt
        val nilaiRataRata = (nUastoInt + nUtstoInt + nTugastoInt)/3

        tvNilaiTotalMhs.text = "Total: $nilaiTotal"
        tvRataNilaiMhs.text = "Rata-Rata Nilai: $nilaiRataRata"

        nilaiHuruf(nilaiRataRata)
    }

    private fun nilaiHuruf(nRataRata: Int){
        var nHuruf = ' '

        when(nRataRata){
            in 0..60 -> nHuruf = 'E'
            in 61..70 -> nHuruf = 'D'
            in 71..80 -> nHuruf = 'C'
            in 81..90 -> nHuruf = 'B'
            in 91..100 -> nHuruf = 'A'
        }
        tvNilaiHurufMhs.text = "Nilai Huruf: $nHuruf"

        statusLulus(nHuruf)
    }

    private fun statusLulus(nHuruf: Char) {
        var keteranganLulus = ""

        when(nHuruf){
            'A' -> keteranganLulus = "Lulus"
            'B' -> keteranganLulus = "Lulus"
            'C' -> keteranganLulus = "Lulus"
            'D' -> keteranganLulus = "Tidak Lulus"
            'E' -> keteranganLulus = "Tidak Lulus"
        }
        tvStatusNilaiMhs.text = "Status: $keteranganLulus"
    }
}