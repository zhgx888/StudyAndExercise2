package news.feicui.edu.myapplication;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class Fuzhi {
     int a=1;
     int b=2;
     int c;
    static C mc;
    public void a() {

//        try {
//            Thread.sleep(5000);
//            Log.i("sd@@sf","a()");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        c=a+b;//任务进行
        mc.geinic(c);//任务进行完\
    }

    static public void setMc(C mcc) {
        mc = mcc;
    }

    public interface C{
       void geinic(int c);
    }
}
