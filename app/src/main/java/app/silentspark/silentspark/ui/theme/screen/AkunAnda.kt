package app.silentspark.silentspark.ui.theme.screen


//
//@Composable
//fun AccountScreen(
//    modifier: Modifier = Modifier,
//    onBackClick: () -> Unit = {}
//) {
//    Column(
//        Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(onClick = onBackClick) {
//                Icon(
//                    painter = painterResource(id = R.drawable.back),
//                    contentDescription = "Back"
//                )
//            }
//
//            Text(
//                text = "Akun",
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold
//            )
//
//            Spacer(modifier = Modifier.width(48.dp)) // Placeholder for additional action or empty space
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Box(
//            modifier = Modifier
//                .size(120.dp)
//                .align(Alignment.CenterHorizontally)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.rectangle_11siswaprofile),
//                contentDescription = "Profile Picture",
//                modifier = Modifier.fillMaxSize()
//            )
//
//            IconButton(
//                onClick = { /* Handle change profile picture click */ },
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .size(32.dp)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.kamera),
//                    contentDescription = "Change Profile Picture"
//                )
//            }
//        }
//
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun PreviewAccountScreen() {
//    AccountScreen()
//}