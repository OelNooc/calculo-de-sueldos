package com.oelnooc.calculodesueldos.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.oelnooc.calculodesueldos.R
import com.oelnooc.calculodesueldos.databinding.ActivityCalculoEmpleadoRegularBinding
import com.oelnooc.calculodesueldos.ui.viewmodel.CalculoRegularViewModel

class CalculoEmpleadoRegular : AppCompatActivity() {

    private lateinit var binding: ActivityCalculoEmpleadoRegularBinding
    private val viewModel: CalculoRegularViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculoEmpleadoRegularBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(viewModel) {
            montoLiquido.observe(this@CalculoEmpleadoRegular) { monto ->
                binding.montoRegTv.text = if (monto != "0") {
                    "$$monto"
                } else {
                    getString(R.string.monto_inicial)
                }
            }

            orientation.observe(this@CalculoEmpleadoRegular) { orientation ->
                requestedOrientation = orientation
            }

            with(binding) {
                calcularRegBtn.setOnClickListener {
                    val sueldoBrutoText = sueldoRegEt.text.toString()
                    calcularSueldoLiquido(sueldoBrutoText)
                }

                volverRegBtn.setOnClickListener {
                    volverAInicio(this@CalculoEmpleadoRegular)
                }
            }
        }
    }
}