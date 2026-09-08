package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NodariaData
import com.example.model.ProblemSolutionItem
import com.example.ui.theme.*

@Composable
fun ProblemSolutionSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "EL PROBLEMA VS LA SOLUCIÓN SOBERANA",
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaLime,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "¿Por qué las soluciones tradicionales están frenando tu negocio?",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        NodariaData.problemSolutions.forEach { item ->
            ProblemSolutionCard(item = item)
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}

@Composable
private fun ProblemSolutionCard(item: ProblemSolutionItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(NodariaSurface)
            .border(1.dp, NodariaBorder, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        // Problem row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF3B1818)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color(0xFFFF5E5E),
                    modifier = Modifier.size(16.dp)
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.problemTitle,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF8E8E)
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = item.problemDesc,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = NodariaTextSecondary,
                        lineHeight = 18.sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(NodariaBorder)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Solution row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF1B381A)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = NodariaLime,
                    modifier = Modifier.size(16.dp)
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.solutionTitle,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = NodariaLime
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = item.solutionDesc,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = NodariaTextPrimary,
                        lineHeight = 18.sp
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Impact pill
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(NodariaSurfaceElevated)
                        .border(1.dp, NodariaBorderActive, RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.impact,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = NodariaLime,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    }
}
