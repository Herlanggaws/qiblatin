package org.xerv.qiblatin.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.xerv.qiblatin.presentation.PrimaryOrange

@Composable
fun NearbyPrayerPlaces(onViewNearbyClick: () -> Unit) {
    Column {
        Text(
            text = "Nearby Prayer Places",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MosqueCard(
                name = "Masjid At-Taqwa",
                distance = "300m",
                rating = 4.5f,
                modifier = Modifier.weight(1f)
            )

            MosqueCard(
                name = "Masjid Al-Falah",
                distance = "500m",
                rating = 4.8f,
                modifier = Modifier.weight(1f)
            )
        }

        Button(
            onClick = onViewNearbyClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("See All", color = Color.White)
        }
    }
}