package org.xerv.qiblatin.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.xerv.qiblatin.presentation.LightGray
import org.xerv.qiblatin.presentation.MintGreen
import org.xerv.qiblatin.presentation.PrimaryOrange

@Composable
fun MosqueCard(
    name: String,
    distance: String,
    rating: Float,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(150.dp),
        colors = CardDefaults.cardColors(containerColor = LightGray),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = distance,
                fontSize = 14.sp,
                color = Color.Gray
            )

            // Rating stars
            Row(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                val fullStars = rating.toInt()
                val hasHalfStar = rating - fullStars >= 0.5f

                repeat(fullStars) {
                    StarIcon(
                        tint = PrimaryOrange,
                        filled = true,
                        modifier = Modifier.size(20.dp)
                    )
                }

                if (hasHalfStar) {
                    StarIcon(
                        tint = PrimaryOrange,
                        filled = false,
                        modifier = Modifier.size(20.dp)
                    )
                }

                repeat(5 - fullStars - (if (hasHalfStar) 1 else 0)) {
                    StarIcon(
                        tint = Color.Gray,
                        filled = false,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Facility icons
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FacilityIcon(
                    tint = MintGreen,
                    modifier = Modifier.size(20.dp)
                )

                FacilityIcon(
                    tint = MintGreen,
                    modifier = Modifier.size(20.dp)
                )

                FacilityIcon(
                    tint = MintGreen,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}