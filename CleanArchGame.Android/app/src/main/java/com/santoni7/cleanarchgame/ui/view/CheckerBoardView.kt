package com.santoni7.cleanarchgame.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.graphics.withTranslation
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.FigureColor

class CheckerBoardView : BaseView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )




    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var colWhiteCell = Color.argb(255, 255, 255, 229)
    private var colBlackCell = Color.argb(255, 53, 53, 53)
    private var colLines = Color.BLACK
    private var borderWidth = 2.0f
    private val figureColorMap = mapOf(
        FigureColor.BLACK to Color.argb(255, 48, 47, 45),
        FigureColor.WHITE to Color.argb(255, 244, 237, 227)
    )

    private var totalSize = 320f
    private var defaultPadding = 64f

    private val areaSize
        get() = totalSize - padding * 2

    private var padding = defaultPadding

    var board: Board? = null
        get
        set(b) {
            field = b
            if (isAttached) invalidate()
        }


    override fun onAttach() {
//      Animation showcase:
//        val amplitude = defaultPadding * 0.02f
//        ValueAnimator.ofFloat(-amplitude, amplitude, -amplitude).apply {
//            repeatMode = ValueAnimator.REVERSE
//            duration = 2400
//            repeatCount = ValueAnimator.INFINITE
//            interpolator = AccelerateDecelerateInterpolator()
//            addUpdateListener {
//                padding = defaultPadding + it.animatedValue as Float
//                invalidate()
//            }
//        }.startAndSave()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        totalSize = Math.min(measuredWidth, measuredHeight)
            .also { setMeasuredDimension(it, it) }
            .toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (board == null || canvas == null) {
            Log.e(CheckerBoardView::class.simpleName, "Board ($board) or canvas($canvas) is null")
            canvas?.drawText("Error: BOARD IS NULL", 10f, 10f, paint.apply { color = Color.BLACK })
            return
        }
        board!!

        canvas.withTranslation(padding, padding) {
            val cellSize = areaSize / Board.BOARD_SIZE
            drawCellsBackground(cellSize)
            drawCellsLines(cellSize)
            drawFigures(cellSize)
        }
    }

    private fun Canvas.drawFigures(cellSize: Float) {
        board!!.forEachCell { cell ->
            if (!cell.isFree) {
                figureColorMap[cell.figure!!.color]?.also { color ->
                    with(cell.getBounds(cellSize)) {
                        val radius = (cellSize / 2) * 0.66f
                        val cx = (left + right) / 2
                        val cy = (top + bottom) / 2

                        paint.style = Paint.Style.FILL
                        paint.color = color
                        drawCircle(cx, cy, radius, paint)

                        paint.style = Paint.Style.STROKE
                        paint.color = colLines
                        drawCircle(cx, cy, radius, paint)
                    }
                }
            }
        }
    }

    private fun Canvas.drawCellsLines(cellSize: Float) {
        paint.style = Paint.Style.STROKE
        paint.color = colLines
        paint.strokeWidth = borderWidth
        for (i in 0..Board.BOARD_SIZE) {
            drawLine(cellSize * i, 0f, cellSize * i, areaSize, paint)
            drawLine(0f, cellSize * i, areaSize, cellSize * i, paint)
        }
    }

    private fun Canvas.drawCellsBackground(cellSize: Float) {
        paint.style = Paint.Style.FILL
        for (x in 0 until Board.BOARD_SIZE) {
            for (y in 0 until Board.BOARD_SIZE) {
                val cell = board!!.cells[x][y]
                paint.color = cell.getDrawColor()
                drawRect(cell.getBounds(cellSize), paint)
            }
        }
    }

    private fun Board.Cell.getDrawColor() =
        if (x % 2 == 0) {
            if (y % 2 == 0) colWhiteCell
            else colBlackCell
        } else {
            if (y % 2 == 0) colBlackCell
            else colWhiteCell
        }


    private fun Board.Cell.getBounds(cellSize: Float) =
        RectF(x * cellSize, y * cellSize, x * cellSize + cellSize, y * cellSize + cellSize)
}