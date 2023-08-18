package com.example.jc_rulegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.jc_rulegame.screens.RuleScreen
import com.example.jc_rulegame.ui.theme.GreenBg
import com.example.jc_rulegame.ui.theme.JC_RuleGameTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_RuleGameTheme {
                ////фон
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GreenBg
                ) {
                    RuleScreen()
                }
            }
        }
    }
}

