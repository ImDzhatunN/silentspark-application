package app.silentspark.silentspark.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.ui.theme.components.ButtonKirim
import app.silentspark.silentspark.ui.theme.components.RatingBar
import app.silentspark.silentspark.ui.theme.theme.ijolumut

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingAndReviewScreen(navController: NavHostController) {
    var rating by remember { mutableStateOf(4) }
    var reviewText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
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
                            text = "Ulasan",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = ijolumut,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            ),
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp)
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(9.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(336.dp)
                        .height(416.dp)
                        .background(
                            color = Color(0x2667725F),
                            shape = RoundedCornerShape(size = 25.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Penilaian Anda dalam pengalaman belajar ini?",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = ijolumut,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            ),
                            textAlign = TextAlign.Center,
                            color = Color(0xFF5B555C),
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        RatingBar(
                            rating = rating,
                            onRatingChanged = { newRating ->
                                rating = newRating
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Bagikan penilaian Anda dan bantu\npengguna lain membuat\npilihan yang lebih baik!",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = ijolumut,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold))
                            ),
                            fontWeight = FontWeight(400),
                            textAlign = TextAlign.Center,
                            color = Color(0xFF5B555C),
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = reviewText,
                            onValueChange = { reviewText = it },
                            textStyle = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 24.sp,
                                color = Color(0xFFFEFFFF),
                                fontFamily = FontFamily(Font(R.font.poppins_semibold))
                            ),
                            label = { Text(text = "") },
                            modifier = Modifier
                                .height(150.dp)
                                .width(287.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            ButtonKirim(text = "Kirim", onClick = {
                            })
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RatingAndReviewScreenPreview() {
    RatingAndReviewScreen(navController= rememberNavController())
}
