package com.linkstech.linkstore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.linkstech.linkstore.R;
import com.linkstech.linkstore.controller.RequestController;
import com.linkstech.linkstore.helper.ViewHolder;
import com.loopj.android.http.RequestParams;

/**
 * Created by Link Larkin on 6/10/2016.
 */
public class LoginFragment extends Fragment {
    public static TextView errorText;

    public LoginFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_login, container, false);
        Button btLogin = ViewHolder.getView(view, R.id.bt_login1);
        final EditText username = ViewHolder.getView(view, R.id.et_username);
        final EditText password = ViewHolder.getView(view, R.id.et_password);
        errorText = ViewHolder.getView(view, R.id.error_message);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams requestParams = new RequestParams();
                requestParams.add("username", username.getText().toString());
                requestParams.add("password", password.getText().toString());
                RequestController.getINSTANCE().login(requestParams,getFragmentManager());
            }
        });
        return view;
    }
}
