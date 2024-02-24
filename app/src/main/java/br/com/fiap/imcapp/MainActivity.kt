package br.com.fiap.imcapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun IMCScreen (){
    Box(
        modifier = Modifier
            .border(4.dp, Color.Red)
            .fillMaxWidth()
    ){
        // Coluna 1 dentro da Box
        Column (
            modifier = Modifier
                .border(4.dp, Color.Green)
                .fillMaxWidth()
        ){
            // Coluna 2 - Cabeçalho/Header da Activity (dentro da Coluna 1)
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(4.dp, Color.Yellow)
                    .fillMaxWidth()
                    .height(160.dp)
            ){
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.bmi),
                    contentDescription ="logo",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(top = 16.dp)

                    )
            }
            // Coluna 3 - Formulário (dendro da Coluna 1 e abaixo da Coluna 2
            Column(
                modifier = Modifier
                    .border(4.dp, Color.Black)
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ){
                /* TODO */
            }
        }

        // Card Resultado

    }




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IMCAppTheme {
        IMCScreen()
    }
}