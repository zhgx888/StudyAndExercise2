package news.feicui.edu.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyFragmentActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3;
    BlankFragment1 bf1;
    BlankFragment2 bf2;
    BlankFragment3 bf3;
    ListFragments lf;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        btn1 = (Button) findViewById(R.id.btn_Fragment1);
        btn2 = (Button) findViewById(R.id.btn_Fragment2);
        btn3 = (Button) findViewById(R.id.btn_Fragment3);
        bf1=new BlankFragment1();
        bf2 = new BlankFragment2();
        bf3 = new BlankFragment3();
        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().hide(bf1).commit();
//        getSupportFragmentManager().beginTransaction().add(R.id.fragment, bf2).commit();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Fragment1:
                fragmentManager.beginTransaction().show(bf1).commit();
                fragmentManager.beginTransaction().replace(R.id.fragment_blank,bf1).commit();
                break;
            case R.id.btn_Fragment2:
//                fragmentManager.beginTransaction().hide(bf1).commit();
                fragmentManager.beginTransaction().replace(R.id.fragment_blank, bf2).commit();
                break;
            case R.id.btn_Fragment3:
                lf = new ListFragments();
//                fragmentManager.beginTransaction().hide(bf2).commit();
                fragmentManager.beginTransaction().replace(R.id.fragment_blank, bf3).commit();
                break;
        }
    }
}
