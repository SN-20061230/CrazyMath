package uz.teacher.crazymath.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.teacher.crazymath.R
import uz.teacher.crazymath.model.Quiz
import uz.teacher.crazymath.model.Records

@Composable
fun QuizScreen(navController: NavHostController, quizlevel: String) {
    val quiz = remember {
        Quiz()
    }
    val questions = remember {
        mutableIntStateOf(0)
    }

    val level = remember { mutableIntStateOf(quizlevel.toInt()) }

    val currentQuestion = remember {
        mutableStateOf(quiz.createQuiz(level.intValue))
    }
    val score = remember {
        mutableIntStateOf(0)
    }
    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.quiz_bg),
        contentDescription = null,
        alpha = 0.6F
    )

    Column {
        Row(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Questions: ${questions.intValue}",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Image(
                    modifier = Modifier
                        .width(50.dp)
                        .padding(end = 12.dp),
                    painter = painterResource(id = R.drawable.diamond),
                    contentDescription = null,

                    )
                Text(
                    text = score.intValue.toString(),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                text = currentQuestion.value,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                fontSize = 42.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (quiz.checkAnswer("+")) {
                        score.intValue++
                    }
                    questions.intValue++
                    currentQuestion.value = quiz.createQuiz(level.intValue)

                },
                modifier = Modifier.border(
                    width = 3.dp,
                    color = Color.White,
                    shape = ButtonDefaults.shape
                ),
                colors = ButtonDefaults.buttonColors(Color(0xFFFF5722))
            ) {
                Text(
                    text = "+",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(120.dp),
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        if (level.intValue != 1) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        if (quiz.checkAnswer("/")) {
                            score.intValue++
                        }
                        questions.intValue++
                        currentQuestion.value = quiz.createQuiz(level.intValue)
                    },
                    modifier = Modifier.border(
                        width = 3.dp,
                        color = Color.White,
                        shape = ButtonDefaults.shape
                    ),
                    colors = ButtonDefaults.buttonColors(Color(0xFFE91E63))
                ) {
                    Text(
                        text = "/",
                        modifier = Modifier
                            .padding(8.dp)
                            .width(60.dp),
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = {
                        if (quiz.checkAnswer("*")) {
                            score.intValue++
                        }
                        questions.intValue++
                        currentQuestion.value = quiz.createQuiz(level.intValue)
                    },
                    modifier = Modifier.border(
                        width = 3.dp,
                        color = Color.White,
                        shape = ButtonDefaults.shape
                    ),
                    colors = ButtonDefaults.buttonColors(Color(0xFFAA073E))

                ) {
                    Text(
                        text = "*",
                        modifier = Modifier
                            .padding(8.dp)
                            .width(60.dp),
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (quiz.checkAnswer("-")) {
                        score.intValue++
                    }
                    questions.intValue++
                    currentQuestion.value = quiz.createQuiz(level.intValue)
                },
                modifier = Modifier.border(
                    width = 3.dp,
                    color = Color.White,
                    shape = ButtonDefaults.shape
                ),
                colors = ButtonDefaults.buttonColors(Color(0xFFF1D203))
            ) {
                Text(
                    text = "-",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(120.dp),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.padding(64.dp))
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    val record = Records(score.intValue, level.intValue)
                    navController.navigate(record)
                },
                modifier = Modifier.border(
                    width = 3.dp,
                    color = Color.White,
                    shape = ButtonDefaults.shape
                ),
                colors = ButtonDefaults.buttonColors(Color(0xFFC40A49))
            ) {
                Text(
                    text = "YAKUNLASH",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(120.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


