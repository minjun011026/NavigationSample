package com.unit_3.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unit_3.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable("firstscreen"){
            FirstScreen {
                name,age-> navController.navigate("secondscreen/$name/$age")
            }
        }
        composable("secondscreen/{name}/{age}"){
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getString("age")?: "0"
            SecondScreen(name, age) {
                navController.navigate("firstscreen")
            }
        }
//        composable("third_screen"){
//            ThirdScreen {
//                navController.navigate("firstscreen")
//            }
//        }
    }
}