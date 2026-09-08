package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NodariaData
import com.example.ui.theme.*

@Composable
fun ContactSection(
    onSendWhatsApp: (String, String) -> Unit,
    onSendEmail: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var emailOrPhone by remember { mutableStateOf("") }
    var selectedService by remember { mutableStateOf("Auditoría Gratuita (General)") }
    var message by remember { mutableStateOf("") }
    var showSuccess by remember { mutableStateOf(false) }

    val serviceOptions = listOf(
        "Auditoría Gratuita (General)",
        "Web & Hosting Gestionado (29€/mes)",
        "Negocio Automatizado con n8n (79€/mes)",
        "IA Privada y Modelos Locales (149€/mes)",
        "Transcripción Voz Whisper (99€/mes)"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "CONTACTO DIRECTO",
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaLime,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Hablemos de tu infraestructura y automatización",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sin intermediarios comerciales. Te atenderá directamente un ingeniero de sistemas de NODARIA.",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = NodariaTextSecondary,
                lineHeight = 18.sp
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Contact form card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(NodariaSurface)
                .border(1.dp, NodariaBorder, RoundedCornerShape(18.dp))
                .padding(18.dp)
        ) {
            // Name input
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre o Empresa") },
                placeholder = { Text("Ej. María / Clínica Dental") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NodariaLime,
                    unfocusedBorderColor = NodariaBorder,
                    focusedTextColor = NodariaTextPrimary,
                    unfocusedTextColor = NodariaTextPrimary,
                    focusedLabelColor = NodariaLime,
                    unfocusedLabelColor = NodariaTextSecondary
                ),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Email or Phone input
            OutlinedTextField(
                value = emailOrPhone,
                onValueChange = { emailOrPhone = it },
                label = { Text("Email o Teléfono WhatsApp") },
                placeholder = { Text("Ej. maria@clinica.es / +34 612 345 678") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NodariaLime,
                    unfocusedBorderColor = NodariaBorder,
                    focusedTextColor = NodariaTextPrimary,
                    unfocusedTextColor = NodariaTextPrimary,
                    focusedLabelColor = NodariaLime,
                    unfocusedLabelColor = NodariaTextSecondary
                ),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Service selector
            Text(
                text = "Servicio de interés:",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = NodariaTextSecondary,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(6.dp))

            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                serviceOptions.forEach { opt ->
                    val isSelected = selectedService == opt
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isSelected) NodariaSurfaceElevated else NodariaSurfaceVariant)
                            .border(
                                1.dp,
                                if (isSelected) NodariaLime else Color.Transparent,
                                RoundedCornerShape(8.dp)
                            )
                            .clickable { selectedService = opt }
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = { selectedService = opt },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = NodariaLime,
                                unselectedColor = NodariaTextMuted
                            ),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = opt,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = if (isSelected) NodariaTextPrimary else NodariaTextSecondary,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Message input
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Comentario o detalles (opcional)") },
                placeholder = { Text("Explícanos brevemente qué buscas...") },
                minLines = 3,
                maxLines = 5,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NodariaLime,
                    unfocusedBorderColor = NodariaBorder,
                    focusedTextColor = NodariaTextPrimary,
                    unfocusedTextColor = NodariaTextPrimary,
                    focusedLabelColor = NodariaLime,
                    unfocusedLabelColor = NodariaTextSecondary
                ),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            // WhatsApp action button
            Button(
                onClick = {
                    val clientName = if (name.isNotBlank()) name else "un cliente"
                    onSendWhatsApp(clientName, selectedService)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = NodariaWhatsApp,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Contactar por WhatsApp Directo",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Email action button
            OutlinedButton(
                onClick = {
                    val clientName = if (name.isNotBlank()) name else "Interesado Web"
                    val clientEmail = if (emailOrPhone.isNotBlank()) emailOrPhone else "No especificado"
                    val clientMsg = if (message.isNotBlank()) message else "Solicitud de información sobre: $selectedService"
                    onSendEmail(clientName, clientEmail, clientMsg)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = NodariaTextPrimary
                ),
                border = ButtonDefaults.outlinedButtonBorder.copy(
                    brush = androidx.compose.ui.graphics.SolidColor(NodariaBorderActive)
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = NodariaLime,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Enviar por Correo Electrónico",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
    }
}
