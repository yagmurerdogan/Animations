package com.yagmurerdogan.weathermotionlayout

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yagmurerdogan.weathermotionlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startButton.setOnClickListener {
            startAnim(createAlphaAnimation())
            startAnim(createTranslationAnimation())
            startAnimSet(
                createScaleXAnimation(),
                createScaleYAnimation(),
                createRotateAnimation()
            )
        }
    }

    private fun createAlphaAnimation(): ObjectAnimator {
        val alphaAnim = ObjectAnimator.ofFloat(
            binding.weatherTextView,
            "alpha",
            1.0f,
            0.0f
        ).apply {
            duration = 4000
        }
        return alphaAnim
    }

    private fun createTranslationAnimation(): ObjectAnimator {
        val transAnim = ObjectAnimator.ofFloat(
            binding.startButton,
            "translationY",
            0.0f,
            -150.0f
            ).apply {
            duration = 3000
        }
        return transAnim
    }

    private fun createRotateAnimation(): ObjectAnimator {
        val rotateAnim = ObjectAnimator.ofFloat(
            binding.cloudImageView,
            "rotation",
            0.0f,
            360.0f
        ).apply {
            duration = 2000
        }
        return rotateAnim
    }

    private fun createScaleYAnimation(): ObjectAnimator {
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

    private fun createScaleXAnimation(): ObjectAnimator {
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

    private fun startAnim(anim: ObjectAnimator) {
        anim.start()
    }

    private fun startAnimSet(vararg anims: ObjectAnimator) {
        val animationSet = AnimatorSet()
        for (anim in anims) {
            animationSet.playTogether(anim)
        }
        animationSet.start()
    }
}