package ismael.orsys.com.application1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("ico","onCreate");

        final TextView tv1 = (TextView) findViewById(R.id.textView1);

        /*Button b1 = (Button) findViewById(R.id.button1) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("coucou");
            }
        });*/
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        // ... dispose
        Log.v("ico","onLowMemory");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 ) {
            String param = data.getStringExtra("key2");
            Toast.makeText(this, param, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.v("ico","onTouch");
        return false;
    }

    public void onClickButton1(View view){
        Log.v("ico","eventClick");

        TextView tv = (TextView) view.findViewById(R.id.button1);
        tv.setText("coucou 2222222");

        /**
        String url = "http://www.ismael-coulibaly.com";

        String map1 = "geo:48.49,2.23";
        String map2 = "geo:0,0?q=18+boulevard+albert+einstein+Nantes+France";

        String tel = "tel:0666666666";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel));

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException exc) {
            Log.w("ico", "warning - Google Map not found");
        }
         **/

        Intent intent = new Intent (MainActivity.this, Main2Activity.class);
        intent.putExtra("key1", "wazaaa");
        //startActivity(intent);
        startActivityForResult(intent, 0); // 0 est le request code
    }

}
