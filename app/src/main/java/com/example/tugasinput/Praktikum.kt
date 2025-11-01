package com.example.tugasinput

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormPraktikum(modifier: Modifier) {

    var namaInput by remember { mutableStateOf("") }
    var alamatInput by remember { mutableStateOf("") }
    var jkInput by remember { mutableStateOf("") }
    var sPerkawinan by remember { mutableStateOf("") }


    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }
    var perkawinan by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val perkawinanList = listOf("Janda Anak Satu", "Istri Rumah Tangga", "Lajang")

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(MaterialTheme.colorScheme.primary)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Formulir Pendaftaran",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(30.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    // Nama Lengkap
                    Text(text = "Nama Lengkap", color = Color.Gray, fontSize = 12.sp)
                    OutlinedTextField(
                        value = namaInput,
                        onValueChange = { namaInput = it },
                        label = { Text("nama lengkap") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Jenis Kelamin
                    Text(text = "Jenis Kelamin", color = Color.Gray, fontSize = 12.sp)
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = (jkInput == item),
                                    onClick = { jkInput = item }
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(selected = (jkInput == item), onClick = { jkInput = item })
                            Text(text = item)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "Status Perkawinan", color = Color.Gray, fontSize = 12.sp)
                    perkawinanList.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = (sPerkawinan == item),
                                    onClick = { sPerkawinan = item }
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (sPerkawinan == item),
                                onClick = { sPerkawinan = item })
                            Text(text = item)
                        }
                    }


}