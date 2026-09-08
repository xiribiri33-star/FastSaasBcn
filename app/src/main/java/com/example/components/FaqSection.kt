package com.example.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NodariaData
import com.example.model.FaqItem
import com.example.ui.theme.*

@Composable
fun FaqSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "PREGUNTAS FRECUENTES",
            style = MaterialTheme.typography.labelSmall.copy(
                color = NodariaLime,
                letterSpacing = 1.5.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Resolvemos todas tus dudas técnicas y legales",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = NodariaTextPrimary
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        NodariaData.faqs.forEach { faq ->
            FaqAccordionItem(faq = faq)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
private fun FaqAccordionItem(faq: FaqItem) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(NodariaSurface)
            .border(
                1.dp,
                if (isExpanded) NodariaBorderActive else NodariaBorder,
                RoundedCornerShape(14.dp)
            )
            .clickable { isExpanded = !isExpanded }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = faq.category.uppercase(),
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = NodariaLime,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = faq.question,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = NodariaTextPrimary,
                        fontSize = 15.sp
                    )
                )
            }

            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = if (isExpanded) "Contraer" else "Expandir",
                tint = NodariaLime,
                modifier = Modifier.size(24.dp)
            )
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Column {
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(NodariaBorder)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = faq.answer,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = NodariaTextSecondary,
                        lineHeight = 20.sp
                    )
                )
            }
        }
    }
}
