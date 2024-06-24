package app.silentspark.silentspark.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.ijoabu
import app.silentspark.silentspark.ui.theme.theme.ijolumut

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.buttonhijau),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .width(38.dp)
                            .height(39.dp)
                            .clickable { navController.popBackStack()}
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Notifications",
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = ijolumut,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        ),
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Today",
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = Coklat,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    ),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                NotificationItem(
                    title = "Hello Ayu, your payment due date is approaching, pay it before",
                    time = "12:30"
                )
                Spacer(modifier = Modifier.height(8.dp))

                NotificationItem(
                    title = "Hello Ayu, your payment due date is approaching, pay it before",
                    time = "12:30"
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Yesterday",
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = Coklat,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    ),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                NotificationItem(
                    title = "Hello Ayu, your payment due date is approaching, pay it before",
                    time = "12:30"
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    )
}

@Composable
fun NotificationItem(
    title: String,
    time: String
) {
    Card(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(ijoabu.copy(alpha = 0.1f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                ImageVector.vectorResource(id = R.drawable.dompeet),
                contentDescription = "icon x",
                modifier = Modifier.padding(start = 16.dp),
                tint = Color.Unspecified
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(color = Coklat, fontFamily = FontFamily(Font(R.font.poppins_light))),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = time,
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.Gray, fontFamily = FontFamily(Font(R.font.poppins_light)))
                )
            }
            Icon(
                ImageVector.vectorResource(id = R.drawable.__icon__x),
                contentDescription = "icon x",
                modifier = Modifier.padding(end = 24.dp),
                tint = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotificationScreen() {
    NotificationScreen(navController = rememberNavController())
}
