package com.yagmurerdogan.caranimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yagmurerdogan.caranimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startAnimSet(
                createInfiniteAlphaAnimation(binding.nightLayout, 4000, 0.0f, 1.0f),
                createAlphaAnimation(binding.button, 1000, 1.0f, 0.0f),
                createAlphaAnimation(binding.textView, 1000, 1.0f, 0.0f),
                repeatTransYAnim(binding.carImageView, 4000, -130.0f),
                createInfiniteScaleXAnimation(binding.carImageView, 4000, 0.0f),
                createInfiniteScaleYAnimation(binding.carImageView, 4000, 0.0f),
                createAlphaAnimation(binding.moonImageView, 4000, 0.0f, 1.0f),
                createInfiniteRotateAnimation(binding.sunImageView, 4000, 360.0f),
                createInfiniteTransXAnimation(binding.cloudImageView, 4000, -180.0f),
                createInfiniteTransXAnimation(binding.cloudImageView2, 4000, -180.0f),
                createInfiniteTransXAnimation(binding.cloudImageView3, 4000, -180.0f)
            )
            createSequentialAnim(
                4000,
                createInfiniteAlphaAnimation(binding.sunImageView, 4000, 1.0f, 0.0f),
                createInfiniteAlphaAnimation(binding.moonImageView, 4000, 0.0f, 1.0f)
            )
        }
    }

    private fun createSequentialAnim(time: Long, vararg anims: ObjectAnimator) {
        val multiple = AnimatorSet().apply {
            duration = time
            for (anim in anims) {
                playSequentially(anim)
            }
        }
        multiple.start()
    }

    private fun repeatTransYAnim(view: View, time: Long, endValue: Float): ObjectAnimator {
        val repeat = ObjectAnimator.ofFloat(
            view,
            "translationY",
            0.0f,
            endValue
        ).apply {
            duration = time
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.RESTART
        }
        return repeat
    }

    private fun createAlphaAnimation(
        view: View,
        time: Long,
        startValue: Float,
        endValue: Float
    ): ObjectAnimator {
        val alphaAnim = ObjectAnimator.ofFloat(
            view,
            "alpha",
            startValue,
            endValue
        ).apply {
            duration = time
        }
        return alphaAnim
    }

    private fun createInfiniteAlphaAnimation(
        view: View,
        time: Long,
        startValue: Float,
        endValue: Float
    ): ObjectAnimator {
        val alphaAnim = ObjectAnimator.ofFloat(
            view,
            "alpha",
            startValue,
            endValue
        ).apply {
            duration = time
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        return alphaAnim
    }

    private fun createInfiniteTransXAnimation(
        view: View,
        time: Long,
        endValue: Float
    ): ObjectAnimator {
        val transAnim = ObjectAnimator.ofFloat(
            view,
            "translationX",
            0.0f,
            endValue
        ).apply {
            duration = time
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        return transAnim
    }

    private fun createInfiniteRotateAnimation(
        view: View,
        time: Long,
        endValue: Float
    ): ObjectAnimator {
        val rotateAnim = ObjectAnimator.ofFloat(
            view,
            "rotation",
            0.0f,
            endValue
        ).apply {
            duration = time
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        return rotateAnim
    }

    private fun createScaleYAnimation(view: View, time: Long, endValue: Float): ObjectAnimator {
        val scaleYAnim = ObjectAnimator.ofFloat(
            view,
            "scaleY",
            1.0f,
            endValue
        ).apply {
            duration = time
        }
        return scaleYAnim
    }

    private fun createInfiniteScaleYAnimation(
        view: View,
        time: Long,
        endValue: Float
    ): ObjectAnimator {
        val scaleYAnim = ObjectAnimator.ofFloat(
            view,
            "scaleY",
            1.0f,
            endValue
        ).apply {
            duration = time
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        return scaleYAnim
    }

    private fun createInfiniteScaleXAnimation(
        view: View,
        time: Long,
        endValue: Float
    ): ObjectAnimator {
        val scaleXAnim = ObjectAnimator.ofFloat(
            view,
            "scaleX",
            1.0f,
            endValue
        ).apply {
            duration = time
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
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