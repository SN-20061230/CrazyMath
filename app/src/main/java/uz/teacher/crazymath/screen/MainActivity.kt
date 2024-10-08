package uz.teacher.crazymath.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController

import uz.teacher.crazymath.navhost.AppNavHost
import uz.teacher.crazymath.ui.theme.CrazyMathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CrazyMathTheme {
                AppNavHost(navController = rememberNavController())

            }
        }
    }
}

