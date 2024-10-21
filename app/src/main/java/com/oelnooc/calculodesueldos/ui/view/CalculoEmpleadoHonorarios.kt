package com.oelnooc.calculodesueldos.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oelnooc.calculodesueldos.R
import com.oelnooc.calculodesueldos.ui.theme.CalculoDeSueldosTheme
import com.oelnooc.calculodesueldos.ui.viewmodel.CalculoHonorariosViewModel

class CalculoEmpleadoHonorarios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculoDeSueldosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculoEmpleadoHonorariosScreen()
                }
            }
        }
    }
}

@Composable
fun CalculoEmpleadoHonorariosScreen(viewModel: CalculoHonorariosViewModel = viewModel()) {
    var sueldoBruto by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.calc_sueldo_hon_title),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        OutlinedTextField(
                            value = sueldoBruto,
                            onValueChange = { sueldoBruto = it },
                            label = { Text(text = stringResource(id = R.string.ingresa_el_sueldo_bruto)) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { viewModel.calcularSueldoLiquido(sueldoBruto) }) {
                    Text(text = stringResource(id = R.string.calcular))
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(id = R.string.monto_a_pagar),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(15.dp))

                val monto by viewModel.montoLiquido.observeAsState("0")
                Text(
                    text = monto,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { viewModel.volverAInicio(context) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.volver))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculoEmpleadoHonorariosPreview() {
    CalculoDeSueldosTheme {
        CalculoEmpleadoHonorariosScreen()
    }
}
