package com.ahmednts.scylla

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.annotation.RequiresApi

class DrawActivity : Activity() {
  private lateinit var h_scroll_view: HorizontalScrollView
  private lateinit var scroll_view: ScrollView
  private lateinit var content: LinearLayout

  @RequiresApi(Build.VERSION_CODES.M)
  public override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_NO_TITLE)

    val container = FrameLayout(this)
    container.setBackgroundColor(getColor(R.color.colorAccent))
    val padding = resources.getDimension(R.dimen.padding).toInt()
    container.setPadding(padding, padding, padding, padding)

//    h_scroll_view = HorizontalScrollView(this)
//    h_scroll_view.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//    h_scroll_view.setBackgroundColor(getColor(R.color.colorPrimary))
//
//    scroll_view = ScrollView(this)
//    scroll_view.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//
//    content = LinearLayout(this)
//    content.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//    content.orientation = LinearLayout.VERTICAL
//
//    val mainDrawView = DrawView(this)
//    mainDrawView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//    scroll_view.addView(mainDrawView)
//    h_scroll_view.addView(scroll_view)

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