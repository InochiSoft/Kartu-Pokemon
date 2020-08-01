package com.dicoding.agungnovian.helper

import android.content.Context
import android.graphics.*
import android.util.DisplayMetrics
import android.widget.ImageView
import com.dicoding.agungnovian.R
import java.util.*


object Energy{
    fun draw(context : Context, imageView: ImageView, type : String) {
        val image = BitmapFactory.decodeResource(
            context.resources,
            R.mipmap.ic_energy
        )

        val density = context.resources.displayMetrics.density

        val scale = 25
        val size = (scale * density).toInt()

        var posX = 0
        var posY = 0

        // Width
        // Height
        // Config

        //canvas.drawColor(Color.GREEN)
        when (type.toLowerCase(Locale.ROOT)) {
            "fire" -> {
                posX = 0
                posY = 0
            }
            "colorless" -> {
                posX = 1
                posY = 0
            }
            "fairy" -> {
                posX = 2
                posY = 0
            }
            "metal" -> {
                posX = 3
                posY = 0
            }
            "dragon" -> {
                posX = 0
                posY = 1
            }
            "lightning" -> {
                posX = 1
                posY = 1
            }
            "fighting" -> {
                posX = 2
                posY = 1
            }
            "psychic" -> {
                posX = 3
                posY = 1
            }
            "darkness" -> {
                posX = 0
                posY = 2
            }
            "grass" -> {
                posX = 1
                posY = 2
            }
            "water" -> {
                posX = 3
                posY = 2
            }
        }

        val left = (posX * scale * density).toInt()
        val top = (posY * scale * density).toInt()
        val right = left + (scale * density).toInt()
        val bottom = top + (scale * density).toInt()

        val bitmap = Bitmap.createBitmap(
            size,  // Width
            size,  // Height
            Bitmap.Config.ARGB_8888 // Config
        )

        val paint = Paint()
        val rectSrc = Rect(left, top, right, bottom)
        val rectDest = Rect(0, 0, size, size)

        val canvas = Canvas(bitmap)

        //canvas.drawColor(Color.GREEN)

        canvas.drawBitmap(image, rectSrc, rectDest, paint)
        imageView.setImageBitmap(bitmap)
    }
}