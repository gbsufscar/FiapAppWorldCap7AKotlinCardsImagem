package br.com.fiap.imcapp

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

fun alteraCorDoCard(imcUsuario: Double): String{
    return if (imcUsuario < 18.5) {
        "#FFED145B" // Cor do Card para "Abaixo do Peso"
    } else if (imcUsuario >= 18.5 && imcUsuario < 25.0) {
        "0xff329f6b" // Cor do Card para "Peso Ideal"
    } else if (imcUsuario >= 25.0 && imcUsuario < 30.0) {
        "#FF5722" // Cor do Card para "Levemente acima do peso"
    } else if (imcUsuario >= 30.0 && imcUsuario < 35.0) {
        "#FFED145B" // Cor do Card para "Obesidade Grau I"
    } else if (imcUsuario >= 35.0 && imcUsuario < 40.0) {
        "#FFED145B" // Cor do Card para "Obesidade Grau II"
    } else {
        "#FF000000" // Cor do Card para "Obesidade Grau III"
    }
}

