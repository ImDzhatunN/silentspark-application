package app.silentspark.silentspark.ui.theme.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun ButtonGetStarted(
    navController: NavHostController)
{
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(width = 200.dp, height = 50.dp)
            .background(Color(0xFF4A4A3F), shape = RoundedCornerShape(10.dp))
            .clickable {navController.navigate("login")}
            .clickable {
                navController.navigate("login")
            }
    ) {
        Text(
            text = "Get Started",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


