package app.silentspark.silentspark.ui.theme.screen

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.ui.theme.components.ItemPayment
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily

@Composable

fun PaymentFlow(navController : NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(42.dp)
                    .clickable { navController.popBackStack() },
                contentScale = ContentScale.FillWidth,
                painter =  painterResource(id = R.drawable.back),
                contentDescription = "",
                alignment = Alignment.Center,
            )
            Text(text = "Pembayaran",
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                color = Color.Gray
            )
        }
        Column (
            modifier = Modifier
                .padding(16.dp)
        ) {
            ItemPayment()
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewPaymentFLow() {
    PaymentFlow(navController = rememberNavController())
}