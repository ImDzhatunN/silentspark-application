package app.silentspark.silentspark.ui.theme.components

import app.silentspark.silentspark.R
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.putih


@Composable
fun ButtonNext(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .width(270.dp)
            .height(36.dp),
        shape = RoundedCornerShape(size = 5.dp),
        colors = ButtonDefaults.buttonColors(Coklat),

        ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 28.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = putih,
                textAlign = TextAlign.Right,),
            modifier = Modifier.align(Alignment.CenterVertically)
        )


    }
}

@Composable
@Preview(showBackground = false)
fun PreviewButtonNext() {
    ButtonNext(
        text = "Selanjutnya",
        onClick = {}
    )
}
