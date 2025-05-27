package org.xerv.qiblatin.presentation.nearbyplaces

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.xerv.qiblatin.component.BackIcon
import org.xerv.qiblatin.presentation.MintGreen

@Composable
fun NearbyPlacesScreen(
    onBackClick: () -> Unit,
    onPlaceClick: (PrayerPlace) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }

    // Sample data - replace with your actual data source
    val nearbyPlaces = remember {
        listOf(
            PrayerPlace(
                id = "1",
                name = "Masjid Al-Noor",
                address = "123 Main Street, Downtown",
                distance = "0.2 km",
                type = "Mosque",
                isOpen = true,
                rating = 4.5f,
                nextPrayerTime = "Maghrib 18:30"
            ),
            PrayerPlace(
                id = "2",
                name = "Islamic Center",
                address = "456 Oak Avenue, City Center",
                distance = "0.5 km",
                type = "Islamic Center",
                isOpen = true,
                rating = 4.8f,
                nextPrayerTime = "Maghrib 18:30"
            ),
            PrayerPlace(
                id = "3",
                name = "Masjid Ar-Rahman",
                address = "789 Pine Road, Westside",
                distance = "0.8 km",
                type = "Mosque",
                isOpen = false,
                rating = 4.3f,
                nextPrayerTime = "Isha 20:15"
            ),
            PrayerPlace(
                id = "4",
                name = "Community Prayer Hall",
                address = "321 Elm Street, Northgate",
                distance = "1.2 km",
                type = "Prayer Hall",
                isOpen = true,
                rating = 4.1f,
                nextPrayerTime = "Maghrib 18:30"
            ),
            PrayerPlace(
                id = "5",
                name = "Masjid Al-Falah",
                address = "654 Maple Drive, Southend",
                distance = "1.5 km",
                type = "Mosque",
                isOpen = true,
                rating = 4.6f,
                nextPrayerTime = "Maghrib 18:30"
            )
        )
    }

    val filteredPlaces = remember(searchQuery, nearbyPlaces) {
        if (searchQuery.isEmpty()) {
            nearbyPlaces
        } else {
            nearbyPlaces.filter { place ->
                place.name.contains(searchQuery, ignoreCase = true) ||
                        place.address.contains(searchQuery, ignoreCase = true) ||
                        place.type.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.size(40.dp)
            ) {
                BackIcon()
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Nearby Places",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search places...") },
            leadingIcon = {
                Text(
                    text = "🔍",
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Text(
                            text = "✕",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Places list
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredPlaces) { place ->
                NearbyPlaceCard(
                    place = place,
                    onClick = { onPlaceClick(place) }
                )
            }

            if (filteredPlaces.isEmpty() && searchQuery.isNotEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "🔍",
                                style = MaterialTheme.typography.displayMedium,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "No places found",
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Gray
                            )
                            Text(
                                text = "Try adjusting your search terms",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NearbyPlaceCard(
    place: PrayerPlace,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = place.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = place.address,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
//                        Icon(
//                            painter = painterResource(Res.drawable.baseline_arrow_back_24),
//                            contentDescription = "Distance",
//                            modifier = Modifier.size(16.dp),
//                            tint = MintGreen
//                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = place.distance,
                            style = MaterialTheme.typography.bodySmall,
                            color = MintGreen,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
//                            Icon(
//                                painter = painterResource(Res.drawable.baseline_arrow_back_24),
//                                contentDescription = "Rating",
//                                modifier = Modifier.size(16.dp),
//                                tint = Color(0xFFFFB000)
//                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = place.rating.toString(),
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Black
                            )
                        }
                    }
                }

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    // Open/Closed status
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (place.isOpen) Color(0xFF4CAF50) else Color(0xFFF44336)
                    ) {
                        Text(
                            text = if (place.isOpen) "Open" else "Closed",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = place.type,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Divider(color = Color.Gray.copy(alpha = 0.2f))

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "🕐",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Next: ${place.nextPrayerTime}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { /* Navigate to place */ },
                        modifier = Modifier.height(32.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MintGreen),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "🧭",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                    }

                    Button(
                        onClick = { /* Call place */ },
                        modifier = Modifier.height(32.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MintGreen),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "📞",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

// Data class for prayer places
data class PrayerPlace(
    val id: String,
    val name: String,
    val address: String,
    val distance: String,
    val type: String,
    val isOpen: Boolean,
    val rating: Float,
    val nextPrayerTime: String
)