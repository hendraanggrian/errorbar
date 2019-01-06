/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hendraanggrian.material.errorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.ContentViewCallback;

/**
 * @see com.google.android.material.snackbar.SnackbarContentLayout
 */
public class ErrorbarContentLayout extends FrameLayout implements ContentViewCallback {
    private ImageView backgroundView;
    private ViewGroup containerView;
    private ImageView imageView;
    private TextView messageView;
    private Button actionView;

    public ErrorbarContentLayout(Context context) {
        this(context, null);
    }

    public ErrorbarContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        backgroundView = findViewById(R.id.errorbar_background);
        containerView = findViewById(R.id.errorbar_container);
        imageView = findViewById(R.id.errorbar_image);
        messageView = findViewById(R.id.errorbar_message);
        actionView = findViewById(R.id.errorbar_action);
    }

    @NonNull
    public ImageView getBackgroundView() {
        return backgroundView;
    }

    @NonNull
    public ViewGroup getContainerView() {
        return containerView;
    }

    @NonNull
    public ImageView getImageView() {
        return imageView;
    }

    @NonNull
    public TextView getMessageView() {
        return messageView;
    }

    @NonNull
    public Button getActionView() {
        return actionView;
    }

    @Override
    public void animateContentIn(int delay, int duration) {
        imageView.setAlpha(0f);
        imageView.animate().alpha(1f).setDuration(duration).setStartDelay(delay).start();

        messageView.setAlpha(0f);
        messageView.animate().alpha(1f).setDuration(duration).setStartDelay(delay).start();

        if (actionView.getVisibility() == VISIBLE) {
            actionView.setAlpha(0f);
            actionView.animate().alpha(1f).setDuration(duration).setStartDelay(delay).start();
        }
    }

    @Override
    public void animateContentOut(int delay, int duration) {
        imageView.setAlpha(1f);
        imageView.animate().alpha(0f).setDuration(duration).setStartDelay(delay).start();

        messageView.setAlpha(1f);
        messageView.animate().alpha(0f).setDuration(duration).setStartDelay(delay).start();

        if (actionView.getVisibility() == VISIBLE) {
            actionView.setAlpha(1f);
            actionView.animate().alpha(0f).setDuration(duration).setStartDelay(delay).start();
        }
    }
}