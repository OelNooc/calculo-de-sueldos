package com.oelnooc.calculodesueldos.data.model

abstract class Empleado (val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}