package com.maraloedev.cursofirebaselite.view.initialHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.maraloedev.cursofirebaselite.model.Artist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

/**
 * ViewModel responsable de gestionar y exponer la lista de artistas obtenida desde Firestore.
 * Utiliza corrutinas y StateFlow para exponer el estado de la lista de manera reactiva.
 */
class InitialHomeViewModel : ViewModel() {

    // Instancia de la base de datos Firestore
    private var db: FirebaseFirestore = Firebase.firestore

    // StateFlow privado para almacenar la lista de artistas
    private val _artist = MutableStateFlow<List<Artist>>(emptyList())

    // StateFlow público para exponer la lista de artistas a la UI
    val artist: StateFlow<List<Artist>> = _artist

    /**
     * Bloque de inicialización que obtiene la lista de artistas al crear el ViewModel.
     */
    init {
        // Se puede usar loadData() para pruebas, actualmente deshabilitado
        getArtist()
    }

    /*
    // Método auxiliar para cargar datos de prueba en Firestore (comentado)
    private fun loadData() {
        val random = (0..100).random()
        val artist =
            Artist(
                name = "Random $random",
                description = "descripcion random $random",
                image = "https://www.google.com/search?client=firefox-b-d&sca_esv=90c02b908651c17b&udm=2&fbs=AIIjpHx4nJjfGojPVHhEACUHPiMQht6_BFq6vBIoFFRK7qchKEWEvuc0Hbw31oEI7c8o3y4MyqtV5m4rLCGDMco7dQbsn3LCPjOfwb34Pr7sZ7pnaif_wxkbmQ1RDXUJKmgZFKA0yxjAW_dJQshoFr_Eza33GZmyYOVuvA5oknEnCdniqMIxxsRvdOoVFuW0LrZXtURuPEoR&q=perro&sa=X&ved=2ahUKEwjzzdTt6qOPAxXwcvEDHSujKX0QtKgLegQIEhAB&biw=1920&bih=967&dpr=1#vhid=N93sm6LTtpHOBM&vssid=mosaic"
            )
        db.collection("artist").add(artist)
    }
    */

    /**
     * Lanza una corrutina para obtener la lista de artistas desde Firestore y actualizar el StateFlow.
     */
    private fun getArtist() {
        viewModelScope.launch {
            val result: List<Artist> = withContext(Dispatchers.IO) {
                getAllArtists()
            }
            _artist.value = result
        }
    }

    /**
     * Recupera todos los artistas de la colección "artist" en Firestore.
     * @return Lista de objetos Artist o lista vacía si ocurre un error.
     */
    private suspend fun getAllArtists(): List<Artist> {
        return try {
            db.collection("artist").get().await().documents.mapNotNull { snapshot ->
                snapshot.toObject(Artist::class.java)
            }
        } catch (e: Exception) {
            // En caso de error, retorna una lista vacía
            emptyList()
        }
    }
}