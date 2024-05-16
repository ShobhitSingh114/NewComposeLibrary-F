package com.example.newcomposelibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.newcomposelibrary.ui.theme.NewComposeLibraryTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewComposeLibraryTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenA
                ){
                    composable<ScreenA> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(onClick = {
//                                navController.navigate(ScreenB(name = "John", age = 25))
                                navController.navigate(ScreenB(name = null, age = 25))
                                    },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Green,
                                    contentColor = Color.Black
                                )
                            ) {
                                Text(text = "To the Next Screen")
                            }
                        }
                    }
                    composable<ScreenB> {
                        // it = NavBackStackEntry object
                        val args = it.toRoute<ScreenB>()
//                        val name = it.arguments?.getString("name")
//                        val age = it.arguments?.getInt("age")
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "${args.name}, ${args.age} years old")
                        }
                    }
                    
                    
                    
                    
                    
                    
//                    composable("ScreenA"){
//                        ScreenA(navController)
//                    }
                }

            }
        }
    }
}

@Serializable
object ScreenA

@Serializable
data class ScreenB(
    // it is optional so it is nullable
    val name: String?,
    // it is mandatory/required so it is not nullable
    val age: Int
)

