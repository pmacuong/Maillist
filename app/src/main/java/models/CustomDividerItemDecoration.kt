package models

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class CustomDividerItemDecoration(context: Context) : DividerItemDecoration(context, VERTICAL) {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.top = 10
        outRect.bottom = 10
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val divider = DividerDrawable(Color.LTGRAY, 1)
        divider.setBounds(parent.paddingLeft, parent.paddingTop, parent.width - parent.paddingRight, parent.height - parent.paddingBottom)
        divider.draw(c)
    }
}

class DividerDrawable(private val color: Int, private val size: Int) : ColorDrawable(color) {

    override fun getIntrinsicWidth(): Int {
        return size
    }

    override fun getIntrinsicHeight(): Int {
        return size
    }
}