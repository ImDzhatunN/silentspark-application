package app.silentspark.silentspark.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Composable
//fun RatingBar(rating: Int, onRatingChanged: (Int) -> Unit) {
//    Row(
//        horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        for (i in 1..5) {
//            Icon(
//                imageVector = Icons.Default.Star,
//                contentDescription = "Star",
//                tint = if (i <= rating) Color.Yellow else Color.Gray,
//                modifier = Modifier
//                    .size(32.dp)
//                    .clickable { onRatingChanged(i) }
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun RatingBarPreview() {
//    val (rating, setRating) = remember { mutableStateOf(3) }
//    RatingBar(rating = rating) { newRating ->
//        setRating(newRating)
//    }
//} eror
