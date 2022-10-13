package pawanshobu.cceb.indicium;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/mainfont.ttf");
        TextView t1 = (TextView)findViewById(R.id.textView1);
        t1.setTypeface(custom_font);

        Typeface custom_font2 = Typeface.createFromAsset(getAssets(),  "fonts/font2.ttf");
        TextView t2 = (TextView)findViewById(R.id.textView3);
        //t2.setTypeface(custom_font2);

        Button b1 = (Button)findViewById(R.id.button1);
        //b1.setTypeface(custom_font2);
    }

    public void touserdetails(View v){

        CheckBox c = (CheckBox)findViewById(R.id.checkBox1);
        if(c.isChecked()==true) {
            Intent i = new Intent(this, UserDetails.class);
            startActivity(i);
            this.finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Please select the checkbox",Toast.LENGTH_SHORT).show();
        }
    }
}
