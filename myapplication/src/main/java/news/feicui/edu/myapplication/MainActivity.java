package news.feicui.edu.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import news.feicui.edu.myapplication.XListView.XListView;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener
//        implements Fuzhi.C
{
    private XListView mListView;
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> items = new ArrayList<String>();
    private Handler mHandler;
    private int start = 0;
    private static int refreshCnt = 0;
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
        geneItems();
        mListView = (XListView) findViewById(R.id.xLv_header);
        mListView.setPullLoadEnable(true);
        mAdapter = new ArrayAdapter<String>(this, R.layout.list_item, items);
        mListView.setAdapter(mAdapter);
//		mListView.setPullLoadEnable(false);
//		mListView.setPullRefreshEnable(false);
        mListView.setXListViewListener(this);
        mHandler = new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();

                Log.i("sdfasf","Runnable");
                fuzhi.a();


    }

    private void geneItems() {
        for (int i = 0; i != 20; ++i) {
            items.add("refresh cnt " + (++start));
        }
    }

    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime("刚刚");
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start = ++refreshCnt;
                items.clear();
                geneItems();
                // mAdapter.notifyDataSetChanged();
                mAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.list_item, items);
                mListView.setAdapter(mAdapter);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geneItems();
                mAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
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
