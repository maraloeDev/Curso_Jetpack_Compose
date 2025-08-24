package com.maraloedev.cursofirebaselite.view.initialHome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.maraloedev.cursofirebaselite.model.Artist

/**
 * Muestra la pantalla inicial con una lista horizontal de artistas populares.
 * Observa el estado del ViewModel para obtener la lista de artistas.
 *
 * @param initialHomeViewModel ViewModel que expone el estado de los artistas.
 */
@Composable
fun InitialHomeScreen(initialHomeViewModel: InitialHomeViewModel = viewModel()) {

    // Observa el estado actual de la lista de artistas desde el ViewModel.
    val state = initialHomeViewModel.artist.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111111)) // Fondo oscuro para la pantalla
    ) {

        // Título principal de la sección
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Artistas Populares",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        // Lista horizontal que muestra cada artista usando ArtistItem
        LazyRow {
            items(items = state.value) { artist ->
                ArtistItem(artist = artist)
            }
        }
    }
}

/**
 * Componente que representa visualmente a un artista.
 * Muestra la imagen y el nombre del artista en formato vertical.
 *
 * @param artist Instancia de Artist con los datos a mostrar.
 */
@Composable
fun ArtistItem(artist: Artist) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Imagen circular del artista
        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            model = artist.image,
            contentDescription = "Imagen del artista",
        )
        Spacer(modifier = Modifier.height(4.dp))
        // Nombre del artista debajo de la imagen
        Text(text = artist.name.orEmpty(), color = Color.White)
    }
}