package com.yagmurerdogan.caranimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.util.Property
import android.view.View
import com.yagmurerdogan.caranimation.databinding.ActivityMainBinding

/**
 * Created by Yağmur ERDOĞAN on 23 October 2021
 */

object MainAnimation {
    fun animateMainActivity(binding: ActivityMainBinding) {
        startAnimSet(
            createAnim(binding.button, ALPHA, ONE_FLOAT, ZERO_FLOAT, ONE_SECOND),
            createAnim(binding.textView, ALPHA, ONE_FLOAT, ZERO_FLOAT, ONE_SECOND),
            createAnim(binding.carImageView, TRANSLATION_Y, ONE_FLOAT, CAR_ROAD, FOUR_SECONDS),
            createAnim(
                binding.carImageView,
                SCALE_X,
                ONE_FLOAT,
                HALF_FLOAT,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
            createAnim(
                binding.carImageView,
                SCALE_Y,
                ONE_FLOAT,
                HALF_FLOAT,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
            createAnim(
                binding.sunImageView,
                ROTATION,
                ZERO_FLOAT,
                FULL_TOUR,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
            createAnim(
                binding.nightLayout,
                ALPHA,
                ZERO_FLOAT,
                ONE_FLOAT,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
            createAnim(
                binding.sunImageView,
                ALPHA,
                ONE_FLOAT,
                ZERO_FLOAT,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
            createAnim(
                binding.moonImageView,
                ALPHA,
                ZERO_FLOAT,
                ONE_FLOAT,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
            createAnim(
                binding.cloudImageView,
                TRANSLATION_X,
                ZERO_FLOAT,
                NEGATIVE_HALF_TOUR,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
            createAnim(
                binding.cloudImageView2,
                TRANSLATION_X,
                ZERO_FLOAT,
                NEGATIVE_HALF_TOUR,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
            createAnim(
                binding.cloudImageView3,
                TRANSLATION_X,
                ZERO_FLOAT,
                NEGATIVE_HALF_TOUR,
                FOUR_SECONDS
            ).makeInfiniteAndReverse(),
        )
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

    private fun startAnimSet(vararg animations: ObjectAnimator) {
        val animationSet = AnimatorSet()
        for (animation in animations) {
            animationSet.playTogether(animation)
        }
        animationSet.start()
    }


        private val ROTATION: Property<View, Float> = View.ROTATION
        private val ALPHA: Property<View, Float> = View.ALPHA
        private val TRANSLATION_Y: Property<View, Float> = View.TRANSLATION_Y
        private val TRANSLATION_X: Property<View, Float> = View.TRANSLATION_X
        private val SCALE_X: Property<View, Float> = View.SCALE_X
        private val SCALE_Y: Property<View, Float> = View.SCALE_Y
        private const val FOUR_SECONDS = 4000L
        private const val ONE_SECOND = 1000L
        private const val ONE_FLOAT = 1.0f
        private const val HALF_FLOAT = 0.5f
        private const val ZERO_FLOAT = 0.0f
        private const val FULL_TOUR = 360.0f
        private const val NEGATIVE_HALF_TOUR = -180.0f
        private const val CAR_ROAD = -130.0f

}