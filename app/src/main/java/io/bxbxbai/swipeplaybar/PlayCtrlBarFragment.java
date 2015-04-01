package io.bxbxbai.swipeplaybar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import io.bxbxbai.swipeplaybar.widget.PlaybarPagerTransformer;

/**
 *
 * @author bxbxbai
 */
public class PlayCtrlBarFragment extends Fragment {


    ViewPager mViewPager;
    PlayCtrlBarPagerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_play_ctrl_bar, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mViewPager = ButterKnife.findById(view, R.id.viewpager);
        mAdapter = new PlayCtrlBarPagerAdapter(getActivity());
        mViewPager.setAdapter(mAdapter);

        PlaybarPagerTransformer transformer = new PlaybarPagerTransformer();
//        transformer.addTransformer(new ReaderViewPagerTransformer(ReaderViewPagerTransformer.TransformType.ZOOM));
        mViewPager.setPageTransformer(true, transformer);


//        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                StopWatch.log("select: " + position + ", current: " + mViewPager.getCurrentItem()
//                    + ", views: " + mViewPager.getChildCount());
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public static PlayCtrlBarFragment instance() {
        Bundle b = new Bundle();
        PlayCtrlBarFragment fragment = new PlayCtrlBarFragment();
        fragment.setArguments(b);
        return fragment;
    }
}
