package app.silentspark.silentspark.ui.theme.screen

import android.content.Context
import android.util.Log
import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.controller.ApiInterface
import app.silentspark.silentspark.controller.RetrofitInstance
import app.silentspark.silentspark.dummy.DataDummy
import app.silentspark.silentspark.model.Course
import app.silentspark.silentspark.model.CourseResponse
import app.silentspark.silentspark.model.Kelas
import app.silentspark.silentspark.navigation.Screen
import app.silentspark.silentspark.state.UiState
import app.silentspark.silentspark.ui.theme.components.BannerMain
import app.silentspark.silentspark.ui.theme.components.ItemBeranda
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun fetchBeranda(context: Context, callback: (List<Course>) -> Unit) {
    val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
    retIn.getCourses().enqueue(object : Callback<CourseResponse> {
        override fun onResponse(call: Call<CourseResponse>, response: Response<CourseResponse>) {
            if (response.isSuccessful) {
                val courseResponse = response.body()
                if (courseResponse != null && courseResponse.success == "OK") {
                    val courseList = courseResponse.data
                    Log.d("CourseViewModel", "Kelas list: $courseList")
                    callback(courseList)
                } else {
                    Log.e("CourseViewModel", "Response was not successful or success was not OK")
                    // Handle the case where success is not OK
                }
            } else {
                Log.e("CourseViewModel", "Response error: ${response.errorBody()?.string()}")
                // Handle the error
            }
        }

        override fun onFailure(call: Call<CourseResponse>, t: Throwable) {
            Log.e("CourseViewModel", "Request failed", t)
            // Handle the failure
        }
    })
}

@Composable
fun BerandaSiswaScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = koinViewModel()
){

    val state by viewModel.uiState.collectAsState()

    when(val uiState = state){
        is UiState.Loading -> {

        }

        is UiState.Error -> {

        }
        is UiState.Success -> {
            BerandaSiswaContent(navController = navController, nama = "Ayu Fernanda", listCourse = uiState.data)

        }
    }

}

@Composable
fun BerandaSiswaContent(
    navController: NavHostController,
    nama : String,
    listCourse : List<Course> = emptyList(),

    ) {

    var listCourse by remember { mutableStateOf<List<Course>>(emptyList()) }

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        fetchBeranda(context) { fetchedCourseList ->
            listCourse = fetchedCourseList
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {

        Row(
            modifier = Modifier.padding(top = 8.dp, start = 8.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(38.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.img_dummy),
                contentDescription = "",
                alignment = Alignment.Center,
            )
            Column( modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = nama,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 14.sp,
                    color = Coklat)

                Text(
                    text = "Siswa",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 14.sp,
                    color = Coklat)

            }
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.ic_notif),
                contentDescription = "notification",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.navigate("notification")
                    }
            )
        }

        Row(modifier = Modifier.padding(top = 16.dp)) {
            Text(
                text = stringResource(id = R.string.say_hi, nama),
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 14.sp,
                color = Coklat
            )
            Image(painter = painterResource(id = R.drawable.ic_say_hi), contentDescription = "Icon say hi", modifier = Modifier.padding(start = 8.dp))
        }

        BannerMain(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 8.dp))

        Text(text = stringResource(id = R.string.text_nav_main),
            color = Coklat ,
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally))

        LazyColumn {
            items(listCourse) { course ->
                Log.d("GURUID BERANDA", "${course.id}")
                ItemBeranda(
//                    image = course.image,
                    title = course.title,
                    desc = course.description,
                    price = course.price,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .clickable { navController.navigate("detail_profile_guru/${course.id}")})
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBerandaSiswa(navController: NavHostController = rememberNavController()) {

    BerandaSiswaContent(navController = navController,"Aldy",
        listCourse = DataDummy.listCouse

//        listCourse = listCourse
    )
}