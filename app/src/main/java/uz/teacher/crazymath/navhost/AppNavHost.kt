package uz.teacher.crazymath.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import uz.teacher.crazymath.model.Records
import uz.teacher.crazymath.screen.LevelScreen
import uz.teacher.crazymath.screen.QuizScreen
import uz.teacher.crazymath.screen.RecordScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Level.route) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("quiz/{level}") { navBackStackEntry ->

            val level = navBackStackEntry.arguments?.getString("level")
            level?.let {
                QuizScreen(navController, level)
            }
        }
        composable(NavigationItem.Level.route) {
            LevelScreen(navController)
        }
//        composable("record/{score}") { navBackStackEntry ->
//            val score = navBackStackEntry.arguments?.getString("score")
//            score?.let {
//                RecordScreen(navController, score)
//            }
//        }
        composable<Records> { navBackStackEntry ->
            val records: Records = navBackStackEntry.toRoute()
            RecordScreen(navController, records)
        }
    }
}