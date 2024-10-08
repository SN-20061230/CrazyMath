package uz.teacher.crazymath.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.teacher.crazymath.R


@Composable
fun LevelScreen(navController: NavHostController) {

    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.level_bg),
        contentDescription = null,
        alpha = 0.6F
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {

        Button(
            onClick = {

                navController.navigate("quiz/1")
            },
            modifier = Modifier.border(
                width = 3.dp,
                color = Color.White,
                shape = ButtonDefaults.shape
            ),
            colors = ButtonDefaults.buttonColors(Color(0xFFFF9800))
        ) {
            Text(
                text = "Easy",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {

            navController.navigate("quiz/2")
        },
            modifier = Modifier.border(
                width = 3.dp,
                color = Color.White,
                shape = ButtonDefaults.shape
            ),
            colors = ButtonDefaults.buttonColors(Color(0xFFFF5722))
        ) {
            Text(
                text = "Medium",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {

            navController.navigate("quiz/3")
        },
            modifier = Modifier.border(
                width = 3.dp,
                color = Color.White,
                shape = ButtonDefaults.shape
            ),
            colors = ButtonDefaults.buttonColors(Color(0xFFE91E63))
        ) {
            Text(
                text = "Hard",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.padding(48.dp))

        Button(onClick = {

            navController.navigate("record")
        },
            modifier = Modifier.border(
                width = 3.dp,
                color = Color.White,
                shape = ButtonDefaults.shape
            ),
            colors = ButtonDefaults.buttonColors(Color(0xFF8BC34A))
        ) {
            Text(
                text = "Record",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

    }

}