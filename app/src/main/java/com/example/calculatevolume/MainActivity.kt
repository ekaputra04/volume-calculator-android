package com.example.calculatevolume

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity(), View.OnClickListener {
    lateinit var edtPanjang: EditText
    lateinit var edtLebar: EditText
    lateinit var edtTinggi: EditText
    lateinit var btnHitung: Button
    lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        btnHitung.setOnClickListener(this)
    }

    private fun initComponents() {
        edtPanjang = findViewById(R.id.edt_panjang)
        edtLebar = findViewById(R.id.edt_lebar)
        edtTinggi = findViewById(R.id.edt_tinggi)
        btnHitung = findViewById(R.id.btn_hitung)
        tvHasil = findViewById(R.id.tv_volume)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_hitung) {
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

        }
    }

    private fun hitungVolumeBalok(panjang: Double, lebar: Double, tinggi: Double): Double {
        return panjang * lebar * tinggi
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



