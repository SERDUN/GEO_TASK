package com.example.user.geotask.screen.baseContainerActivity;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.user.geotask.R;
import com.example.user.geotask.screen.beginningPathFragment.BeginningPathPageFragment;
import com.example.user.geotask.screen.endRoadFragment.EndRoadPageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseContainerActivity extends AppCompatActivity implements BeginningPathPageFragment.OnFragmentInteractionListener,EndRoadPageFragment.OnFragmentInteractionListener {

    @BindView(R.id.btn1)
    public ImageView btn1;

    @BindView(R.id.btn2)
    public ImageView btn2;
    private BaseContainerActivity upView;

    private final int WIDTH_VIEW_MAX =60;
    private final int HEIGHT_VIEW_MAX =60;

    private final int WIDTH_VIEW_MIN =30;
    private final int HEIGHT_VIEW_MIN =30;

//    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(WIDTH_VIEW_MAX, HEIGHT_VIEW_MAX);



    @BindView(R.id.vpMapStartAndFinish)
    public ViewPager viewPager;

    private SettingPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
//        layoutParams.setMargins(30, 20, 10, 30);


        setUpView();
        onCircleButtonClick();
        setTab();




    }


    private void setTab() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int position) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageSelected(int position) {
//             layoutParams = new LinearLayout.LayoutParams(WIDTH_VIEW_MIN, HEIGHT_VIEW_MIN);
//                layoutParams.setMargins(30, 20, 30, 10);

                btn1.setImageResource(R.drawable.map);
//                btn1.setLayoutParams(layoutParams);

                btn2.setImageResource(R.drawable.map);
//                btn2.setLayoutParams(layoutParams);

                btnAction(position);
            }
        });
    }

    private void btnAction(int action) {
//        layoutParams = new LinearLayout.LayoutParams(WIDTH_VIEW_MAX, HEIGHT_VIEW_MAX);
//        layoutParams.setMargins(30, 20, 30, 10);

        switch (action) {
            case 0:
                btn1.setImageResource(R.drawable.street_map);
//                btn1.setLayoutParams(layoutParams);

                break;
            case 1:
                btn2.setImageResource(R.drawable.street_map);
//                btn2.setLayoutParams(layoutParams);
                break;

        }
    }

    private void onCircleButtonClick() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setImageResource(R.drawable.street_map);
                viewPager.setCurrentItem(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setImageResource(R.drawable.street_map);
                viewPager.setCurrentItem(1);
            }
        });
    }
    private void setUpView() {
        adapter = new SettingPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
