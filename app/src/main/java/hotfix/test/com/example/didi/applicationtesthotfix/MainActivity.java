package hotfix.test.com.example.didi.applicationtesthotfix;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;




public class MainActivity extends Activity {
    MainActivity(){
        Log.e("Ruby", Anti.class.getName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BugClass().test();
            }
        });
    }
}
