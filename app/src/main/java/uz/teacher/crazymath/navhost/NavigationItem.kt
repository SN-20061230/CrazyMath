package uz.teacher.crazymath.navhost

sealed class NavigationItem(val route: String) {
    object Level : NavigationItem("level")
    object Quiz : NavigationItem("quiz")
    object Record : NavigationItem("record")
}