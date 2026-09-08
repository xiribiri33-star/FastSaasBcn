package com.example.model

data class ChatMessage(
    val id: String,
    val sender: String, // "user" or "ai"
    val text: String,
    val timestamp: String,
    val isLocalAiBadge: Boolean = true
)

data class FaqItem(
    val id: String,
    val question: String,
    val answer: String,
    val category: String
)

data class PricingPlan(
    val id: String,
    val name: String,
    val price: String,
    val period: String,
    val setupFee: String,
    val description: String,
    val isPopular: Boolean,
    val features: List<String>,
    val whatsappMessage: String
)

data class ProblemSolutionItem(
    val id: String,
    val problemTitle: String,
    val problemDesc: String,
    val solutionTitle: String,
    val solutionDesc: String,
    val impact: String
)

data class ServiceItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val features: List<String>,
    val priceFrom: String,
    val tags: List<String>,
    val iconName: String
)

data class ServiceNodeStatus(
    val name: String,
    val location: String,
    val status: String,
    val latencyMs: Int,
    val uptimePercent: Double,
    val isHealthy: Boolean = true
)

data class WorkStep(
    val stepNumber: String,
    val title: String,
    val duration: String,
    val description: String,
    val highlight: String
)
