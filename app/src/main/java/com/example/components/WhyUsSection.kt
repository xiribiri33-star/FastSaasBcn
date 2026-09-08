package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NodariaData
import com.example.ui.theme.*

@Composable
fun WhyUsSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "¿POR QUÉ NODARIA?",
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaLime,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "4 Pilares de confianza y soberanía técnica",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        NodariaData.whyUsPillars.forEach { (title, desc, highlight) ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(NodariaSurface)
                    .border(1.dp, NodariaBorder, RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = NodariaLime,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = NodariaTextPrimary
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = desc,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = NodariaTextSecondary,
                        lineHeight = 19.sp
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(NodariaSurfaceElevated)
                        .border(1.dp, NodariaBorderActive, RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = highlight,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = NodariaCyan,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}
