package app.silentspark.silentspark.ui.theme.screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.controller.ApiInterface
import app.silentspark.silentspark.controller.RetrofitInstance
import app.silentspark.silentspark.dummy.DataDummy
import app.silentspark.silentspark.model.ProfileGuru
import app.silentspark.silentspark.model.ProfileGuruResponse
import app.silentspark.silentspark.ui.theme.components.BoxProfileGuru
import app.silentspark.silentspark.ui.theme.theme.Green
import app.silentspark.silentspark.ui.theme.theme.putih
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun fetchDetailGuru(id:Int, context: Context, callback: (ProfileGuru) -> Unit) {
    val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
    retIn.getDetailGuru(id).enqueue(object : Callback<ProfileGuruResponse> {
        override fun onResponse(call: Call<ProfileGuruResponse>, response: Response<ProfileGuruResponse>) {
            if (response.isSuccessful) {
                val kelasResponse = response.body()
                if (kelasResponse != null && kelasResponse.success == "OK") {
                    val kelasList = kelasResponse.data
                    Log.d("DetailGuruViewModel", "guru list: $kelasList")
                    callback(kelasList)
                } else {
                    Log.e("DetailGuruViewModel", "Response was not successful or success was not OK")
                    // Handle the case where success is not OK
                }
            } else {
                Log.e("DetailGuruViewModel", "Response error: ${response.errorBody()?.string()}")
                // Handle the error
            }
        }

        override fun onFailure(call: Call<ProfileGuruResponse>, t: Throwable) {
            Log.e("DetailGuruViewModel", "Request failed", t)
            // Handle the failure
        }
    })
}

@Composable
fun ProfileGuruScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    teacherrating: Int = 5,
    onBackClick: () -> Unit = {},
    guruId: Int = 0
) {

    var guru by remember { mutableStateOf<ProfileGuru?>(null) }

    val context = LocalContext.current
    Log.d("GURUID", "${guruId}")
    LaunchedEffect(key1 = guruId) {
        fetchDetailGuru(guruId, context) { fetchedGuruList ->
            guru = fetchedGuruList
            Log.d("GURUDETAILDATA", "${guru}")
        }
    }

    var rating by rememberSaveable { mutableIntStateOf(teacherrating) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Green)
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = modifier
                .padding(top = 15.dp, start = 15.dp)
        ) {
            Image(
                modifier = modifier
                    .width(38.dp)
                    .height(39.dp)
                    .clickable { navController.popBackStack() },
                painter = painterResource(id = R.drawable.ic_topbar),
                contentDescription = "navigation kembali",
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "Profile Guru",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = putih
                ),
                modifier = modifier.padding(end = 16.dp)
            )
        }
        Spacer(modifier = modifier.height(32.dp))
        Row {
            Image(
                painter = painterResource(R.drawable.teacher),
                contentDescription = "",
                modifier = modifier
                    .size(width = 150.dp, height = 100.dp)
                    .padding(start = 35.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)) {
                Text(
                    text = guru?.name ?: "Tidak ada Nama",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = putih,
                    fontSize = 16.sp,
                )
                TeacherRatingBar(rating = rating) { newRating ->
                    rating = newRating
                }
                Text(
                    buildAnnotatedString {
                        append("4.9/")
                        withStyle(style = SpanStyle(fontSize = 14.sp)) {
                            append("5")
                        }
                    },
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = putih,
                    fontSize = 14.sp,
                    letterSpacing = 1.sp
                )
            }

        }
        Spacer(modifier = modifier.height(32.dp))

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            BoxProfileGuru(
                navController = navController,
                price = "3 bulan",
                namareview = "Angga",
                textreview = "\"Beli kelas selama tiga bulan, pembelajarannya menarik dan mudah dimengerti. Alhamdulillah dua bulan juga udah mulai paham dan bisa mempraktekan.",
                initialRating = 4,
                buttonText = "Rp680.000",
                onButtonClick = { /*TODO*/ },
                profileGuru = guru
            )
        }

    }

}

@Composable
fun TeacherRatingBar(rating: Int, onRatingChanged: (Int) -> Unit) {
    Row {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= rating) Icons.Filled.Star else Icons.Filled.StarBorder,
                contentDescription = null,
                tint = Color(0xFFFFD700),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp)
                    .clickable { onRatingChanged(i) }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProfileGuruScreenPreview() {
    ProfileGuruScreen(
        navController = rememberNavController(),
        teacherrating = 5
    )
}
