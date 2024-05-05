package com.example.calculatevolume

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreenActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val thread = Thread {
            try {
                // Tunda eksekusi selama 2000 milidetik (2 detik)
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                // Setelah penundaan, buka MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                // Hentikan SplashActivity agar tidak kembali saat tombol kembali ditekan dari MainActivity
                finish()
            }
        }
        // Mulai eksekusi thread
        thread.start()
    }
}