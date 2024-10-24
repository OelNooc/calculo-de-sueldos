package com.oelnooc.calculodesueldos.ui.viewmodel

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oelnooc.calculodesueldos.MainActivity
import com.oelnooc.calculodesueldos.data.model.EmpleadoRegular

class CalculoRegularViewModel : ViewModel() {
    private val _montoLiquido = MutableLiveData<String>()
    val montoLiquido: LiveData<String> get() = _montoLiquido

    private val _orientation = MutableLiveData<Int>()
    val orientation: LiveData<Int> get() = _orientation

    init {
        _orientation.value = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        _montoLiquido.value = "0"
    }

    fun calcularSueldoLiquido(sueldoBrutoText: String) {
        val sueldoBruto = sueldoBrutoText.toDoubleOrNull() ?: 0.0
        val empleadoRegular = EmpleadoRegular(sueldoBruto)
        val sueldoLiquido = empleadoRegular.calcularLiquido()

        _montoLiquido.value = sueldoLiquido.toString()
    }

    fun volverAInicio(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}