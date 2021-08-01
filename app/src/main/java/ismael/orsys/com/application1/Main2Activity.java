package ismael.orsys.com.application1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String param1 = intent.getStringExtra("key1");
        Toast.makeText(this, param1, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ico","onDestroy");
    }

    public void onClickButton2(View view){
        Intent intent = new Intent();
        intent.putExtra("key2", "message");
        Main2Activity.this.setResult(1, intent);
        Main2Activity.this.finish();
    }
}
