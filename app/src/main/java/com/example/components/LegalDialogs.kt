package com.example.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ui.theme.*

@Composable
fun LegalDialog(
    type: String,
    onDismiss: () -> Unit
) {
    val (title, content) = when (type) {
        "privacy" -> Pair(
            "Política de Privacidad",
            """
            En NODARIA la privacidad no es un eslogan, es el núcleo de nuestra arquitectura técnica.

            1. Responsable del Tratamiento:
            NODARIA Engineering S.L. (España)
            Email: contacto@nodaria.es

            2. Datos recopilados:
            Únicamente recopilamos los datos de contacto que nos facilitas voluntariamente a través del formulario o WhatsApp para coordinar auditorías y servicios.

            3. Alojamiento Soberano:
            Todos los datos residen en servidores dedicados ubicados físicamente en Barcelona (España). Cumplimiento riguroso del Reglamento General de Protección de Datos (RGPD UE 2016/679).

            4. IA y Cero Fugas:
            Nuestros modelos de inteligencia artificial se ejecutan localmente en servidores propios. Ni tus datos ni los de tus clientes se envían a OpenAI, Microsoft, Google u otras plataformas de terceros para entrenamiento.
            """.trimIndent()
        )
        "rgpd" -> Pair(
            "Compromiso de Soberanía RGPD",
            """
            Declaración de Soberanía Tecnológica Europea:

            • Ubicación Geográfica: Centros de Datos Tier III situados en España.
            • Ley Aplicable: Legislación española y marco normativo comunitario de la Unión Europea.
            • Propiedad del Código y Datos: Eres el único propietario de tus bases de datos MariaDB, repositorios de código y flujos n8n.
            • Sin CLOUD Act: Al no utilizar proveedores bajo jurisdicción estadounidense sin encriptación local, tus datos corporativos están protegidos contra accesos extraterritoriales.
            • Derecho de Supresión: Puedes solicitar la eliminación total de tus registros en cualquier momento.
            """.trimIndent()
        )
        else -> Pair(
            "Aviso Legal y Condiciones",
            """
            Aviso Legal:

            NODARIA ofrece servicios de consultoría informática, arquitectura en la nube, hosting gestionado de alto rendimiento y desarrollo de flujos de automatización e inteligencia artificial.

            Las tarifas especificadas en la aplicación corresponden a contratos de mantenimiento mensual sin compromiso de permanencia, previa aprobación de presupuesto y auditoría técnica inicial.
            """.trimIndent()
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
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = NodariaTextPrimary
                        )
                    )
                    IconButton(onClick = onDismiss, modifier = Modifier.size(32.dp)) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cerrar",
                            tint = NodariaTextSecondary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 300.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = content,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = NodariaTextSecondary,
                            lineHeight = 20.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NodariaLime,
                        contentColor = NodariaBg
                    )
                ) {
                    Text(
                        text = "Cerrar",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}
