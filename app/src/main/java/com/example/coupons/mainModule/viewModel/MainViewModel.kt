package com.example.coupons.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coupons.CouponApplication
import com.example.coupons.R
import com.example.coupons.common.entities.CouponEntity
import com.example.coupons.common.utils.getMsgErrorByCode
import com.example.coupons.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    private val repository= MainRepository()

    //private val result=MutableLiveData<CouponEntity>()
    //fun getResult()=result
    val coupon= MutableLiveData(CouponEntity())

    private val hideKeyboard= MutableLiveData<Boolean>()
    fun isHideKeyboard()=hideKeyboard

    private val snackbarMsg=MutableLiveData<Int>()
    fun getSnackbarMsg()=snackbarMsg

    /*fun consultCouponBycodeOld(code:String){
        viewModelScope.launch {
            result.value=repository.consultCouponByCode(code)
        }
    }*/
    fun consultCouponBycode(){
        coupon.value?.code?.let{code->
            viewModelScope.launch {
                hideKeyboard.value=true
                coupon.value=repository.consultCouponByCode(code)?: CouponEntity(code=code,isActive=false)
            }
        }
        //viewModelScope.launch {
            //result.value=repository.consultCouponByCode(code)
        //}
    }

    /*fun saveCouponOld(couponEntity: CouponEntity){
        viewModelScope.launch {
            try{
                repository.saveCoupon(couponEntity)
                consultCouponBycode(couponEntity.code)
                snackbarMsg.value=(R.string.main_save_success)
            } catch (e:Exception){
                snackbarMsg.value= getMsgErrorByCode(e.message)
            }

        }
    }*/
    fun saveCoupon(){
        coupon.value?.let{ couponEntity->
            viewModelScope.launch {
                hideKeyboard.value=true
                try{
                    couponEntity.isActive=true
                    repository.saveCoupon(couponEntity)
                    consultCouponBycode()
                    snackbarMsg.value=(R.string.main_save_success)
                } catch (e:Exception){
                    snackbarMsg.value= getMsgErrorByCode(e.message)
                }
            }

        }
    }
}