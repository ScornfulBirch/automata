package com.lockwood.automata.resources

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.lockwood.automata.graphics.tint

@ColorInt
fun Context.color(
    @ColorRes colorRes: Int
): Int = ContextCompat.getColor(this, colorRes)

fun Context.drawable(
    @DrawableRes drawableRes: Int
): Drawable? = AppCompatResources.getDrawable(this, drawableRes)

fun Context.drawable(
    @DrawableRes drawableRes: Int,
    @ColorRes colorRes: Int
): Drawable? {
    val drawable = drawable(drawableRes)
    val tintColor = color(colorRes)

    return drawable?.tint(tintColor)
}

fun Context.bitmap(
    @IdRes bitmapRes: Int,
    options: BitmapFactory.Options? = null
): Bitmap = BitmapFactory.decodeResource(resources, bitmapRes, options)

fun Context.anim(
    @AnimRes animRes: Int
): Animation = AnimationUtils.loadAnimation(this, animRes)

fun Context.dimen(
    @DimenRes dimenRes: Int
): Float = resources.getDimension(dimenRes)

@Px
fun Context.dimenPx(
    @DimenRes dimenRes: Int
): Int = resources.getDimensionPixelSize(dimenRes)