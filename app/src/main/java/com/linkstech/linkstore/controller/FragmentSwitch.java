package com.linkstech.linkstore.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.linkstech.linkstore.MainActivity;
import com.linkstech.linkstore.R;
import com.linkstech.linkstore.fragment.LoginFragment;
import com.linkstech.linkstore.fragment.ProductFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Link Larkin on 7/4/2015.
 */
public class FragmentSwitch {
    private static List<Fragment> fragments;
    public static final int LOGIN = 0;
    public static final int PRODUCT = 1;
    private static FragmentSwitch INSTANCE;

    private FragmentSwitch() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new LoginFragment());
        fragments.add(new ProductFragment());
//        fragments.add(new AboutFragment());
    }

    public static FragmentSwitch getINSTANCE() {

        if (INSTANCE == null) {
            INSTANCE = new FragmentSwitch();
        }
        return INSTANCE;
    }

    public Fragment getFragment(int location) {
        return fragments.get(location);
    }

    public void switchFragment(int position, FragmentManager fragmentManager) {
        Fragment frag = this.getFragment(position);
        if (frag != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_content, frag).commit();
        }
        MainActivity.drawerLayout.closeDrawers();
    }
}
