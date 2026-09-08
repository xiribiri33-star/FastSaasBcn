package com.example.data

import com.example.model.FaqItem
import com.example.model.PricingPlan
import com.example.model.ProblemSolutionItem
import com.example.model.ServiceItem
import com.example.model.ServiceNodeStatus
import com.example.model.WorkStep

object NodariaData {
    const val BRAND_NAME = "NODARIA"
    const val TAGLINE = "Tu web, tus automatizaciones y tu IA en servidores propios en España."
    const val HERO_TITLE = "Automatiza tu negocio con IA que sí es tuya"
    const val HERO_SUBTITLE = "Infraestructura soberana en España. Despliega tu web ultra-rápida, conecta flujos de WhatsApp y ejecuta modelos de IA en tus servidores dedicados sin fugas a terceros."
    const val WHATSAPP_PHONE = "+34600123456"
    const val DEFAULT_WHATSAPP_MSG = "Hola NODARIA, he visto vuestra web y quiero solicitar una auditoría gratuita de 30 min para mi negocio."
    const val CONTACT_EMAIL = "contacto@nodaria.es"
    const val N8N_DEFAULT_WEBHOOK = "https://n8n.nodaria.es/webhook/audit-lead"

    val problemSolutions = listOf(
        ProblemSolutionItem(
            id = "prob_1",
            problemTitle = "Webs lentas y saturadas",
            problemDesc = "Hostings compartidos saturados que tardan 4 segundos en abrir tu web, perdiendo hasta el 53% de visitantes en el primer toque.",
            solutionTitle = "Web Ultra-rápida NVMe",
            solutionDesc = "Servidores dedicados con almacenamiento NVMe en Barcelona y servidor web Caddy HTTP/3. Carga inferior a 0.8s garantizada.",
            impact = "Lighthouse 95+ · Carga < 0.8s"
        ),
        ProblemSolutionItem(
            id = "prob_2",
            problemTitle = "Leads y citas perdidos",
            problemDesc = "Clientes que escriben a deshoras por WhatsApp y reciben respuesta 8 horas después, cuando ya han contratado a tu competidor.",
            solutionTitle = "Flujos n8n y Bot WhatsApp",
            solutionDesc = "Respuestas en 3 segundos, calificación de prospectos, envío de tarifas y reserva sincronizada en tu Google Calendar.",
            impact = "Respuesta 24/7 · Cero Leads Perdidos"
        ),
        ProblemSolutionItem(
            id = "prob_3",
            problemTitle = "Miedo a fugas de datos",
            problemDesc = "Utilizar ChatGPT o APIs públicas enviando secretos comerciales, facturas o datos sensibles de clientes a servidores fuera de Europa.",
            solutionTitle = "IA Privada Soberana",
            solutionDesc = "Modelos open-source punteros (Llama 3, DeepSeek) ejecutados en tu propio hardware en España. Ni un byte sale a internet.",
            impact = "100% Soberanía RGPD · Hardware Propio"
        )
    )

    val services = listOf(
        ServiceItem(
            id = "srv_web",
            title = "Web & Hosting Gestionado",
            subtitle = "Velocidad de carga milimétrica y cero preocupaciones técnicas.",
            description = "Diseño web moderno optimizado para conversión, alojado en servidores NVMe dedicados en Barcelona. Mantenimiento total, certificados SSL automáticos, copias de seguridad diarias y soporte directo.",
            features = listOf(
                "Infraestructura NVMe dedicada en Barcelona (Tier III)",
                "Puntuación Google Lighthouse superior a 95",
                "Certificado SSL Let's Encrypt con renovación automática",
                "Copias de seguridad diarias redundadas y cifradas"
            ),
            priceFrom = "desde 29€/mes",
            tags = listOf("Hosting NVMe", "Caddy HTTP/3", "RGPD 100%", "Soporte 24/7"),
            iconName = "web"
        ),
        ServiceItem(
            id = "srv_automation",
            title = "Automatización WhatsApp, Telegram y Agenda",
            subtitle = "Tu negocio conectado y atendiendo clientes las 24 horas del día.",
            description = "Flujos de trabajo personalizados con n8n alojado en tu servidor propio. Conectamos tus formularios web, WhatsApp Business API, Telegram, hojas de cálculo y CRM para eliminar tareas manuales.",
            features = listOf(
                "Bot inteligente de WhatsApp Business para captar y filtrar leads",
                "Sincronización bidireccional con Google Calendar y Calendly",
                "Disparadores automáticos de bienvenida, recordatorios y seguimiento",
                "Panel de control privado sin costes ocultos por ejecución"
            ),
            priceFrom = "desde 79€/mes",
            tags = listOf("n8n Self-Hosted", "WhatsApp API", "CRM Sync", "Ahorro 15h/sem"),
            iconName = "automation"
        ),
        ServiceItem(
            id = "srv_ai",
            title = "IA Privada y Chatbots Locales",
            subtitle = "El poder de los modelos de lenguaje más avanzados sin compartir tus datos.",
            description = "Instalamos y gestionamos modelos de lenguaje open source (Llama 3, Mistral, DeepSeek) en entornos aislados. Tu asistente lee tus manuales, contratos o bases de datos sin enviar nada a servidores ajenos.",
            features = listOf(
                "Motor Ollama / vLLM en clúster privado en España",
                "RAG avanzado conectado a tus PDFs, bases de datos y manuales",
                "Consultas ilimitadas sin pagar costes por token a terceros",
                "Conformidad total con la Directiva Europea de IA y RGPD"
            ),
            priceFrom = "desde 149€/mes",
            tags = listOf("Llama 3 / DeepSeek", "RAG Local", "Zero Fugas", "Tokens Gratis"),
            iconName = "ai"
        ),
        ServiceItem(
            id = "srv_voice",
            title = "Procesamiento de Voz y Vídeo",
            subtitle = "Convierte llamadas, reuniones y audios en acciones estructuradas.",
            description = "Modelos locales de transcripción Whisper para convertir audios de WhatsApp, llamadas con clientes o reuniones en tareas para tu equipo, minutas ejecutivas o resúmenes comerciales.",
            features = listOf(
                "Transcripción Whisper de alta precisión en español",
                "Extracción de resúmenes y compromisos de cada reunión",
                "Procesamiento de notas de voz entrantes de clientes",
                "Coste fijo mensual sin pagar por minuto de audio"
            ),
            priceFrom = "desde 99€/mes",
            tags = listOf("Whisper Local", "Voz a Texto", "Minutas IA", "Sin Límites"),
            iconName = "voice"
        )
    )

    val workSteps = listOf(
        WorkStep(
            stepNumber = "01",
            title = "Auditoría Gratuita 30 min",
            duration = "Día 1",
            description = "Nos reunimos por videollamada para mapear tus procesos manuales, analizar tu web actual y detectar los mayores puntos de fricción y oportunidades de automatización.",
            highlight = "Sin coste ni compromiso"
        ),
        WorkStep(
            stepNumber = "02",
            title = "Propuesta Técnica y Económica Cerrada",
            duration = "Día 2-3",
            description = "Te entregamos un plan de acción detallado con arquitectura, herramientas open source a utilizar, presupuesto exacto y cronograma cerrado.",
            highlight = "Precio cerrado sin sorpresas"
        ),
        WorkStep(
            stepNumber = "03",
            title = "Implantación Ágil en 7-14 días",
            duration = "7 - 14 días",
            description = "Configuramos tu servidor en España, desarrollamos los flujos en n8n, cargamos tu documentación en la IA privada y realizamos pruebas intensivas de estrés.",
            highlight = "Despliegue sin parar tu negocio"
        ),
        WorkStep(
            stepNumber = "04",
            title = "Soporte Proactivo y Mejora Continua",
            duration = "Continuo",
            description = "Monitorización 24/7 con reinicio automático de servicios, respaldos diarios y un canal directo de WhatsApp con nuestros ingenieros para dudas y optimizaciones.",
            highlight = "Monitorización activa 24/7"
        )
    )

    val whyUsPillars = listOf(
        Triple(
            "Infraestructura Propia en España",
            "Tus servidores están ubicados en datacenters certificados Tier III en Barcelona. Cumplimiento RGPD real con soberanía total sobre los datos de tu empresa y de tus clientes.",
            "Barcelona Tier III · RGPD Estricto"
        ),
        Triple(
            "Página de Estado Pública 24/7",
            "Transparencia radical. Puedes consultar la salud de los servidores, latencia de red y porcentaje de disponibilidad en tiempo real en cualquier momento.",
            "Uptime 99.98% · Transparencia Total"
        ),
        Triple(
            "Sin Permanencias ni Ataduras",
            "No creemos en contratos trampa. Si alguna vez decides marcharte, te entregamos todas las copias de seguridad, credenciales y flujos de n8n para que te los lleves donde quieras.",
            "Libertad Absoluta · Eres dueño de todo"
        ),
        Triple(
            "Stack Open Source de Ingeniería",
            "Utilizamos herramientas libres consolidadas en datacenters mundiales: Linux, Docker, n8n, Ollama, Caddy y MariaDB. Cero licencias cautivas que encarezcan tu factura con el tiempo.",
            "Linux · Docker · n8n · Ollama · Caddy"
        )
    )

    val pricingPlans = listOf(
        PricingPlan(
            id = "plan_web",
            name = "Web Esencial",
            price = "29€",
            period = "/mes",
            setupFee = "Setup inicial desde 190€ (pago único)",
            description = "Ideal para empresas que quieren una presencia web impecable, ultra-rápida y blindada con soporte técnico real.",
            isPopular = false,
            features = listOf(
                "Hosting en Servidor NVMe en Barcelona (España)",
                "Web corporativa ultrarrápida (Lighthouse 95+)",
                "Certificado SSL Let's Encrypt automático",
                "Copias de seguridad diarias cifradas",
                "Monitorización de caídas 24/7 con alertas",
                "Soporte directo por WhatsApp y correo"
            ),
            whatsappMessage = "Hola NODARIA, me gustaría contratar el plan Web Esencial (29€/mes). ¿Podemos hablar?"
        ),
        PricingPlan(
            id = "plan_automation",
            name = "Negocio Automatizado",
            price = "79€",
            period = "/mes",
            setupFee = "Setup inicial desde 390€ (pago único)",
            description = "La solución definitiva para pymes que quieren captar clientes en piloto automático y conectar WhatsApp con su CRM.",
            isPopular = true,
            features = listOf(
                "Todo lo incluido en el Plan Web Esencial",
                "Servidor n8n dedicado con flujos ilimitados",
                "Bot automatizado en WhatsApp y Telegram",
                "Sincronización de citas en Google Calendar / Calendly",
                "Captura de formularios a CRM o Google Sheets",
                "Notificaciones instantáneas de leads a tu móvil",
                "Mantenimiento y optimización continua de flujos"
            ),
            whatsappMessage = "Hola NODARIA, me interesa el plan Negocio Automatizado (79€/mes). Quiero automatizar mis leads."
        ),
        PricingPlan(
            id = "plan_ai",
            name = "IA Privada",
            price = "149€",
            period = "/mes",
            setupFee = "Setup inicial desde 690€ (pago único)",
            description = "Para empresas que manejan información confidencial y quieren asistentes IA avanzados con soberanía absoluta.",
            isPopular = false,
            features = listOf(
                "Todo lo incluido en Negocio Automatizado",
                "Servidor dedicado con motor de IA local (Llama / DeepSeek)",
                "Chatbot RAG conectado a manuales, tarifas y documentos",
                "100% de datos en España (Cero envío a OpenAI)",
                "Consultas ilimitadas sin coste por token",
                "Asistente interno para empleados o soporte a clientes",
                "SLA prioritario con respuesta en menos de 1 hora"
            ),
            whatsappMessage = "Hola NODARIA, quiero información sobre el plan de IA Privada (149€/mes) con soberanía de datos."
        )
    )

    val faqs = listOf(
        FaqItem(
            id = "faq_1",
            question = "¿Dónde están ubicados exactamente mis datos y servidores?",
            answer = "Toda la infraestructura de NODARIA está alojada físicamente en centros de datos profesionales Tier III en Barcelona, España. Cumplimos con la normativa RGPD comunitaria y la Ley Orgánica de Protección de Datos española (LOPDGDD). Tus datos nunca viajan fuera del territorio de la Unión Europea.",
            category = "Seguridad"
        ),
        FaqItem(
            id = "faq_2",
            question = "¿Qué sucede si el servidor sufre una caída o incidencia técnica?",
            answer = "Disponemos de monitorización en tiempo real 24/7 con sistemas 'heartbeat' cada 30 segundos. En caso de corte, los contenedores se reinician de manera autónoma en milisegundos y nuestro equipo de ingenieros de guardia recibe una alerta prioritaria en el móvil. Además, disponemos de copias de seguridad automáticas diarias.",
            category = "Infraestructura"
        ),
        FaqItem(
            id = "faq_3",
            question = "¿Necesito conocimientos técnicos o informáticos para usarlo?",
            answer = "Ninguno en absoluto. En NODARIA actuamos como tu departamento de ingeniería y hosting gestionado. Nosotros nos encargamos de los servidores, certificados, integraciones de API, flujos de n8n y modelos de IA. Tú simplemente interactúas con tu WhatsApp, recibes los leads calificados y atiendes a tus clientes.",
            category = "Uso"
        ),
        FaqItem(
            id = "faq_4",
            question = "¿Puedo migrar mi web actual o conservar mi dominio?",
            answer = "Por supuesto. Nos encargamos de todo el proceso de migración de tu dominio, correos electrónicos y contenidos actuales a nuestra infraestructura de alta velocidad sin corte de servicio ni interrupciones para tus clientes actuales.",
            category = "Migración"
        ),
        FaqItem(
            id = "faq_5",
            question = "¿Qué es exactamente la 'IA privada' y en qué se diferencia de ChatGPT?",
            answer = "ChatGPT o Claude son servicios en la nube estadounidense donde cada mensaje viaja a sus servidores y puede ser utilizado para re-entrenar sus modelos. La IA Privada de NODARIA se ejecuta en un servidor que solo te pertenece a ti: los pesos del modelo (Llama 3, DeepSeek) corren de forma local, leen tus documentos confidenciales y responden sin que un solo byte salga a internet.",
            category = "IA Privada"
        ),
        FaqItem(
            id = "faq_6",
            question = "¿Existe algún tipo de permanencia o penalización por cancelar?",
            answer = "Cero permanencias. Creemos en retener a nuestros clientes por la excelencia de nuestros resultados y la velocidad de nuestro servicio. Si deseas cancelar en cualquier momento, te exportamos todos tus datos, bases de datos MariaDB y flujos de n8n para que continúes sin trabas.",
            category = "Contratos"
        )
    )

    val serverNodes = listOf(
        ServiceNodeStatus(
            name = "Servidor Web NVMe Caddy",
            location = "Datacenter Barcelona (ES)",
            status = "Operacional",
            latencyMs = 12,
            uptimePercent = 99.99,
            isHealthy = true
        ),
        ServiceNodeStatus(
            name = "Motor Automatizaciones n8n",
            location = "Datacenter Barcelona (ES)",
            status = "Operacional",
            latencyMs = 14,
            uptimePercent = 99.98,
            isHealthy = true
        ),
        ServiceNodeStatus(
            name = "Clúster IA Privada (Ollama)",
            location = "Datacenter Barcelona (ES)",
            status = "Operacional",
            latencyMs = 24,
            uptimePercent = 99.95,
            isHealthy = true
        ),
        ServiceNodeStatus(
            name = "Base de Datos MariaDB Cifrada",
            location = "Datacenter Barcelona (ES)",
            status = "Operacional",
            latencyMs = 8,
            uptimePercent = 100.0,
            isHealthy = true
        ),
        ServiceNodeStatus(
            name = "Pasarela WhatsApp Business API",
            location = "Nube Directa Meta/Cloud",
            status = "Operacional",
            latencyMs = 32,
            uptimePercent = 99.94,
            isHealthy = true
        )
    )
}
