package com.example.calculatevolume

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class HitungVolumeBalokActivity : Activity(), View.OnClickListener {
    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var btnReset: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_volume_balok)
        initComponents()
        btnHitung.setOnClickListener(this)
        btnReset.setOnClickListener(this)
    }

    private fun initComponents() {
        edtPanjang = findViewById(R.id.edt_panjang_balok)
        edtLebar = findViewById(R.id.edt_lebar_balok)
        edtTinggi = findViewById(R.id.edt_tinggi_balok)
        btnHitung = findViewById(R.id.btn_hitung_balok)
        btnReset = findViewById(R.id.btn_reset_balok)
        tvHasil = findViewById(R.id.tv_volume_balok)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_hitung_balok) {
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()
            var isEmptyFields = false

            if (inputPanjang.isEmpty()) {
                isEmptyFields = true
                edtPanjang.error("Field panjang tidak boleh kosong")
            }

            if (inputLebar.isEmpty()) {
                isEmptyFields = true
                edtLebar.error("Field lebar tidak boleh kosong")
            }

            if (inputTinggi.isEmpty()) {
                isEmptyFields = true
                edtTinggi.error("Field tinggi tidak boleh kosong")
            }

            if (!isEmptyFields) {
                val volume = hitungVolumeBalok(
                    inputPanjang.toDouble(),
                    inputLebar.toDouble(),
                    inputTinggi.toDouble()
                )
                tvHasil.text = volume.toString()
            }
        } else if (view?.id == R.id.btn_reset_balok) {
            edtPanjang.text("")
            edtLebar.text("")
            edtTinggi.text("")
            tvHasil.text("Volume Balok")
        }
    }

    private fun hitungVolumeBalok(panjang: Double, lebar: Double, tinggi: Double): Double {
        val volume = panjang * lebar * tinggi
        val df = DecimalFormat("#.###") // Format dengan maksimal 3 angka di belakang koma
        return df.format(volume).toDouble()
    }

    private fun EditText.error(s: String) {
        this.error = s
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("STATE_RESULT", tvHasil.text.toString())
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        if (savedInstanceState != null) {
            val hasil = savedInstanceState.getString("STATE_RESULT")
            tvHasil.text(hasil)
        }
    }

    private fun TextView.text(hasil: String?) {
        this.text = hasil
    }
}