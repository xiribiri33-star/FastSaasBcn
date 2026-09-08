package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

@Composable
fun NodariaBottomNav(
    onNavigate: (String) -> Unit,
    onWhatsAppClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = NodariaSurface.copy(alpha = 0.95f),
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, NodariaBorder, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavItem(
                icon = Icons.Default.Home,
                label = "Inicio",
                onClick = { onNavigate("hero") }
            )
            NavItem(
                icon = Icons.Default.Language,
                label = "Servicios",
                onClick = { onNavigate("services") }
            )
            NavItem(
                icon = Icons.Default.Payments,
                label = "Precios",
                onClick = { onNavigate("pricing") }
            )
            NavItem(
                icon = Icons.Default.Help,
                label = "FAQ",
                onClick = { onNavigate("faq") }
            )
            NavItem(
                icon = Icons.Default.Phone,
                label = "WhatsApp",
                isHighlighted = true,
                onClick = onWhatsAppClick
            )
        }
    }
}

@Composable
private fun NavItem(
    icon: ImageVector,
    label: String,
    isHighlighted: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isHighlighted) NodariaWhatsApp else NodariaTextSecondary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(
                color = if (isHighlighted) NodariaWhatsApp else NodariaTextSecondary,
                fontSize = 10.sp,
                fontWeight = if (isHighlighted) FontWeight.Bold else FontWeight.Normal
            )
        )
    }
}
