package com.example.calculatevolume

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : Activity(), View.OnClickListener {
    private lateinit var btnKubus: Button
    private lateinit var btnBalok: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        btnBalok.setOnClickListener(this)
        btnKubus.setOnClickListener(this)
    }

    private fun initComponents() {
        btnBalok = findViewById(R.id.btn_balok)
        btnKubus = findViewById(R.id.btn_kubus)

    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_balok) {
            val intent = Intent(this, HitungVolumeBalokActivity::class.java)
            startActivity(intent)
        } else if (view?.id == R.id.btn_kubus) {
            val intent = Intent(this, HitungVolumeKubusActivity::class.java)
            startActivity(intent)
        }
    }
//
//    private lateinit var edtPanjang: EditText
//    private lateinit var edtLebar: EditText
//    private lateinit var edtTinggi: EditText
//    private lateinit var btnHitung: Button
//    private lateinit var btnReset: Button
//    private lateinit var tvHasil: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        initComponents()
//        btnHitung.setOnClickListener(this)
//        btnReset.setOnClickListener(this)
//    }
//
//    private fun initComponents() {
//        edtPanjang = findViewById(R.id.edt_panjang)
//        edtLebar = findViewById(R.id.edt_lebar)
//        edtTinggi = findViewById(R.id.edt_tinggi)
//        btnHitung = findViewById(R.id.btn_hitung)
//        btnReset = findViewById(R.id.btn_reset)
//        tvHasil = findViewById(R.id.tv_volume)
//    }
//
//    override fun onClick(view: View?) {
//        if (view?.id == R.id.btn_hitung) {
//            val inputPanjang = edtPanjang.text.toString().trim()
//            val inputLebar = edtLebar.text.toString().trim()
//            val inputTinggi = edtTinggi.text.toString().trim()
//            var isEmptyFields = false
//
//            if (inputPanjang.isEmpty()) {
//                isEmptyFields = true
//                edtPanjang.error("Field panjang tidak boleh kosong")
//            }
//
//            if (inputLebar.isEmpty()) {
//                isEmptyFields = true
//                edtLebar.error("Field lebar tidak boleh kosong")
//            }
//
//            if (inputTinggi.isEmpty()) {
//                isEmptyFields = true
//                edtTinggi.error("Field tinggi tidak boleh kosong")
//            }
//
//            if (!isEmptyFields) {
//                val volume = hitungVolumeBalok(
//                    inputPanjang.toDouble(),
//                    inputLebar.toDouble(),
//                    inputTinggi.toDouble()
//                )
//                tvHasil.text = volume.toString()
//            }
//        } else if (view?.id == R.id.btn_reset) {
//            edtPanjang.text("")
//            edtLebar.text("")
//            edtTinggi.text("")
//            tvHasil.text("Volume Balok")
//        }
//    }
//
//    private fun hitungVolumeBalok(panjang: Double, lebar: Double, tinggi: Double): Double {
//        val volume = panjang * lebar * tinggi
//        val df = DecimalFormat("#.###") // Format dengan maksimal 3 angka di belakang koma
//        return df.format(volume).toDouble()
//    }
//
//    private fun EditText.error(s: String) {
//        this.error = s
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("STATE_RESULT", tvHasil.text.toString())
//    }
//
//    override fun onRestoreInstanceState(
//        savedInstanceState: Bundle?,
//        persistentState: PersistableBundle?
//    ) {
//        super.onRestoreInstanceState(savedInstanceState, persistentState)
//        if (savedInstanceState != null) {
//            val hasil = savedInstanceState.getString("STATE_RESULT")
//            tvHasil.text(hasil)
//        }
//    }
//
//    private fun TextView.text(hasil: String?) {
//        this.text = hasil
//    }
}



