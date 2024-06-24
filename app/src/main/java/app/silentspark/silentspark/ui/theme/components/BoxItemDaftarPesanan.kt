package app.silentspark.silentspark.ui.theme.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import app.silentspark.silentspark.R
import app.silentspark.silentspark.model.Pesanan
import app.silentspark.silentspark.ui.theme.theme.AbuabuMuda
import app.silentspark.silentspark.ui.theme.theme.Abuabu
import app.silentspark.silentspark.ui.theme.theme.putih
@Composable
fun BoxItemDaftarPesanan(
    pesanan: Pesanan,
    statusColour: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .width(400.dp)
            .height(95.dp)
            .border(width = 0.1.dp, color = AbuabuMuda)
            .background(color = putih)
    ) {
        Row {
            Image(
                alignment = Alignment.TopCenter,
                painter = painterResource(id = R.drawable.ic_money),
                contentDescription = "",
                modifier = modifier
                    .padding(top = 24.dp, start = 18.dp, end = 15.dp)
                    .size(38.dp)
            )

            Column(modifier = modifier.padding(top = 14.dp, end = 92.dp)) {
                Text(
                    text = pesanan.date,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Abuabu,
                    fontSize = 13.sp,
                    letterSpacing = 0.2.sp
                )
                Text(
                    text = pesanan.month,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Abuabu,
                    fontSize = 13.sp,
                    letterSpacing = 0.2.sp
                )
                Text(
                    text = pesanan.metodepembayaran,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Abuabu,
                    fontSize = 13.sp,
                    letterSpacing = 0.2.sp
                )
            }
            Spacer(modifier = modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = { /* Handle sign up click */ },
                    colors = ButtonDefaults.buttonColors(statusColour),
                    shape = RoundedCornerShape(size = 10.dp),
                    modifier = Modifier
                        .width(132.dp)
                        .height(30.dp)
                ) {
                    Text(
                        text = pesanan.status,
                        color = textColor,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                }
            }
        }
    }
}
