package com.oelnooc.calculodesueldos.data.model

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        var sueldoLiquido = 0.0
        val montoDescuento: Double
        val retencion = 0.13
        return if (sueldoBruto > 0) {
            montoDescuento = sueldoBruto * retencion
            sueldoLiquido = sueldoBruto - montoDescuento
            sueldoLiquido
        } else sueldoLiquido
    }
}