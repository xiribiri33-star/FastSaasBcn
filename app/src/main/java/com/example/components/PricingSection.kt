package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NodariaData
import com.example.model.PricingPlan
import com.example.ui.theme.*

@Composable
fun PricingSection(
    onSelectPlan: (PricingPlan) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "TARIFAS TRANSPARENTES",
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaLime,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Precios claros y cerrados. Sin costes ocultos ni permanencias.",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        NodariaData.pricingPlans.forEach { plan ->
            PricingPlanCard(plan = plan, onSelectPlan = onSelectPlan)
            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}

@Composable
private fun PricingPlanCard(
    plan: PricingPlan,
    onSelectPlan: (PricingPlan) -> Unit
) {
    val borderColor = if (plan.isPopular) NodariaLime else NodariaBorder
    val borderWidth = if (plan.isPopular) 2.dp else 1.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(if (plan.isPopular) NodariaSurfaceElevated else NodariaSurface)
            .border(borderWidth, borderColor, RoundedCornerShape(20.dp))
            .padding(20.dp)
    ) {
        if (plan.isPopular) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(NodariaLime)
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = NodariaBg,
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = "MÁS POPULAR",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = NodariaBg,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        Text(
            text = plan.name,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = plan.price,
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    color = if (plan.isPopular) NodariaLime else NodariaTextPrimary
                )
            )
            Text(
                text = plan.period,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = NodariaTextSecondary
                ),
                modifier = Modifier.padding(bottom = 4.dp, start = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = plan.setupFee,
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaCyan,
                fontWeight = FontWeight.Medium
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = plan.description,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = NodariaTextSecondary,
                lineHeight = 18.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Features
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            plan.features.forEach { feature ->
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

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { onSelectPlan(plan) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (plan.isPopular) NodariaLime else NodariaSurfaceVariant,
                contentColor = if (plan.isPopular) NodariaBg else NodariaLime
            ),
            border = if (!plan.isPopular) ButtonDefaults.outlinedButtonBorder.copy(
                brush = androidx.compose.ui.graphics.SolidColor(NodariaBorderActive)
            ) else null
        ) {
            Text(
                text = "Elegir ${plan.name}",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
