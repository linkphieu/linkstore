package com.linkstech.linkstore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.linkstech.linkstore.MainActivity;
import com.linkstech.linkstore.R;
import com.linkstech.linkstore.helper.ViewHolder;

/**
 * Created by Link Larkin on 6/10/2016.
 */
public class LoginFragment extends Fragment {

    public LoginFragment() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);
        Button btLogin = ViewHolder.getView(view,R.id.bt_login1);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("test");
//                View view1 = inflater.inflate(R.layout.activity_main,container,false);
//                LinearLayout userInfo = ViewHolder.getView(view1,R.id.user_info);
                MainActivity.userInfo.setVisibility(View.VISIBLE);
//                Button btLogin = ViewHolder.getView(view1,R.id.bt_login);
                MainActivity.btLogin.setVisibility(View.GONE);
            }
        });
        return view;
    }
}
