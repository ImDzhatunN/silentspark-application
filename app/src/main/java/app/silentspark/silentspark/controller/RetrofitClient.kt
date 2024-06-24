package app.silentspark.silentspark.controller

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import app.silentspark.silentspark.model.CourseResponse
import app.silentspark.silentspark.model.DetailKelasResponse
import app.silentspark.silentspark.model.KelasResponse
import app.silentspark.silentspark.model.PesananResponse
import app.silentspark.silentspark.model.ProfileGuruResponse
import app.silentspark.silentspark.ui.theme.screen.SignUpBody


interface ApiInterface {
    @Headers("Content-Type:application/json")
    @POST("auth/login")
    fun signin(@Body info: SignInBody): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("auth/register")
    fun signup(
        @Body info: SignUpBody
    ): retrofit2.Call<ResponseBody>


    @Headers("Content-Type:application/json")
    @GET("kelas")
    fun getKelas(): Call<KelasResponse>

    @GET("kelas/{id}")
    fun getDetailKelas(@Path("id") id:Int): Call<DetailKelasResponse>

    @GET("courses")
    fun getCourses(): Call<CourseResponse>

    @GET("courses/{id}")
    fun getDetailGuru(@Path("id") id:Int): Call<ProfileGuruResponse>

    @GET("pesanan")
    fun getPesanan(): Call<PesananResponse>

}


class RetrofitInstance {
    companion object {

//        private val sharedPreferences = context.getSharedPreferences("appPreferences", Context.MODE_PRIVATE)

        private const val BASE_URL: String = "http://192.168.100.12:3000"
//        private val authInterceptor = { chain: okhttp3.Interceptor.Chain ->
//            val token = sharedPreferences.getString("access_token", "") ?: ""
//            val request: Request = chain.request().newBuilder()
//                .addHeader("Authorization", "Bearer $token")
//                .build()
//            chain.proceed(request)
//        }

        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
//            addInterceptor(authInterceptor)
        }.build()

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
// Example data classes for the request bodies
data class SignInBody(val email: String, val password: String)