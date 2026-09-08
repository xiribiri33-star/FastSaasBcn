package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

@Composable
fun NodariaTopBar(
    onStatusClick: () -> Unit,
    onChatbotClick: () -> Unit,
    onWhatsAppClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = NodariaBg.copy(alpha = 0.95f),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Brand logo & title
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(NodariaLime)
                            .border(1.dp, NodariaLimeGlow, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bolt,
                            contentDescription = "NODARIA Logo",
                            tint = NodariaBg,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Column {
                        Text(
                            text = "NODARIA",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp,
                                color = NodariaTextPrimary
                            )
                        )
                        Text(
                            text = "Soberanía Digital · ES",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = NodariaLime,
                                fontSize = 10.sp
                            )
                        )
                    }
                }

                // Action chips
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Status badge
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(NodariaSurfaceVariant)
                            .border(1.dp, NodariaBorderActive, RoundedCornerShape(20.dp))
                            .clickable { onStatusClick() }
                            .padding(horizontal = 10.dp, vertical = 6.dp),
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
                            text = "Tier III Barcelona",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = NodariaTextPrimary,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }

                    // Chatbot icon button
                    IconButton(
                        onClick = onChatbotClick,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(NodariaSurfaceElevated)
                            .border(1.dp, NodariaBorder, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ChatBubble,
                            contentDescription = "Asistente IA Local",
                            tint = NodariaLime,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}
