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
    private lateinit var btnLimas: Button
    private lateinit var btnKerucut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        btnBalok.setOnClickListener(this)
        btnKubus.setOnClickListener(this)
        btnLimas.setOnClickListener(this)
        btnKerucut.setOnClickListener(this)
    }

    private fun initComponents() {
        btnBalok = findViewById(R.id.btn_balok)
        btnKubus = findViewById(R.id.btn_kubus)
        btnLimas = findViewById(R.id.btn_limas)
        btnKerucut = findViewById(R.id.btn_kerucut)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_balok) {
            val intent = Intent(this, HitungVolumeBalokActivity::class.java)
            startActivity(intent)
        } else if (view?.id == R.id.btn_kubus) {
            val intent = Intent(this, HitungVolumeKubusActivity::class.java)
            startActivity(intent)
        } else if (view?.id == R.id.btn_limas) {
            val intent = Intent(this, HitungVolumeLimasActivity::class.java)
            startActivity(intent)
        } else if (view?.id == R.id.btn_kerucut) {
            val intent = Intent(this, HitungVolumeKerucutActivity::class.java)
            startActivity(intent)
        }
    }
}



