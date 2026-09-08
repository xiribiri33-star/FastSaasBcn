package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.model.ChatMessage
import com.example.ui.theme.*

@Composable
fun ChatbotSheet(
    onDismiss: () -> Unit,
    onOpenWhatsApp: (String) -> Unit
) {
    var inputText by remember { mutableStateOf("") }
    val messages = remember {
        mutableStateListOf(
            ChatMessage(
                id = "1",
                sender = "ai",
                text = "¡Hola! Soy el asistente de IA local de NODARIA. Estoy corriendo en un servidor propio en Barcelona sin enviar tus preguntas a OpenAI. ¿En qué puedo ayudarte hoy?",
                timestamp = "Ahora"
            )
        )
    }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = NodariaSurface,
            border = ButtonDefaults.outlinedButtonBorder.copy(
                brush = androidx.compose.ui.graphics.SolidColor(NodariaBorderActive)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 520.dp)
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(NodariaSurfaceElevated)
                                .border(1.dp, NodariaBorderActive, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Memory,
                                contentDescription = null,
                                tint = NodariaLime,
                                modifier = Modifier.size(18.dp)
                            )
                        }

                        Column {
                            Text(
                                text = "Asistente NODARIA",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = NodariaTextPrimary
                                )
                            )
                            Text(
                                text = "IA Local · Llama 3 en Barcelona",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = NodariaStatusGreen,
                                    fontSize = 10.sp
                                )
                            )
                        }
                    }

                    IconButton(onClick = onDismiss, modifier = Modifier.size(32.dp)) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cerrar",
                            tint = NodariaTextSecondary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Messages list
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(messages) { msg ->
                        val isAi = msg.sender == "ai"
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = if (isAi) Arrangement.Start else Arrangement.End
                        ) {
                            Box(
                                modifier = Modifier
                                    .widthIn(max = 280.dp)
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 14.dp,
                                            topEnd = 14.dp,
                                            bottomStart = if (isAi) 2.dp else 14.dp,
                                            bottomEnd = if (isAi) 14.dp else 2.dp
                                        )
                                    )
                                    .background(if (isAi) NodariaSurfaceElevated else NodariaLime)
                                    .padding(12.dp)
                            ) {
                                Text(
                                    text = msg.text,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = if (isAi) NodariaTextPrimary else NodariaBg,
                                        fontSize = 13.sp,
                                        lineHeight = 18.sp
                                    )
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Input bar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        placeholder = { Text("Escribe una pregunta...", fontSize = 12.sp) },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = NodariaLime,
                            unfocusedBorderColor = NodariaBorder,
                            focusedTextColor = NodariaTextPrimary,
                            unfocusedTextColor = NodariaTextPrimary
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    IconButton(
                        onClick = {
                            if (inputText.isNotBlank()) {
                                val userQuery = inputText.trim()
                                messages.add(
                                    ChatMessage(
                                        id = System.currentTimeMillis().toString(),
                                        sender = "user",
                                        text = userQuery,
                                        timestamp = "Ahora"
                                    )
                                )
                                inputText = ""

                                // Local simulated smart response
                                val lower = userQuery.lowercase()
                                val responseText = when {
                                    "precio" in lower || "tarifa" in lower || "cuanto" in lower ->
                                        "Tenemos planes desde 29€/mes (Web Esencial NVMe), 79€/mes (Negocio Automatizado con n8n y WhatsApp) y 149€/mes (IA Privada Soberana). Todos sin permanencia."
                                    "rgpd" in lower || "seguridad" in lower || "servidor" in lower || "barcelona" in lower ->
                                        "Todos los servidores están alojados en centros Tier III en Barcelona, España. Cumplimos 100% con RGPD y LOPD. Cero transferencia de datos a Estados Unidos."
                                    "whatsapp" in lower || "bot" in lower ->
                                        "Conectamos bots de WhatsApp Business API mediante n8n alojado en tu servidor. Pueden responder consultas, agendar citas en Google Calendar y filtrar prospectos 24/7."
                                    else ->
                                        "¡Excelente consulta! Nuestro equipo puede analizar los detalles específicos para tu negocio en una auditoría gratuita de 30 minutos sin compromiso. ¿Quieres que te pase el enlace directo de WhatsApp?"
                                }

                                messages.add(
                                    ChatMessage(
                                        id = (System.currentTimeMillis() + 1).toString(),
                                        sender = "ai",
                                        text = responseText,
                                        timestamp = "Ahora"
                                    )
                                )
                            }
                        },
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(NodariaLime)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Enviar",
                            tint = NodariaBg,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}
