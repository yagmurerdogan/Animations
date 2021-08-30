package com.yagmurerdogan.weathermotionlayout

import android.animation.AnimatorSet
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
            //startAlphaAnimation()
            startAnimSet(startScaleXAnimation(), startScaleYAnimation())

        }

    }

    private fun startScaleYAnimation(): ObjectAnimator {
        val scaleYAnim = ObjectAnimator.ofFloat(
            binding.cloudImageView,
            "scaleY",
            1.0f,
            2.0f
        ).apply {
            duration = 2000
        }
        return scaleYAnim
    }

    private fun startScaleXAnimation(): ObjectAnimator {
        val scaleXAnim = ObjectAnimator.ofFloat(
            binding.cloudImageView,
            "scaleX",
            1.0f,
            2.0f
        ).apply {
            duration = 2000
        }
        return scaleXAnim
    }


    private fun startAnimSet(anim1: ObjectAnimator, anim2: ObjectAnimator) {
        val animationSet = AnimatorSet()
        animationSet.playTogether(anim1, anim2)
        animationSet.start()
    }

    private fun startAlphaAnimation() {
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