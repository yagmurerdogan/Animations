package com.yagmurerdogan.weathermotionlayout

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yagmurerdogan.weathermotionlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startButton.setOnClickListener {
            Log.e("Clicked", "Start")
            startAlphaAnimation()
        }

    }

    fun startAlphaAnimation() {
        val alphaAnim = ObjectAnimator.ofFloat(
            binding.weatherTextView,
            "alpha",
            1.0f,
            0.0f
        ).apply {
            duration = 2000
        }
        alphaAnim.start()
    }
}