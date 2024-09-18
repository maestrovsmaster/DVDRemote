package com.maestrovs.dvdremote.ui.widget.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.ui.theme.ButtonCarbon
import com.maestrovs.dvdremote.ui.widget.vibro.performHapticFeedbackSafely

@Composable
fun NumButton( tag: String, color: Color = ButtonCarbon, onClick: (String) -> Unit) {
    val view = LocalView.current



    OutlinedButton(
        onClick = {
            performHapticFeedbackSafely(view)
            onClick(tag)
        },
        border = BorderStroke(1.dp, color),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = color
        ),
        shape = RoundedCornerShape(18.dp),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(36.dp)
    ) {
        Text(
            tag,
            style = MaterialTheme.typography.bodySmall, color = Color.White,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewIrButton() {
    NumButton("0"){}
}