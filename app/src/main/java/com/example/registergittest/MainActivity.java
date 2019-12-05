package com.example.registergittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.registergittest.view.MtaxiButton;

public class MainActivity extends AppCompatActivity {
    private MtaxiButton btnPhoneRegFg, btnSmsRegister,btnSkip;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private FrameLayout frameLayoutBalance;
    PhoneRegisterFragment phoneRegisterFragment;

    private int layoutNum= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setLayout();

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
        if (frameLayoutBalance.getVisibility() != View.GONE) {
            frameLayoutBalance.setVisibility(View.GONE);
        }
        else {
            super.onBackPressed();
        }
    }

        private void findview () {
            frameLayoutBalance = (FrameLayout) findViewById(R.id.fragment_container);
            btnPhoneRegFg = findViewById(R.id.btn_phone_register);
            btnSmsRegister = findViewById(R.id.btn_sms_register);
            btnSkip = findViewById(R.id.btn_skip_register);
        }

        private void setListener () {
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
                    setContentView(R.layout.activity_skip_register);

                /*
                frameLayoutBalance.setBackgroundColor(getResources().getColor(R.color.white));

                transaction = manager.beginTransaction();
                phoneRegisterFragment = new PhoneRegisterFragment();
                transaction.show(phoneRegisterFragment);
                transaction.replace(R.id.fragment_container, new PhoneRegisterFragment(), "phoneNumRegister");
                //transaction.addToBackStack(null);
                transaction.commit();
                frameLayoutBalance.setVisibility(View.VISIBLE);
*/
                /*
                Intent intent = new Intent(MainActivity.this, PhoneNumRegister.class);
                startActivityForResult(intent, 1);
            */
                }
            });
            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutNum=2;
                    setLayout();
                }
            });

    }
    void setLayout() {
        //Layout MainRegister
        if(layoutNum ==1){
            setContentView(R.layout.activity_main);
        }
        //Layout SkipBackToRegister
        if(layoutNum ==2){
            setContentView(R.layout.activity_skip_register);
        }
    }


    void testMaster() {
        Log.d("test","測試分支功能");
    }
    void testBranch() {
        Log.d("test","測試分支功能");
    }


}

