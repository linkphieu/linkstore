package com.linkstech.linkstore;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.linkstech.linkstore.controller.FragmentSwitch;

public class MainActivity extends AppCompatActivity {
    public static DrawerLayout drawerLayout;
    private LinearLayout slideMenu;
    private Button btSlideMenu;
    public static Button btLogin;
    public static LinearLayout userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        FragmentSwitch.getINSTANCE().switchFragment(FragmentSwitch.PRODUCT, getSupportFragmentManager());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        slideMenu = (LinearLayout) findViewById(R.id.slideMenu);
        btSlideMenu = (Button) findViewById(R.id.bt_slide_menu);
        btLogin = (Button) findViewById(R.id.bt_login);
        userInfo = (LinearLayout) findViewById(R.id.user_info);
    }

    private void initListener() {
        btSlideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawerLayout.isDrawerOpen(slideMenu))
                    drawerLayout.openDrawer(slideMenu);
            }
        });
        slideMenu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                drawerLayout.closeDrawers();
                return false;
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSwitch.getINSTANCE().switchFragment(FragmentSwitch.LOGIN, getSupportFragmentManager());
            }
        });
    }

}
