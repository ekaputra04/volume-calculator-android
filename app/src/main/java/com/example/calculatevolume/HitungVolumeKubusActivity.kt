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

class HitungVolumeKubusActivity : Activity(), View.OnClickListener {
    private lateinit var edtSisi: EditText
    private lateinit var btnHitung: Button
    private lateinit var btnReset: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_volume_kubus)
        initComponents()
        btnHitung.setOnClickListener(this)
        btnReset.setOnClickListener(this)
    }

    private fun initComponents() {
        edtSisi = findViewById(R.id.edt_sisi_kubus)
        btnHitung = findViewById(R.id.btn_hitung_kubus)
        btnReset = findViewById(R.id.btn_reset_kubus)
        tvHasil = findViewById(R.id.tv_volume_kubus)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_hitung_kubus) {
            val inputSisi = edtSisi.text.toString().trim()
            var isEmptyFields = false

            if (inputSisi.isEmpty()) {
                isEmptyFields = true
                edtSisi.error("Field sisi tidak boleh kosong")
            }

            if (!isEmptyFields) {
                val volume = hitungVolumeKubus(inputSisi.toDouble())
                tvHasil.text = volume.toString()
            }
        } else if (view?.id == R.id.btn_reset_kubus) {
            edtSisi.text("")
            tvHasil.text("Volume Kubus")
        }
    }

    private fun hitungVolumeKubus(sisi: Double): Double {
        val volume = sisi * sisi * sisi
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