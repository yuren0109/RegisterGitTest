package com.example.registergittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.registergittest.view.MtaxiButton;

public class MainActivity extends AppCompatActivity {
    private MtaxiButton btnPhoneRegFg, btnSmsRegister;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private FrameLayout frameLayoutBalance;
    PhoneRegisterFragment phoneRegisterFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        findview();
        setListener();

    }
    /*
        public void onBackPressed() {
            if( getSupportFragmentManager().getBackStackEntryCount() > 0) {
                frameLayoutBalance.setVisibility(View.GONE);
                return;
            }
            super.onBackPressed();
        }
    */
    @Override
    public void onBackPressed() {
        if (frameLayoutBalance.getVisibility() == View.GONE) {
            super.onBackPressed();
        } else {
            frameLayoutBalance.setVisibility(View.GONE);
        }

    }


    private void findview() {
        frameLayoutBalance = (FrameLayout)findViewById(R.id.fragment_container);
        btnPhoneRegFg = findViewById(R.id.btn_phone_register);
        btnSmsRegister = findViewById(R.id.btn_sms_register);

    }

    private void setListener() {
        btnPhoneRegFg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frameLayoutBalance.setBackgroundColor(getResources().getColor(R.color.white));

                transaction = manager.beginTransaction();
                phoneRegisterFragment = new PhoneRegisterFragment();
                transaction.show(phoneRegisterFragment);
                transaction.replace(R.id.fragment_container, new PhoneRegisterFragment(), "phoneNumRegister");
                //transaction.addToBackStack(null);
                transaction.commit();
                frameLayoutBalance.setVisibility(View.VISIBLE);

                /*
                Intent intent = new Intent(MainActivity.this, PhoneNumRegister.class);
                startActivityForResult(intent, 1);
            */
            }
        });

        btnSmsRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frameLayoutBalance.setBackgroundColor(getResources().getColor(R.color.white));

                transaction = manager.beginTransaction();
                phoneRegisterFragment = new PhoneRegisterFragment();
                transaction.show(phoneRegisterFragment);
                transaction.replace(R.id.fragment_container, new PhoneRegisterFragment(), "phoneNumRegister");
                //transaction.addToBackStack(null);
                transaction.commit();
                frameLayoutBalance.setVisibility(View.VISIBLE);

                /*
                Intent intent = new Intent(MainActivity.this, PhoneNumRegister.class);
                startActivityForResult(intent, 1);
            */
            }
        });
    }
    void testMaster() {
        Log.d("test","測試分支功能");
    }
}

