package com.example.quizz_game.Container_Screen.Custom_View.Hexagon_shape

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.quizz_game.Container_Screen.Model.CustomIconView
import com.example.quizz_game.R
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

@SuppressLint("ViewConstructor", "UseCompatLoadingForDrawables")
class HexagonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private val hexagonPaint: Paint = Paint()
    private val borderPaint: Paint = Paint()
    private val path: Path = Path()
    private var imageDrawable: Drawable
    private var iconSize = 0
    private var borderWidth = 5f
    private var cornerRadius = 20f
    private var customDrawable: Drawable? = null

    init {
//        updateView()
        hexagonPaint.isAntiAlias = true
        hexagonPaint.style = Paint.Style.FILL
        hexagonPaint.pathEffect = CornerPathEffect(38f) // đường viền corner
        hexagonPaint.color = Color.parseColor("#FF9051")

        borderPaint.isAntiAlias = true
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = borderWidth
        borderPaint.pathEffect = CornerPathEffect(38f)// đường viền corner
        borderPaint.color = Color.WHITE // Màu viền

        // Load ảnh icon từ resources
        imageDrawable = context.resources.getDrawable(R.drawable.ic_lock, null)

        // Kích thước của icon (bạn có thể thay đổi theo ý muốn)
        iconSize = resources.getDimensionPixelSize(R.dimen.icon_size)

        this.id = generateViewId()

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (min(centerX, centerY) - 5).toFloat()

        path.reset()

        for (i in 0 until 6) {
            val angle = Math.toRadians((60 * i).toDouble() + 30) // +30 để xoay view lên trên
            val x = (centerX + radius * cos(angle)).toFloat()
            val y = (centerY + radius * sin(angle)).toFloat()

            if (i == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }

        path.close()

        // Vẽ hexagon
        canvas.drawPath(path, hexagonPaint)
        canvas.drawPath(path, borderPaint)



        // Vẽ icon bên trong hexagon
        val iconLeft = centerX - iconSize / 2
        val iconTop = centerY - iconSize / 2
        imageDrawable.setBounds(iconLeft.toInt(), iconTop.toInt(), (iconLeft + iconSize).toInt(), (iconTop + iconSize).toInt())
        imageDrawable.draw(canvas)


    }
    fun updateView(drawable: Drawable) {
        customDrawable = drawable
        invalidate()
    }
}