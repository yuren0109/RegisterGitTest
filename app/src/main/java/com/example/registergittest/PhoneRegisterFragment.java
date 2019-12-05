package com.example.registergittest;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registergittest.view.MtaxiButton;

public class PhoneRegisterFragment extends Fragment {
    private EditText editPhoneNum;
    private MtaxiButton btnPhoneReg;
    private AlertDialog.Builder alertDialog;
    private View root ;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       root = inflater.inflate(R.layout.fragment_phone_register, container, false);


        findView();

        return root;
    }

    private void findView() {
        editPhoneNum = root.findViewById(R.id.edit_phone_number);
        btnPhoneReg = root.findViewById(R.id.btn_phone_register);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPhoneReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("123 ","btnPhoneRegisClicked");
                if (!invalidLoginEntries(editPhoneNum.getText().toString())) {
                    alertDialog = new AlertDialog.Builder(getActivity());
                    alertDialog.setTitle('\n'+"電話號碼格式錯誤"+'\n');
                    alertDialog.show();
                }
            }
        });

    }



    private boolean invalidLoginEntries(String phoneNum) {
        if (phoneNum.length() > 0 && ((phoneNum.length() == 10 && phoneNum.substring(0, 2).equals("09")) || (phoneNum.substring(0, 1).equals("+")))) {
            return true;
        }
        return false;
    }
}
