package com.yagmurerdogan.caranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yagmurerdogan.caranimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            animateMainActivity()
        }
    }

    private fun animateMainActivity() {
        startAnimSet(
            with(binding) {
                arrayOf(cloudImageView, cloudImageView2, cloudImageView3).forEach { cloudImage ->
                    cloudImage.createAnim(TRANSLATION_X, ZERO_FLOAT, NEGATIVE_HALF_TOUR)
                        .makeInfiniteAndReverse()
                }
                button.createAnim(ALPHA, ONE_FLOAT, ZERO_FLOAT, ONE_SECOND)
                textView.createAnim(ALPHA, ONE_FLOAT, ZERO_FLOAT, ONE_SECOND)
                carImageView.createAnim(TRANSLATION_Y, ONE_FLOAT, CAR_ROAD)
                carImageView.createAnim(SCALE_X, ONE_FLOAT, HALF_FLOAT).makeInfiniteAndReverse()
                carImageView.createAnim(SCALE_Y, ONE_FLOAT, HALF_FLOAT).makeInfiniteAndReverse()
                sunImageView.createAnim(ROTATION, ZERO_FLOAT, FULL_TOUR).makeInfiniteAndReverse()
                nightLayout.createAnim(ALPHA, ZERO_FLOAT, ONE_FLOAT).makeInfiniteAndReverse()
                sunImageView.createAnim(ALPHA, ONE_FLOAT, ZERO_FLOAT).makeInfiniteAndReverse()
                moonImageView.createAnim(ALPHA, ZERO_FLOAT, ONE_FLOAT).makeInfiniteAndReverse()
            }
        )
    }
}