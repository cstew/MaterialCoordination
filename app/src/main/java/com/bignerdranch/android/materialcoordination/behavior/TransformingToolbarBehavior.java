package com.bignerdranch.android.materialcoordination.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class TransformingToolbarBehavior extends CoordinatorLayout.Behavior<View> {
    private static final String TAG = TransformingToolbarBehavior.class.getSimpleName();

    private ToolbarChangeListener mToolbarChangeListener;

    public interface ToolbarChangeListener {
        void onToolbarCollapse();
        void onToolbarShown();
    }

    public TransformingToolbarBehavior() {

    }

    public TransformingToolbarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setToolbarChangeListener(ToolbarChangeListener toolbarChangeListener) {
        mToolbarChangeListener = toolbarChangeListener;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        if (dependency.getTop() >= 0) {
            // Show bottom toolbar
            if (mToolbarChangeListener != null) {
                mToolbarChangeListener.onToolbarShown();
            }
            return true;
        } else if (dependency.getBottom() <= 0) {
            // Hide bottom toolbar
            if (mToolbarChangeListener != null) {
                mToolbarChangeListener.onToolbarCollapse();
            }
            return true;
        }

        return false;
    }

}
