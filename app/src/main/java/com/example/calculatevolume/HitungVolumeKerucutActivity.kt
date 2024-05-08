package com.example.calculatevolume

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class HitungVolumeKerucutActivity : Activity(), View.OnClickListener {
    private lateinit var edtJariJari: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var btnReset: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_volume_kerucut)
        initComponents()
        btnHitung.setOnClickListener(this)
        btnReset.setOnClickListener(this)
    }

    private fun initComponents() {
        edtJariJari = findViewById(R.id.edt_jari_jari_kerucut)
        edtTinggi = findViewById(R.id.edt_tinggi_kerucut)
        btnHitung = findViewById(R.id.btn_hitung_kerucut)
        btnReset = findViewById(R.id.btn_reset_kerucut)
        tvHasil = findViewById(R.id.tv_volume_kerucut)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_hitung_kerucut) {
            val inputJariJari = edtJariJari.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()
            var isEmptyFields = false

            if (inputJariJari.isEmpty()) {
                isEmptyFields = true
                edtJariJari.error("Field jari-jari tidak boleh kosong")
            }

            if (inputTinggi.isEmpty()) {
                isEmptyFields = true
                edtTinggi.error("Field tinggi tidak boleh kosong")
            }

            if (!isEmptyFields) {
                val volume = hitungVolumeKerucut(
                    inputJariJari.toDouble(),
                    inputTinggi.toDouble()
                )
                tvHasil.text = volume.toString()
            }
        } else if (view?.id == R.id.btn_reset_kerucut) {
            edtJariJari.text("")
            edtTinggi.text("")
            tvHasil.text("Volume Kerucut")
        }
    }

    private fun hitungVolumeKerucut(jariJari: Double, tinggi: Double): Double {
        val volume = 0.33333 * 0.314 * jariJari * jariJari * tinggi
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