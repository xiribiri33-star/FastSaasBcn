package com.example.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.NodariaData
import com.example.ui.theme.*

@Composable
fun HeroSection(
    onWhatsAppClick: () -> Unit,
    onExploreServicesClick: () -> Unit,
    onStatusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tagline Pill
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(NodariaSurfaceVariant)
                .border(1.dp, NodariaBorderActive, RoundedCornerShape(30.dp))
                .clickable { onStatusClick() }
                .padding(horizontal = 14.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(NodariaLime)
            )
            Text(
                text = "Soberanía Digital · Servidores en España · RGPD 100%",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = NodariaTextPrimary,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Hero Title
        Text(
            text = "Automatiza tu negocio con IA que sí es tuya",
            style = MaterialTheme.typography.displayLarge.copy(
                fontWeight = FontWeight.ExtraBold,
                color = NodariaTextPrimary,
                textAlign = TextAlign.Center
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Hero Subtitle
        Text(
            text = NodariaData.HERO_SUBTITLE,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = NodariaTextSecondary,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Hero Visual Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(NodariaSurfaceElevated, NodariaSurface)
                    )
                )
                .border(1.dp, NodariaBorder, RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Datacenter location & status strip
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(NodariaBg.copy(alpha = 0.6f))
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Security,
                            contentDescription = null,
                            tint = NodariaLime,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Datacenter Barcelona Tier III",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = NodariaTextPrimary
                            )
                        )
                    }

                    Text(
                        text = "99.98% SLA",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = NodariaStatusGreen,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Stats row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    HeroStatItem(number = "< 0.8s", label = "Carga Web")
                    HeroStatItem(number = "24/7", label = "Bots n8n")
                    HeroStatItem(number = "0 Fugas", label = "IA Privada")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // CTA Buttons
        Button(
            onClick = onWhatsAppClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = NodariaLime,
                contentColor = NodariaBg
            )
        ) {
            Text(
                text = "Auditoría Gratuita 30 min",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = onExploreServicesClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = NodariaTextPrimary
            ),
            border = ButtonDefaults.outlinedButtonBorder.copy(
                brush = Brush.horizontalGradient(listOf(NodariaBorderActive, NodariaBorder))
            )
        ) {
            Text(
                text = "Explorar Servicios y Tarifas",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // 3 Key Feature Cards
        FeatureHighlightCard(
            icon = Icons.Default.Speed,
            title = "Webs Ultra-rápidas NVMe",
            subtitle = "Servidores Caddy HTTP/3 en Barcelona con Lighthouse 95+ garantizado."
        )
        Spacer(modifier = Modifier.height(10.dp))
        FeatureHighlightCard(
            icon = Icons.Default.Bolt,
            title = "Flujos n8n y Bots de WhatsApp",
            subtitle = "Captación, calificación de prospectos y reservas automáticas 24/7."
        )
        Spacer(modifier = Modifier.height(10.dp))
        FeatureHighlightCard(
            icon = Icons.Default.Memory,
            title = "Modelos IA Locales (Soberanía)",
            subtitle = "Llama 3 y DeepSeek en tus propios servidores sin enviar datos a OpenAI."
        )
    }
}

@Composable
private fun HeroStatItem(number: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = number,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaLime
            )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaTextSecondary
            )
        )
    }
}

@Composable
private fun FeatureHighlightCard(
    icon: ImageVector,
    title: String,
    subtitle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(NodariaSurfaceVariant)
            .border(1.dp, NodariaBorder, RoundedCornerShape(14.dp))
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(NodariaSurfaceElevated)
                .border(1.dp, NodariaBorderActive, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = NodariaLime,
                modifier = Modifier.size(20.dp)
            )
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = NodariaTextPrimary
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = NodariaTextSecondary,
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
            )
        }
    }
}
