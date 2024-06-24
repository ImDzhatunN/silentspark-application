package app.silentspark.silentspark.ui.theme.screen



//@Composable
//fun SignInScreen() {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var rememberMe by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Daftarkan Akun Anda",
//            style = MaterialTheme.typography.headlineMedium
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Nama Lengkap") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Alamat Email") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Kata Sandi") },
//            visualTransformation = PasswordVisualTransformation(),
//            modifier = Modifier.fillMaxWidth()
//        )
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Checkbox(
//                checked = rememberMe,
//                onCheckedChange = { rememberMe = it },
//                colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary)
//            )
//            Text(text = "Ingat saya")
//            Text(text = "Lupa kata sandi?")
//        }
//        Button(
//            onClick = { /* Handle login logic */ },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp)
//        ) {
//            Text("Masuk")
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(
//            onClick = { /* Handle Google sign-in logic */ },
//            modifier = Modifier.fillMaxWidth(),
//            colors = ButtonDefaults.outlinedButtonColors(
//                contentColor = MaterialTheme.colorScheme.primary
//            )
//        ) {
//            Text("Masuk dengan Google")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun PreviewSignInScreen(){
//    SignInScreen()
//}