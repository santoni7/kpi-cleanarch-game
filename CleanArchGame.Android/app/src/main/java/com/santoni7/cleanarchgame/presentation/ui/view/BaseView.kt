package com.santoni7.cleanarchgame.presentation.ui.view

import android.animation.Animator
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.santoni7.cleanarchgame.util.exception.LifecycleOwnerNotFoundException

abstract class BaseView: View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes)

    protected val animations = mutableListOf<Animator?>()
    protected var lifecycleOwner: LifecycleOwner? = null

    var isAttached: Boolean = false
        private set
        get

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        lifecycleOwner = context as? LifecycleOwner ?: throw LifecycleOwnerNotFoundException()

        onAttach()
    }

    open fun onAttach(){
        // observe some viewmodels etc
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animations.forEach { animator -> animator?.cancel() }
        animations.clear()
        lifecycleOwner = null
    }

    fun Animator.startAndSave(){
        start()
        animations.add(this)
    }
}