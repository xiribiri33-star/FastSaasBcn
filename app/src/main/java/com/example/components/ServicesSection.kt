package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NodariaData
import com.example.model.ServiceItem
import com.example.ui.theme.*

@Composable
fun ServicesSection(
    onSelectService: (ServiceItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "SERVICIOS DE INGENIERÍA SOBERANA",
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaLime,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Infraestructura y software diseñado para rendir y proteger tus datos",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        NodariaData.services.forEach { service ->
            ServiceCard(service = service, onSelectService = onSelectService)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun ServiceCard(
    service: ServiceItem,
    onSelectService: (ServiceItem) -> Unit
) {
    val icon = when (service.iconName) {
        "web" -> Icons.Default.Language
        "automation" -> Icons.Default.Bolt
        "ai" -> Icons.Default.Memory
        else -> Icons.Default.Mic
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(NodariaSurface)
            .border(1.dp, NodariaBorder, RoundedCornerShape(18.dp))
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(NodariaSurfaceElevated)
                    .border(1.dp, NodariaBorderActive, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = NodariaLime,
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = service.priceFrom,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = NodariaLime
                )
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = service.title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary,
                fontSize = 17.sp
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = service.subtitle,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = NodariaTextSecondary,
                lineHeight = 19.sp
            )
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Tags row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            service.tags.take(3).forEach { tag ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(NodariaSurfaceVariant)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = tag,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = NodariaTextSecondary,
                            fontSize = 10.sp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Features list
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            service.features.forEach { feature ->
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = NodariaLime,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(top = 2.dp)
                    )
                    Text(
                        text = feature,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = NodariaTextPrimary,
                            fontSize = 13.sp,
                            lineHeight = 18.sp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Button(
            onClick = { onSelectService(service) },
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = NodariaSurfaceElevated,
                contentColor = NodariaTextPrimary
            ),
            border = ButtonDefaults.outlinedButtonBorder.copy(
                brush = androidx.compose.ui.graphics.SolidColor(NodariaBorderActive)
            )
        ) {
            Text(
                text = "Solicitar Propuesta para este Servicio",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = NodariaLime
                )
            )
        }
    }
}
