package com.jasonhezz.github.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 胡哲 on 2016/6/24.
 */
public class StateLayout extends FrameLayout {

  public final static int TYPE_EMPTY = 1;
  public final static int TYPE_LOADING = 2;
  public final static int TYPE_ERROR = 3;
  public final static int TYPE_CONTENT = 4;
  private LayoutInflater mLayoutInflater;
  private View mContentView;
  private View mErrorView;
  private View mEmptyView;
  private View mLoadingView;

  public StateLayout(Context context) {
    this(context, null);
  }

  public StateLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public StateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {
    mLayoutInflater = LayoutInflater.from(context);
    final TypedArray a =
        context.obtainStyledAttributes(attrs, R.styleable.StateLayout, defStyleAttr, defStyleAttr);

    mErrorView =
        inflateView(a.getResourceId(R.styleable.StateLayout_errorView, R.layout.view_error));
    mEmptyView =
        inflateView(a.getResourceId(R.styleable.StateLayout_emptyView, R.layout.view_empty));
    mLoadingView =
        inflateView(a.getResourceId(R.styleable.StateLayout_loadingView, R.layout.view_loading));
    a.recycle();
  }

  public View inflateView(@LayoutRes int res) {
    return mLayoutInflater.inflate(res, this, false);
  }

  public void setState(@LayoutState int state) {
    this.removeAllViews();
    switch (state) {
      case TYPE_ERROR:
        this.addView(mErrorView);
        break;
      case TYPE_LOADING:
        this.addView(mLoadingView);
        break;
      case TYPE_EMPTY:
        this.addView(mEmptyView);
        break;
      case TYPE_CONTENT:
        this.addView(mContentView);
        break;
    }
  }

  @Override public void addView(View child) {
    if (getChildCount() > 0) {
      throw new IllegalStateException("StateLayout can host only one direct child");
    }
    super.addView(child);
  }

  @Override public void addView(View child, int index) {
    if (getChildCount() > 0) {
      throw new IllegalStateException("StateLayout can host only one direct child");
    }
    super.addView(child, index);
  }

  @Override public void addView(View child, int width, int height) {
    if (getChildCount() > 0) {
      throw new IllegalStateException("StateLayout can host only one direct child");
    }
    super.addView(child, width, height);
  }

  @Override public void addView(View child, ViewGroup.LayoutParams params) {
    if (getChildCount() > 0) {
      throw new IllegalStateException("StateLayout can host only one direct child");
    }
    super.addView(child, params);
  }

  @Override public void addView(View child, int index, ViewGroup.LayoutParams params) {
    if (getChildCount() > 0) {
      throw new IllegalStateException("StateLayout can host only one direct child");
    }
    super.addView(child, index, params);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    mContentView = this.getChildAt(0);
  }

  @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {
    int mChildCount = this.getChildCount();
    if (mChildCount > 0) {
      for (int i = 0; i < mChildCount; i++) {
        this.getChildAt(i).layout(l, t, r, b);
      }
    }
  }

  @IntDef({ TYPE_EMPTY, TYPE_LOADING, TYPE_ERROR, TYPE_CONTENT }) @Retention(RetentionPolicy.SOURCE)
  public @interface LayoutState {
  }

  public interface onStateChangeListener {
    void onClickErrorView(View errorView);

    void onClickLoadingView(View loadingView);

    void onClickEmptyView(View emptyView);
  }
}
