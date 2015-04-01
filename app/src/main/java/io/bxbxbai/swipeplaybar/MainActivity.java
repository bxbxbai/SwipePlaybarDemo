package io.bxbxbai.swipeplaybar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.extras.toolbar.MaterialMenuIconToolbar;

import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity {

    private MaterialMenuIconToolbar materialMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = ButterKnife.findById(this, R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        materialMenu = new MaterialMenuIconToolbar(this, Color.WHITE, MaterialMenuDrawable.Stroke.REGULAR) {
            @Override public int getToolbarViewId() {
                return R.id.my_awesome_toolbar;
            }
        };
        getSupportFragmentManager().beginTransaction().replace(R.id.container_play_ctrl_bar, PlayCtrlBarFragment.instance())
                .commitAllowingStateLoss();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        materialMenu.syncState(savedInstanceState);
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        materialMenu.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
}
