package app.silentspark.silentspark.navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Splash : Screen("spalsh")
    data object Kelas: Screen("kelas")
    data object DetailKelas: Screen("detail_kelas")
    data object Rating: Screen("rating")
    data object Notification: Screen("notification")
    data object Pesanan: Screen("daftar_pesanan")
    data object TandaTerima: Screen("tanda_terima")
    data object Profile: Screen("profile")
    data object Akun: Screen("akun")
    data object Login: Screen("login")
    data object SignUp: Screen("signup")
    data object ProfileGuru: Screen("profile_guru")
    data object Lengkapi: Screen("lengkapi_profile")
    data object RincianPesanan: Screen("rincian_pesanan")
    data object DetailPesanan: Screen("detail_pesanan")
    data object PaymentFlow: Screen("payment_flow")
}
