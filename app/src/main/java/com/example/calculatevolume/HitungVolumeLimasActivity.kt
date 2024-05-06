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

class HitungVolumeLimasActivity : Activity(), View.OnClickListener {
    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var btnReset: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_volume_limas)
        initComponents()
        btnHitung.setOnClickListener(this)
        btnReset.setOnClickListener(this)
    }

    private fun initComponents() {
        edtPanjang = findViewById(R.id.edt_panjang_limas)
        edtLebar = findViewById(R.id.edt_lebar_limas)
        edtTinggi = findViewById(R.id.edt_tinggi_limas)
        btnHitung = findViewById(R.id.btn_hitung_limas)
        btnReset = findViewById(R.id.btn_reset_limas)
        tvHasil = findViewById(R.id.tv_volume_limas)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_hitung_limas) {
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
                val volume = hitungVolumeLimas(
                    inputPanjang.toDouble(),
                    inputLebar.toDouble(),
                    inputTinggi.toDouble()
                )
                tvHasil.text = volume.toString()
            }
        } else if (view?.id == R.id.btn_reset_limas) {
            edtPanjang.text("")
            edtLebar.text("")
            edtTinggi.text("")
            tvHasil.text("Volume Limas")
        }
    }

    private fun hitungVolumeLimas(panjang: Double, lebar: Double, tinggi: Double): Double {
        val volume = 0.33333 * panjang * lebar * tinggi
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