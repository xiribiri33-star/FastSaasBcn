package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.components.*
import com.example.data.NodariaData
import com.example.model.PricingPlan
import com.example.model.ServiceItem
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.NodariaBg
import com.example.ui.theme.NodariaWhatsApp
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                NodariaApp()
            }
        }
    }
}

@Composable
fun NodariaApp() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    var showStatusDialog by remember { mutableStateOf(false) }
    var showChatbot by remember { mutableStateOf(false) }
    var activeLegalDialog by remember { mutableStateOf<String?>(null) }

    fun openWhatsApp(message: String) {
        try {
            val encodedMsg = URLEncoder.encode(message, StandardCharsets.UTF_8.toString())
            val phone = NodariaData.WHATSAPP_PHONE.replace("+", "")
            val url = "https://api.whatsapp.com/send?phone=$phone&text=$encodedMsg"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "No se pudo abrir WhatsApp", Toast.LENGTH_SHORT).show()
        }
    }

    fun openEmail(name: String, email: String, message: String) {
        try {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${NodariaData.CONTACT_EMAIL}")
                putExtra(Intent.EXTRA_SUBJECT, "Contacto NODARIA - $name")
                putExtra(Intent.EXTRA_TEXT, "Nombre: $name\nContacto: $email\n\nMensaje:\n$message")
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "No se encontró aplicación de correo", Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(NodariaBg),
        containerColor = NodariaBg,
        topBar = {
            NodariaTopBar(
                onStatusClick = { showStatusDialog = true },
                onChatbotClick = { showChatbot = true },
                onWhatsAppClick = { openWhatsApp(NodariaData.DEFAULT_WHATSAPP_MSG) }
            )
        },
        bottomBar = {
            NodariaBottomNav(
                onNavigate = { target ->
                    coroutineScope.launch {
                        when (target) {
                            "hero" -> scrollState.animateScrollTo(0)
                            "services" -> scrollState.animateScrollTo(1400)
                            "pricing" -> scrollState.animateScrollTo(3200)
                            "faq" -> scrollState.animateScrollTo(4600)
                        }
                    }
                },
                onWhatsAppClick = { openWhatsApp(NodariaData.DEFAULT_WHATSAPP_MSG) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { openWhatsApp(NodariaData.DEFAULT_WHATSAPP_MSG) },
                containerColor = NodariaWhatsApp,
                contentColor = Color.White,
                shape = androidx.compose.foundation.shape.CircleShape,
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "WhatsApp Directo"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            // Hero Section
            HeroSection(
                onWhatsAppClick = { openWhatsApp(NodariaData.DEFAULT_WHATSAPP_MSG) },
                onExploreServicesClick = {
                    coroutineScope.launch { scrollState.animateScrollTo(1400) }
                },
                onStatusClick = { showStatusDialog = true }
            )

            // Problem vs Solution
            ProblemSolutionSection()

            // Services
            ServicesSection(
                onSelectService = { srv ->
                    openWhatsApp("Hola NODARIA, estoy interesado en el servicio '${srv.title}'. ¿Podemos agendar una llamada de 30 min?")
                }
            )

            // How We Work
            HowWeWorkSection()

            // Why Us
            WhyUsSection()

            // Pricing
            PricingSection(
                onSelectPlan = { plan ->
                    openWhatsApp(plan.whatsappMessage)
                }
            )

            // FAQ
            FaqSection()

            // Contact Form
            ContactSection(
                onSendWhatsApp = { name, service ->
                    val text = "Hola NODARIA, soy $name y estoy interesado en '$service'. ¿Podemos agendar la auditoría gratuita?"
                    openWhatsApp(text)
                },
                onSendEmail = { name, email, msg ->
                    openEmail(name, email, msg)
                }
            )

            // Footer
            FooterSection(
                onLegalClick = { legalType -> activeLegalDialog = legalType },
                onStatusClick = { showStatusDialog = true }
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }

    // Status Dialog
    if (showStatusDialog) {
        StatusPageDialog(onDismiss = { showStatusDialog = false })
    }

    // Chatbot Sheet
    if (showChatbot) {
        ChatbotSheet(
            onDismiss = { showChatbot = false },
            onOpenWhatsApp = { msg ->
                showChatbot = false
                openWhatsApp(msg)
            }
        )
    }

    // Legal Dialogs
    activeLegalDialog?.let { type ->
        LegalDialog(type = type, onDismiss = { activeLegalDialog = null })
    }
}
