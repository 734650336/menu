package com.example.a01youku;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

class Tools {
    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    public static void hideView(ViewGroup view, int i) {
        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);
        ra.setStartOffset(i);
        view.startAnimation(ra);
        view.setEnabled(false);

        for (int p=0;p<view.getChildCount();p++){
            view.getChildAt(p).setEnabled(false);

        }
    }

    public static void showView(ViewGroup view, int i) {
        RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);
        ra.setStartOffset(i);
        view.startAnimation(ra);
        view.setEnabled(true);

        for (int p=0;p<view.getChildCount();p++){
            view.getChildAt(p).setEnabled(true);

        }

    }
}
