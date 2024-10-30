package com.example.userinput

import androidx.annotation.Size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScren(
    modifier: Modifier = Modifier
){
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("laki - laki", "Perempuan")

    var confirmname by rememberSaveable { mutableStateOf("") }
    var confirmemail by remember { mutableStateOf("") }
    var confirmalamat by remember { mutableStateOf("") }
    var confirmnoHp by remember { mutableStateOf("") }
    var confirmselectedGender by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "BIODATA")


        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama")},
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row (){
            jenisKelamin.forEach{ item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = selectedGender == item,
                        onClick = {
                            selectedGender = item
                        })
                    Text(item)
                }


            }


        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan email")},
            label = { Text("Email") },
            keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat")},
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = noHp,
            onValueChange = {noHp = it},
            placeholder = { Text("Masukkan noHp")},
            label = { Text("noHp") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Button(onClick = {
            confirmname = nama
            confirmselectedGender = selectedGender
            confirmemail = email
            confirmalamat = alamat
            confirmnoHp = noHp

        }) {
            Text("Save")
        }

        Card(modifier = Modifier.size(height =  200.dp, width = 300.dp)) {
            Column {
                CardSection(judulParam = "Nama", isiParam = confirmname)
                CardSection(judulParam = "Jenis kelamin", isiParam = confirmselectedGender)
                CardSection(judulParam = "Alamat", isiParam = confirmalamat)
                CardSection(judulParam = "noHp", isiParam = confirmnoHp)

            }

        }
    }
}

@Composable
fun CardSection (judulParam:String, isiParam:String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(5.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = isiParam, modifier = Modifier.weight(2f))

        }

    }

}