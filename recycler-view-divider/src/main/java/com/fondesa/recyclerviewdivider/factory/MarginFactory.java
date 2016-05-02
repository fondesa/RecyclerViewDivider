package com.fondesa.recyclerviewdivider.factory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.fondesa.recycler_view_divider.R;
import com.fondesa.recyclerviewdivider.RecyclerViewDivider;

/**
 * Used to define a custom drawing logic for the left/right margins in an horizontal {@link RecyclerViewDivider}
 * and top/bottom margins in a vertical {@link RecyclerViewDivider} based on its position
 */
public abstract class MarginFactory {

    private static MarginFactory defaultFactory;

    /**
     * Creates a new instance of {@link Default} if system hasn't initialized it yet.
     *
     * @return default {@link MarginFactory} factory of the system
     */
    public static synchronized MarginFactory getDefault(@NonNull Context context) {
        if (defaultFactory == null) {
            defaultFactory = new Default(context);
        }
        return defaultFactory;
    }

    /**
     * Factory method called for each item in RecyclerView's Adapter
     *
     * @param listSize list's total size
     * @param position current position
     * @return left/right margins in an horizontal {@link RecyclerViewDivider} and top/bottom margins in a vertical {@link RecyclerViewDivider}
     */
    public abstract int marginSizeForItem(int listSize, int position);

    private static class Default extends MarginFactory {
        private int defaultMarginSize;

        Default(Context context) {
            defaultMarginSize = context.getResources().getDimensionPixelSize(R.dimen.recycler_view_divider_margin_size);
        }

        @Override
        public int marginSizeForItem(int listSize, int position) {
            return defaultMarginSize;
        }
    }
}