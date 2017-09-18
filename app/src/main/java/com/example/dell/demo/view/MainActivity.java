package com.example.dell.demo.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dell.demo.R;
import com.example.dell.demo.view.ShouyeFragment;
import com.example.dell.demo.view.ToutiaoFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frame;
    private RadioButton redio_btn1;
    private RadioButton redio_btn2;
    private RadioGroup redio_group;
    private ShouyeFragment shouyeFragment;
    private ToutiaoFragment toutiaoFragment;
    //      我哈尼给我写的代码，我先注释，试试我的
//    private FrameLayout frame;
//    private RadioButton redio_btn1;
//    private RadioButton redio_btn2;
//    private RadioGroup redio_group;
//    private Fragment homefragment;
//    private Fragment titlefragment;
//    private ArrayList<Fragment> fragments = new ArrayList<>();
//    private FragmentManager fm;
//    private Fragment mfragment;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initView();
//
//        initfragment();
//
//    }
//
//    private void initfragment() {
//
//        fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        homefragment = new ShouyeFragment();
//        titlefragment = new ToutiaoFragment();
//        fragments.add(homefragment);
//        fragments.add(titlefragment);
//        mfragment = homefragment;
//
//        ft.add(R.id.frame,mfragment);
//        ft.commitAllowingStateLoss();
//
//    }
//
//    private void initView() {
//        frame = (FrameLayout) findViewById(R.id.frame);
//        redio_btn1 = (RadioButton) findViewById(R.id.redio_btn1);
//        redio_btn2 = (RadioButton) findViewById(R.id.redio_btn2);
//        redio_group = (RadioGroup) findViewById(R.id.redio_group);
//
//
//        redio_btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchfragment(mfragment, fragments.get(0));
//            }
//        });
//       redio_btn2.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               switchfragment(mfragment, fragments.get(1));
//           }
//       });
//
//
//
//    }
//
//    private void switchfragment(Fragment now, Fragment next) {
//
//
//        if (next != now) {
//
//            mfragment = next;
//            FragmentTransaction ft = fm.beginTransaction();
//
//            if (next.isAdded()) {
//
//                ft.hide(now).show(next);
//                ft.commitAllowingStateLoss();
//            } else {
//
//                ft.hide(now).add(R.id.frame, next);
//
//            }
//
//        }
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        shouyeFragment =  new ShouyeFragment();
        toutiaoFragment = new ToutiaoFragment();

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.frame, shouyeFragment);
        transaction.add(R.id.frame, toutiaoFragment);
        transaction.hide(toutiaoFragment);
        transaction.commit();

    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        redio_btn1 = (RadioButton) findViewById(R.id.redio_btn1);
        redio_btn2 = (RadioButton) findViewById(R.id.redio_btn2);
        redio_group = (RadioGroup) findViewById(R.id.redio_group);
        redio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (i){
                    case R.id.redio_btn1:
                        transaction.show(shouyeFragment);
                        transaction.hide(toutiaoFragment);
                        break;

                    case  R.id.redio_btn2:
                        transaction.show(toutiaoFragment);
                        transaction.hide(shouyeFragment);
                        break;
                }
                transaction.commit();
            }


        });
       redio_btn1.setChecked(true);
    }


}
