package com.ahmednts.scylla.board

import android.graphics.*
import android.graphics.drawable.Drawable

class StatelessUI() : Drawable() {

  private val boxPaint: Paint = Paint()
  private var boxRect: Rect = Rect()

  init {
    boxRect = getBoxRect(100, 0)
  }

  override fun isStateful(): Boolean {
    return false
  }

  override fun getOpacity(): Int { // see documentation on android developers site
    return PixelFormat.OPAQUE
  }

  override fun setColorFilter(colorFilter: ColorFilter?) {}
  override fun setAlpha(i: Int) {}

  override fun draw(canvas: Canvas) {
    boxPaint.color = Color.RED
    canvas.drawRect(boxRect, boxPaint)
  }

  private fun getBoxRect(width: Int, padding: Int): Rect {
    return Rect(padding, padding, width - padding, width - padding)
  }
}