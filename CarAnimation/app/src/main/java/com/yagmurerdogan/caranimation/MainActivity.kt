package com.yagmurerdogan.caranimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Property
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
                createAnim(binding.button, ALPHA, ONE_FLOAT, ZERO_FLOAT, ONE_SECOND),
                createAnim(binding.textView, ALPHA, ONE_FLOAT, ZERO_FLOAT, ONE_SECOND),
                createAnim(binding.carImageView, TRANSLATION_Y,ONE_FLOAT,CAR_ROAD, FOUR_SECONDS),
                createAnim(binding.carImageView, SCALE_X, ONE_FLOAT,HALF_FLOAT, FOUR_SECONDS).makeInfiniteAndReverse(),
                createAnim(binding.carImageView, SCALE_Y, ONE_FLOAT,HALF_FLOAT, FOUR_SECONDS).makeInfiniteAndReverse(),
            )

            animateClouds(
                binding.cloudImageView,
                binding.cloudImageView2,
                binding.cloudImageView3
            )

            startSequentialAnim(
                createAnim(binding.sunImageView,ROTATION, ZERO_FLOAT, FULL_TOUR, FOUR_SECONDS).makeInfiniteAndReverse(),
                createAnim(binding.nightLayout, ALPHA, ZERO_FLOAT, ONE_FLOAT, FOUR_SECONDS).makeInfiniteAndReverse(),
                createAnim(binding.sunImageView, ALPHA, ONE_FLOAT, ZERO_FLOAT, FOUR_SECONDS).makeInfiniteAndReverse(),
                createAnim(binding.moonImageView, ALPHA, ZERO_FLOAT, ONE_FLOAT, FOUR_SECONDS).makeInfiniteAndReverse()
            )
        }
    }

    private fun createAnim(
        view: View,
        property: Property<View, Float>,
        startValue: Float,
        endValue: Float,
        time: Long
    ): ObjectAnimator {
        return ObjectAnimator.ofFloat(
            view,
            property,
            startValue,
            endValue
        ).apply {
            duration = time
        }
    }

    private fun ObjectAnimator.makeInfiniteAndReverse(): ObjectAnimator {
        return this.apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
    }

    private fun startSequentialAnim(vararg anims: ObjectAnimator) {
        val multiple = AnimatorSet().apply {
            for (anim in anims) {
                playSequentially(anim)
            }
        }
        multiple.start()
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
            animationSet.playTogether(
                createAnim(view, TRANSLATION_X, ZERO_FLOAT,NEGATIVE_HALF_TOUR, FOUR_SECONDS).makeInfiniteAndReverse()
            )
        }
        animationSet.start()
    }

    companion object {
        val ROTATION: Property<View, Float> = View.ROTATION
        val ALPHA: Property<View, Float> = View.ALPHA
        val TRANSLATION_Y: Property<View, Float> = View.TRANSLATION_Y
        val TRANSLATION_X: Property<View, Float> = View.TRANSLATION_X
        val SCALE_X: Property<View, Float> = View.SCALE_X
        val SCALE_Y: Property<View, Float> = View.SCALE_Y
        const val FOUR_SECONDS = 4000L
        const val ONE_SECOND = 1000L
        const val ONE_FLOAT = 1.0f
        const val HALF_FLOAT = 0.5f
        const val ZERO_FLOAT = 0.0f
        const val FULL_TOUR = 360.0f
        const val NEGATIVE_HALF_TOUR = -180.0f
        const val CAR_ROAD = -130.0f
    }
}