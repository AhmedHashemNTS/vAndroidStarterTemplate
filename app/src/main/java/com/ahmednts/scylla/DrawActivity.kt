package com.ahmednts.scylla

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.RippleDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.google.android.material.ripple.RippleDrawableCompat

class DrawActivity : Activity() {
  @RequiresApi(Build.VERSION_CODES.M)
  public override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_NO_TITLE)

    val container = FrameLayout(this)
    container.setBackgroundColor(getColor(R.color.colorAccent))
    val padding = resources.getDimension(R.dimen.padding).toInt()
    container.setPadding(padding, padding, padding, padding)

    val asd = TwoDScrollView(this)

    val mainDrawView = DrawView(this)
    mainDrawView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
    asd.addView(mainDrawView)

    container.addView(asd)
    setContentView(container)
  }

  inner class DrawView(context: Context) : View(context) {

    private val boxPaint: Paint = Paint()
    private var boxRect: Rect = Rect()

    init {
      boxPaint.color = Color.GREEN
      boxRect = getBoxRect(3000, 50)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
      val width = 3000
      val height = 3000
      setMeasuredDimension(width, height)
    }

    public override fun onDraw(canvas: Canvas) {


      canvas.drawRect(boxRect, boxPaint)


    }

    private fun getBoxRect(width: Int, padding: Int): Rect {
      return Rect(padding, padding, width - padding, width - padding)
    }
  }
}