package com.maestrovs.dvdremote.ui.widget.vibro

import android.view.HapticFeedbackConstants
import android.view.View

fun performHapticFeedbackSafely(view: View?) {
    view?.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
}