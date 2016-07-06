package hotfix.test.com.example.didi.applicationtesthotfix;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;




public class MainActivity extends Activity {

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
