package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NodariaData
import com.example.ui.theme.*

@Composable
fun FooterSection(
    onLegalClick: (String) -> Unit,
    onStatusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(NodariaSurface)
            .padding(horizontal = 16.dp, vertical = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = NodariaData.BRAND_NAME,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary,
                letterSpacing = 1.sp
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = NodariaData.TAGLINE,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = NodariaTextSecondary,
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Quick status row
        Row(
            modifier = Modifier
                .clickable { onStatusClick() }
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(NodariaStatusGreen)
            )
            Text(
                text = "Página de Estado y Nodos en Vivo",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = NodariaLime,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Legal links
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Aviso Legal",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = NodariaTextMuted
                ),
                modifier = Modifier.clickable { onLegalClick("legal") }
            )
            Text(
                text = "Privacidad",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = NodariaTextMuted
                ),
                modifier = Modifier.clickable { onLegalClick("privacy") }
            )
            Text(
                text = "RGPD Soberano",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = NodariaTextMuted
                ),
                modifier = Modifier.clickable { onLegalClick("rgpd") }
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "© 2026 NODARIA. Infraestructura Soberana en Datacenters de Barcelona, España.",
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaTextMuted,
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            ),
            textAlign = TextAlign.Center
        )
    }
}
