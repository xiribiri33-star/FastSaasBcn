package com.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.NodariaData
import com.example.model.ServiceNodeStatus
import com.example.ui.theme.*

@Composable
fun StatusPageDialog(
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = NodariaSurface,
            border = ButtonDefaults.outlinedButtonBorder.copy(
                brush = androidx.compose.ui.graphics.SolidColor(NodariaBorderActive)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(NodariaStatusGreen)
                        )
                        Text(
                            text = "Estado de Servidores",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = NodariaTextPrimary
                            )
                        )
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cerrar",
                            tint = NodariaTextSecondary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Overall status card
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(NodariaSurfaceElevated)
                        .border(1.dp, NodariaBorderActive, RoundedCornerShape(10.dp))
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = NodariaLime,
                        modifier = Modifier.size(22.dp)
                    )
                    Column {
                        Text(
                            text = "Sistemas 100% Operacionales",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = NodariaLime
                            )
                        )
                        Text(
                            text = "Datacenter Barcelona Tier III (España)",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = NodariaTextSecondary
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Node items list
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    NodariaData.serverNodes.forEach { node ->
                        ServerNodeItem(node = node)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NodariaSurfaceVariant,
                        contentColor = NodariaTextPrimary
                    )
                ) {
                    Text(
                        text = "Entendido",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun ServerNodeItem(node: ServiceNodeStatus) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(NodariaBg)
            .border(1.dp, NodariaBorder, RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = node.name,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = NodariaTextPrimary
                )
            )
            Text(
                text = "${node.location} · ${node.latencyMs}ms",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = NodariaTextMuted,
                    fontSize = 10.sp
                )
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(NodariaStatusGreen)
            )
            Text(
                text = "${node.uptimePercent}%",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = NodariaLime,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
