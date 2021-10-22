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
                createAlphaAnimation(binding.button, 1000, 1.0f, 0.0f),
                createAlphaAnimation(binding.textView, 1000, 1.0f, 0.0f),
            )

            animateCar(
                createTransYAnim(binding.carImageView),
                createInfiniteScaleXAnimation(binding.carImageView),
                createInfiniteScaleYAnimation(binding.carImageView),
            )

            animateClouds(
                binding.cloudImageView,
                binding.cloudImageView2,
                binding.cloudImageView3
            )

            createSequentialAnim(
                createInfiniteRotateAnimation(binding.sunImageView),
                createInfiniteAlphaAnimation(binding.nightLayout, 0.0f, 1.0f),
                createInfiniteAlphaAnimation(binding.sunImageView, 1.0f, 0.0f),
                createInfiniteAlphaAnimation(binding.moonImageView, 0.0f, 1.0f)
            )
        }
    }

    private fun createSequentialAnim(vararg anims: ObjectAnimator) {
        val multiple = AnimatorSet().apply {
            for (anim in anims) {
                playSequentially(anim)
            }
        }
        multiple.start()
    }

    private fun createTransYAnim(
        view: View,
        time: Long = FOUR_SECONDS,
        endValue: Float = -130F
    ): ObjectAnimator {
        val transYAnim = ObjectAnimator.ofFloat(
            view,
            TRANSLATION_Y,
            1.0f,
            endValue
        ).apply {
            duration = time
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        return transYAnim
    }

    private fun createAlphaAnimation(
        view: View,
        time: Long,
        startValue: Float,
        endValue: Float
    ): ObjectAnimator {
        val alphaAnim = ObjectAnimator.ofFloat(
            view,
            ALPHA,
            startValue,
            endValue
        ).apply {
            duration = time
        }
        return alphaAnim
    }

    private fun createInfiniteAlphaAnimation(
        view: View,
        startValue: Float,
        endValue: Float
    ): ObjectAnimator {
        val alphaAnim = ObjectAnimator.ofFloat(
            view,
            ALPHA,
            startValue,
            endValue
        ).apply {
            duration = FOUR_SECONDS
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        return alphaAnim
    }

    private fun createInfiniteTransXAnimation(
        view: View,
        time: Long = 4000L,
        endValue: Float = -180.0f
    ): ObjectAnimator {
        val transAnim = ObjectAnimator.ofFloat(
            view,
            TRANSLATION_X,
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
        time: Long = FOUR_SECONDS,
        endValue: Float = 360.0f
    ): ObjectAnimator {
        val rotateAnim = ObjectAnimator.ofFloat(
            view,
            ROTATION,
            0.0f,
            endValue
        ).apply {
            duration = time
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        return rotateAnim
    }

    private fun createScaleYAnimation(
        view: View,
        time: Long,
        endValue: Float
    ): ObjectAnimator {
        val scaleYAnim = ObjectAnimator.ofFloat(
            view,
            SCALE_Y,
            1.0f,
            endValue
        ).apply {
            duration = time
        }
        return scaleYAnim
    }

    private fun createInfiniteScaleYAnimation(
        view: View,
        time: Long = FOUR_SECONDS,
        endValue: Float = 0.5f
    ): ObjectAnimator {
        val scaleYAnim = ObjectAnimator.ofFloat(
            view,
            SCALE_Y,
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
        time: Long = FOUR_SECONDS,
        endValue: Float = 0.5f
    ): ObjectAnimator {
        val scaleXAnim = ObjectAnimator.ofFloat(
            view,
            SCALE_X,
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

    private fun animateClouds(vararg views: View) {
        val animationSet = AnimatorSet()
        for (view in views) {
            animationSet.playTogether(createInfiniteTransXAnimation(view))
        }
        animationSet.start()
    }

    private fun animateCar(vararg anims: ObjectAnimator) {
        val animationSet = AnimatorSet()
        for (anim in anims) {
            animationSet.playTogether(anim)
        }
        animationSet.start()
    }

    companion object {
        const val SCALE_X = "scaleX"
        const val SCALE_Y = "scaleY"
        const val ROTATION = "rotation"
        const val ALPHA = "alpha"
        const val TRANSLATION_Y = "translationY"
        const val TRANSLATION_X = "translationX"
        const val FOUR_SECONDS = 4000L
    }
}