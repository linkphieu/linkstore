package com.linkstech.linkstore.adapter;

import android.support.v4.app.Fragment;

import com.linkstech.linkstore.fragment.LoginFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Link Larkin on 7/4/2015.
 */
public class FragmentSwitch {
    private static List<Fragment> fragments;
    public static final int LOGIN = 0;
    private static FragmentSwitch INSTANCE;

    private FragmentSwitch() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new LoginFragment());
//        fragments.add(new GiftFragment());
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
}
