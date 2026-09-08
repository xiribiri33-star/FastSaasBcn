package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.model.WorkStep
import com.example.ui.theme.*

@Composable
fun HowWeWorkSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "METODOLOGÍA TRANSPARENTE",
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaLime,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Cómo trabajamos: De la auditoría al despliegue en 4 pasos",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        NodariaData.workSteps.forEachIndexed { index, step ->
            WorkStepCard(step = step)
            if (index < NodariaData.workSteps.size - 1) {
                Box(
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .width(2.dp)
                        .height(20.dp)
                        .background(NodariaBorderActive)
                )
            }
        }
    }
}

@Composable
private fun WorkStepCard(step: WorkStep) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(NodariaSurface)
            .border(1.dp, NodariaBorder, RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Step number badge
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(NodariaSurfaceElevated)
                .border(1.dp, NodariaBorderActive, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = step.stepNumber,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = NodariaLime
                )
            )
        }

        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = step.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = NodariaTextPrimary
                    ),
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = step.duration,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = NodariaCyan,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = step.description,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = NodariaTextSecondary,
                    lineHeight = 18.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Highlight badge
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(NodariaSurfaceVariant)
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = step.highlight,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = NodariaLime,
                        fontSize = 11.sp
                    )
                )
            }
        }
    }
}
