package br.com.fiap.imcapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.imcapp.ui.theme.IMCAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMCAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IMCScreen()
                }
            }
        }
    }
}

@Composable
fun IMCScreen() {
    // Variáveis de estado
    var peso = remember {
        mutableStateOf("")
    }

    var altura by remember { // O emprego do by viabilizar utilizar o valor do objeto altura.
        mutableStateOf("")
    }

    var imc by remember { // O emprego do by viabilizar utilizar o valor do objeto IMC.
        mutableStateOf(0.0)
    }

    var statusIMC by remember {
        mutableStateOf("")
    }

    var corDoCard by remember {
        mutableStateOf(Color.Green)
    }


    Box(
        modifier = Modifier
            //.border(4.dp, Color.Red)
            .fillMaxWidth()
    ) {
        // Coluna 1 dentro da Box
        Column(
            modifier = Modifier
                //.border(4.dp, Color.Green)
                .fillMaxWidth()
        ) {
            // Coluna 2 - Cabeçalho/Header da Activity (dentro da Coluna 1)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    //.border(4.dp, Color.Yellow)
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(colorResource(id = R.color.vermenlho_fiap)) // Arg.: recurso (res) de cor (tag).
            ) {
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.bmi),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(top = 16.dp)
                )
                Text(
                    text = "Calculadora IMC",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
                )
            }
            // Coluna 3 - Formulário (dendro da Coluna 1 e abaixo da Coluna 2
            Column(
                modifier = Modifier
                    //.border(4.dp, Color.Black)
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                // Card Formulário (agrupamento de informações)
                // -- Organizar o formulário numa Column
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .offset(y = (-30).dp) // Sobrepror o componente acima pelo ajuste no eixo y.
                            .fillMaxWidth(),
                        //.height((300.dp)),
                        colors = CardDefaults
                            .cardColors(containerColor = Color(0xfff9f6f6)),
                        elevation = CardDefaults
                            .cardElevation(defaultElevation = 4.dp),
                        //border = BorderStroke(width = 1.dp, Color.Magenta)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 16.dp, horizontal = 32.dp)
                        ) {
                            Text(
                                text = "Seus Dados",
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.vermenlho_fiap),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            Text(
                                text = "Seu peso",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(id = R.color.vermenlho_fiap)
                            )
                            OutlinedTextField(
                                value = peso.value,
                                onValueChange = {
                                    peso.value = it
                                },
                                placeholder = {
                                    Text(text = "Seu peso em kg.")
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.vermenlho_fiap),
                                    focusedBorderColor = colorResource(id = R.color.vermenlho_fiap)
                                ),
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            Text(
                                text = "Sua Altura",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(id = R.color.vermenlho_fiap)
                            )
                            OutlinedTextField(
                                value = altura,
                                onValueChange = {
                                    altura = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "Sua altura em cm."
                                    )
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.vermenlho_fiap),
                                    focusedBorderColor = colorResource(id = R.color.vermenlho_fiap)
                                ),
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {
                                    imc = calcularImc(
                                        pesoUsuario = peso.value.toDouble(), // Casting String para Double
                                        alturaUsuario = altura.toDouble()
                                    )

                                    statusIMC = obterStatusImc(imcUsuario = imc)

                                    corDoCard = alteraCorDoCard(imcUsuario = imc)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.vermenlho_fiap)
                                )
                            ) {
                                Text(
                                    text = "CALCULAR",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }
        // Card Resultados
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 32.dp, vertical = 24.dp)
                .align(Alignment.BottomCenter),
            //colors = CardDefaults.cardColors(containerColor = Color(0xff329f6b)),
            // -- Automação para mudar a cor do Card baseda no valor do imc.
            //colors = CardDefaults.cardColors(containerColor = Color(corDoCard.toLong())),
            colors = CardDefaults.cardColors(containerColor = corDoCard), // Cor do Card baseada no valor do IMC.
            elevation = CardDefaults.cardElevation(4.dp),
            //border = BorderStroke(width = 1.dp, Color(0xffed145b))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxSize()
            ) {
                Column() {
                    Text(
                        text = "Resultado",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                    Text(
                        text = statusIMC,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
                Text(
                    text = String.format("%.1f", imc),
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 26.sp,
                    textAlign = TextAlign.End
                )
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IMCAppTheme {
        IMCScreen()
    }
}