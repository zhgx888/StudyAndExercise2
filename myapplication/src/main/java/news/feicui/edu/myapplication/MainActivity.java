package news.feicui.edu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
//        implements Fuzhi.C
{
    TextView t;
    Fuzhi fuzhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("sdfasf","onCreate");
        t = (TextView) findViewById(R.id.s11);
//        Fuzhi.setMc(this);
        fuzhi=new Fuzhi();

        fuzhi.setMc(new Fuzhi.C() {
            @Override
            public void geinic(final int c) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                        Log.i("sdfasf","geinic");
                        t.setText(Integer.toString(c));
//                    }
//                });

            }
        });

//        new Fuzhi.C(){
//            @Override
//            public void geinic(int c) {
//                t.setText(c);
//            }
//        };
    }

    @Override
    protected void onResume() {
        super.onResume();

                Log.i("sdfasf","Runnable");
                fuzhi.a();


    }
    //    @Override
//    public void geinic(int c) {
//        t.setText(c);
//    }

//    @Override
//    public void geinic(int c) {
//        t.setText(c);
//    }
}
