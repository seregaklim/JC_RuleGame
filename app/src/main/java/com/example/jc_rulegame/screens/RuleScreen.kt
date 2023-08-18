package com.example.jc_rulegame.screens

import android.util.Log
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jc_rulegame.R
import com.example.jc_rulegame.utils.ValueList

@Composable
fun RuleScreen() {

    var rotationValue by remember {
        mutableStateOf(0f)
    }

  //число которое выпало
    var number by remember {
        mutableStateOf(0)
    }

     //унимированный угол
    val angle: Float by animateFloatAsState(
        targetValue = rotationValue,
       //настройки анимации
        animationSpec = tween(
           //время анимации
            durationMillis = 2000,
            //скорость вращения
            easing = LinearOutSlowInEasing
        ),
       //конец анимации
        finishedListener = {
            val index = (365f - (rotationValue % 360f)) / (360f / ValueList.list.size)
            Log.d("MyLog", "index: ${index}")
           number = ValueList.list[index.toInt()]
        }
    )
  //  Log.d("MyLog", "angle: $angle")



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .wrapContentHeight()
                .wrapContentWidth(),
            //число которое выпало
            text = number.toString(),
           //толщина текста
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = Color.White
        )
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.roulette),
                contentDescription = "Ruleta",
                modifier = Modifier.fillMaxSize()
                    //вращение
                    .rotate(angle)
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.triangle),
                    contentDescription = "Flecha",
                    modifier = Modifier.fillMaxSize(1 / 6f)
                )
            }
        }
        Button(
            onClick = {
                //.random() случайное число 720-два оборота + angle -крутится по кругу от старого значения
                rotationValue = ((0..360).random().toFloat() + 720) + angle
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Start",
                color = White
            )
        }

    }
}