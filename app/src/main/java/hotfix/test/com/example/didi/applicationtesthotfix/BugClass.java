package hotfix.test.com.example.didi.applicationtesthotfix;


import android.util.Log;

/**
 * Created by didi on 16/7/5.
 */
public class BugClass {

    public BugClass() {
        Log.e("Ruby", Anti.class.getName());
    }

    public void test() {
        Log.e("Ruby", "BugClass.test()");
    }
}
