package com.oelnooc.calculodesueldos.ui.viewmodel

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oelnooc.calculodesueldos.ui.view.CalculoEmpleadoHonorarios
import com.oelnooc.calculodesueldos.ui.view.CalculoEmpleadoRegular
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _orientation = MutableLiveData<Int>()
    val orientation: LiveData<Int> get() = _orientation

    init {
        _orientation.value = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun goToScreen(screen: String, context: Context) {
        viewModelScope.launch {
            when (screen) {
                "honorarios" -> {
                    val intent = Intent(context, CalculoEmpleadoHonorarios::class.java)
                    context.startActivity(intent)
                }
                "regular" -> {
                    val intent = Intent(context, CalculoEmpleadoRegular::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }
}