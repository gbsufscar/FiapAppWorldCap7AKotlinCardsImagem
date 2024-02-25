package br.com.fiap.imcapp

import androidx.compose.ui.graphics.Color
import kotlin.math.pow

fun calcularImc(pesoUsuario: Double, alturaUsuario: Double): Double {
    var imc = pesoUsuario / ((alturaUsuario / 100)).pow(2)
    return imc
}

fun obterStatusImc(imcUsuario: Double): String {
    return if (imcUsuario < 18.5) {
        "Abaixo do peso"
    } else if (imcUsuario >= 18.5 && imcUsuario < 25.0) {
        "Peso Ideal"
    } else if (imcUsuario >= 25.0 && imcUsuario < 30.0) {
        "Levemente acima do peso"
    } else if (imcUsuario >= 30.0 && imcUsuario < 35.0) {
        "Obesidade Grau I"
    } else if (imcUsuario >= 35.0 && imcUsuario < 40.0) {
        "Obesidade Grau II"
    } else {
        "Obesidade Grau III"
    }
}

fun alteraCorDoCard(imcUsuario: Double): Color{
    return if (imcUsuario < 18.5) {
        Color.Red // Cor do Card para "Abaixo do Peso"

    } else if (imcUsuario >= 18.5 && imcUsuario < 25.0) {
        Color.Green // Cor do Card para "Peso Ideal"
    } else if (imcUsuario >= 25.0 && imcUsuario < 30.0) {
        Color.Yellow // Cor do Card para "Levemente acima do peso"
    } else if (imcUsuario >= 30.0 && imcUsuario < 35.0) {
        Color.Red // Cor do Card para "Obesidade Grau I"
    } else if (imcUsuario >= 35.0 && imcUsuario < 40.0) {
        Color.Red // Cor do Card para "Obesidade Grau II"
    } else {
        Color.Black // Cor do Card para "Obesidade Grau III"
    }
}

