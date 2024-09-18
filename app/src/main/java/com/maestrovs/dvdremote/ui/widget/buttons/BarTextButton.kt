package com.maestrovs.dvdremote.ui.widget.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
fun BarTextButton( text: String, tag: String, color: Color = ButtonCarbon, onClick: (String) -> Unit) {
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
        shape = RoundedCornerShape(
            bottomStart = 6.dp, bottomEnd = 6.dp,
            topStart = 6.dp, topEnd = 6.dp
        ),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.height(36.dp).width(48.dp)
    ) {
        Text(
            text,
            style = MaterialTheme.typography.labelSmall, color = Color.White,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewBarTextButton() {
    BarTextButton("INFO", "0"){}
}