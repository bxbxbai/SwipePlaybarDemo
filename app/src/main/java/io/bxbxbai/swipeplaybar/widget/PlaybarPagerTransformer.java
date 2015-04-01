package io.bxbxbai.swipeplaybar.widget;

import android.animation.ObjectAnimator;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.bxbxbai.swipeplaybar.R;
import io.bxbxbai.swipeplaybar.StopWatch;

/**
 * 播放条的PagerTransformer
 *
 * @author bxbxbai
 */
public class PlaybarPagerTransformer implements ViewPager.PageTransformer {

    private List<ViewPager.PageTransformer> mTransformers = new ArrayList<>();

    @Override
    public void transformPage(View page, float position) {
        for (ViewPager.PageTransformer transformer : mTransformers) {
            transformer.transformPage(page, position);
        }

        //处理图片旋转

        StopWatch.log("page: " + page + ", pos: " + position);

        if (position == 0) {
            ObjectAnimator animator = (ObjectAnimator) page.getTag(R.id.tag_animator);
            if (animator != null) {
                animator.start();
            }
        } else if (position == -1 || position == -2 || position == 1) {
            ObjectAnimator animator = (ObjectAnimator) page.getTag(R.id.tag_animator);
            if (animator != null) {
                animator.end();
            }
        }
    }


    public void addTransformer(ViewPager.PageTransformer transformer) {
        if (transformer != null) {
            mTransformers.add(transformer);
        }
    }
}
