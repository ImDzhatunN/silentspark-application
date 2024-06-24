package app.silentspark.silentspark.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily


@Composable
fun BankList(
    modifier: Modifier = Modifier,
) {
    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(modifier.padding(start = 24.dp, top = 16.dp, bottom = 16.dp, end = 24.dp)){
            Text(
                text = "Mandiri",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "BNI",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "BSI",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "BTN",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "Danamon",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "Bukopen",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBankList() {
    BankList()
}