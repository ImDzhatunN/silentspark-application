package app.silentspark.silentspark.ui.theme.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import app.silentspark.silentspark.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import app.silentspark.silentspark.dummy.DataKelas
import app.silentspark.silentspark.model.Kelas
import app.silentspark.silentspark.ui.theme.components.ItemRowKelas
import app.silentspark.silentspark.ui.theme.theme.Green
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import app.silentspark.silentspark.controller.ApiInterface
import app.silentspark.silentspark.controller.RetrofitInstance
import app.silentspark.silentspark.model.KelasResponse
import app.silentspark.silentspark.model.ResponseFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun fetchKelas(context: Context, callback: (List<Kelas>) -> Unit) {
    val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
    retIn.getKelas().enqueue(object : Callback<KelasResponse> {
        override fun onResponse(call: Call<KelasResponse>, response: Response<KelasResponse>) {
            if (response.isSuccessful) {
                val kelasResponse = response.body()
                if (kelasResponse != null && kelasResponse.success == "OK") {
                    val kelasList = kelasResponse.data
                    callback(kelasList)
                } else {
                    // Handle the case where success is not OK
                }
            } else {
                // Handle the error
            }
        }

        override fun onFailure(call: Call<KelasResponse>, t: Throwable) {
            // Handle the failure
        }
    })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KelasScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    val context = LocalContext.current
    var listkelas by remember { mutableStateOf<List<Kelas>>(emptyList()) }

    LaunchedEffect(key1 = true) {
        fetchKelas(context) { fetchedKelasList ->
            listkelas = fetchedKelasList
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back_topbar),
                            contentDescription = "Icon",
                            modifier = modifier
                                .width(38.dp)
                                .height(39.dp)
                                .clickable { onBackClick() }
                        )
                        Spacer(modifier = modifier.weight(1f))
                        // Example handling of potentially null title
                        val title = "Kelas"
                        Text(
                            text = title,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = Green
                            ),
                            modifier = modifier.padding(end = 16.dp)
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = modifier.padding(8.dp)
                ) {
                    items(listkelas, key = { it.id }) { kelas ->
                        ItemRowKelas(
                            kelas = kelas,
                            statusColour = if (kelas.status == "Sedang Berlangsung") Color(0xFFBBA661).copy(alpha = 0.25f) else Color(0xFF67725F).copy(alpha = 0.25f),
                            textColor = if (kelas.status == "Sedang Berlangsung") Color(0xFFAC9062) else Color(0xFF67725F),
                            modifier = Modifier.clickable {
                                navController.navigate("detail_kelas_screen/${kelas.id}")
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    )
}

