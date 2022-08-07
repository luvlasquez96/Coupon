package com.example.coupons.mainModule.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.coupons.BR
import com.example.coupons.R
import com.example.coupons.common.utils.hideKeyboard
import com.example.coupons.databinding.ActivityMainBinding
import com.example.coupons.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding=ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        setupObservers()
        //setupButtons()

    }

    private fun setupViewModel() {
        //mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]
        val vm:MainViewModel by viewModels()
        binding.lifecycleOwner= this
        binding.setVariable(BR.viewModel,vm)
    }

    private fun setupObservers() {
        binding.viewModel?.let {
            it.coupon.observe(this@MainActivity) { coupon ->
                binding.isActive = coupon != null && coupon.isActive

            }
            it.getSnackbarMsg().observe(this@MainActivity) { msg ->
                Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()

            }

            it.isHideKeyboard().observe(this@MainActivity) { isHide ->
                if (isHide) hideKeyboard(this@MainActivity, binding.root)

            }
        }

        /*private fun setupButtons() {
        binding.btnConsult.setOnClickListener {
            //mainViewModel.consultCouponBycode((binding.etcoupon.text.toString()))
            hideKeyboard(this,binding.root)
        }
        binding.btnCreate.setOnClickListener {
            val coupon= CouponEntity(
                code= binding.etcoupon.text.toString(),
                description = binding.etdescription.text.toString())
            //mainViewModel.saveCoupon(coupon)
            hideKeyboard(this,binding.root)
        }
    }*/
    }
}