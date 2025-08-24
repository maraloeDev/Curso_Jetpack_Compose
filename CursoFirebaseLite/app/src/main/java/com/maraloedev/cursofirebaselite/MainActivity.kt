package com.maraloedev.cursofirebaselite

        import android.os.Bundle
        import androidx.activity.ComponentActivity
        import androidx.activity.compose.setContent
        import androidx.activity.enableEdgeToEdge
        import com.google.firebase.Firebase
        import com.google.firebase.auth.FirebaseAuth
        import com.google.firebase.auth.auth
        import com.google.firebase.firestore.FirebaseFirestore
        import com.google.firebase.firestore.firestore
        import com.maraloedev.cursofirebaselite.view.core.navigation.NavigationWrapper

        /**
         * Actividad principal de la aplicación.
         * Inicializa la autenticación de Firebase y define la navegación principal.
         */
        class MainActivity : ComponentActivity() {

            // Instancia de autenticación de Firebase
            private lateinit var auth: FirebaseAuth

            /**
             * Método llamado al crear la actividad.
             * Inicializa FirebaseAuth, habilita edge-to-edge y establece el contenido principal.
             */
            override fun onCreate(savedInstanceState: Bundle?) {
                auth = Firebase.auth

                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContent {
                    // NavigationWrapper gestiona la navegación de la app, recibiendo la instancia de auth
                    NavigationWrapper(auth = auth)
                }
            }

            /**
             * Método llamado cuando la actividad pasa a primer plano.
             * Verifica si el usuario está autenticado y decide la pantalla de inicio.
             */
            override fun onStart() {
                super.onStart()
                val currentUser = auth.currentUser

                if (currentUser != null) {
                    // Si el usuario está logueado, navega a la pantalla de login
                } else {
                    // Si no hay usuario logueado, navega a la pantalla Home
                }
            }
        }