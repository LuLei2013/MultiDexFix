package hotfix.test.com.example.didi.applicationtesthotfix;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.io.File;

/**
 * Created by didi on 16/7/4.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        File dexPath = new File(getDir("dex", Context.MODE_PRIVATE), "anti_dex.jar");
        Utils.prepareDex(this.getApplicationContext(), dexPath, "anti_dex.jar");
        HotFix.patch(this, dexPath.getAbsolutePath(), "hotfix.test.com.example.didi.applicationtesthotfix.Anti");
        dexPath = new File(getDir("dex", Context.MODE_PRIVATE), "bug_dex.jar");
        Utils.prepareDex(getApplicationContext(), dexPath, "bug_dex.jar");
        HotFix.patch(getApplicationContext(), dexPath.getAbsolutePath(), "hotfix.test.com.example.didi.applicationtesthotfix.BugClass");

        try {
            Class<?> clazz = Class.forName("hotfix.test.com.example.didi.applicationtesthotfix.Anti");
            equalLoader(clazz);
            Log.e("Ruby", "Anti 's classloader' hashCode " + clazz.getClassLoader().hashCode() + "  , " + clazz.getClassLoader().getClass().getName());
            Class<?> cla = Class.forName("hotfix.test.com.example.didi.applicationtesthotfix.BugClass");
            equalLoader(cla);
            Log.e("Ruby", "BugClass 's classloader' hashCode " + cla.getClassLoader().hashCode() + "  , " + cla.getClassLoader().getClass().getName());
        } catch (Exception e) {
        }
    }

    void equalLoader(Class<?> cla) {
        ClassLoader classLoader = cla.getClassLoader();
        if (classLoader == HotFix.first) {
            Log.e("Ruby", cla.getName() + " ' " + "classLoader ==first");
        } else if (classLoader == HotFix.second) {
            Log.e("Ruby", cla.getName() + " ' " + "classLoader ==second");
        } else if (classLoader == HotFix.path) {
            Log.e("Ruby", cla.getName() + " ' " + "classLoader ==path");
        }

    }
}
