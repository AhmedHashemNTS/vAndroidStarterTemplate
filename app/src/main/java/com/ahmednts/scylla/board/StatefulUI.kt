package com.ahmednts.scylla.board

import android.graphics.*
import android.graphics.drawable.Drawable

class StatefulUI() : Drawable() {

  private val boxPaint: Paint = Paint()
  private var boxRect: Rect = Rect()

  init {
    boxRect = getBoxRect(100, 0)
  }

  override fun isStateful(): Boolean {
    return true
  }

  override fun getOpacity(): Int { // see documentation on android developers site
    return PixelFormat.OPAQUE
  }

  override fun setColorFilter(colorFilter: ColorFilter?) {}
  override fun setAlpha(i: Int) {}

  var pressed = false
  override fun onStateChange(states: IntArray): Boolean {
    for (state in state) {
      pressed = state == android.R.attr.state_pressed || state == android.R.attr.state_focused
    }

    invalidateSelf()
    return true
  }

  override fun draw(canvas: Canvas) {
    boxPaint.color = if (pressed) Color.RED else Color.BLUE
    canvas.drawRect(boxRect, boxPaint)
  }

  private fun getBoxRect(width: Int, padding: Int): Rect {
    return Rect(padding, padding, width - padding, width - padding)
  }
}