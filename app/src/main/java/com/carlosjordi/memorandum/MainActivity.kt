package com.carlosjordi.memorandum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.carlosjordi.memorandum.data.model.Card
import com.carlosjordi.memorandum.presentation.theme.MemorandumTheme
import com.wajahatkarim.flippable.Flippable
import com.wajahatkarim.flippable.rememberFlipController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemorandumTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val tempCard = Card(
                        frontImage = R.drawable.card_placeholder_front,
                        backImage = R.drawable.card_placeholder_back
                    )
                    FlippableCard(card = tempCard)
                }
            }
        }
    }
}

@Composable
fun FlippableCard(
    card: Card,
    size: Dp = 80.dp
) {
    val flippableController = rememberFlipController()
    Box(modifier = Modifier.size(size)) {
        Card {
            Flippable(
                frontSide = { CardSide(painterResource = painterResource(card.frontImage)) },
                backSide = { CardSide(painterResource = painterResource(card.backImage)) },
                flipController = flippableController,
//                modifier = Modifier.border(width = 2.dp, color = Color.Red)
            )
        }
    }
}

@Composable
fun CardSide(
    painterResource: Painter,
    size: Dp = 80.dp
) {
    Image(
        painter = painterResource,
        contentDescription = null,
        modifier = Modifier.size(size)
    )
}