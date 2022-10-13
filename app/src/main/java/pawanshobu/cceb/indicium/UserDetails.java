package pawanshobu.cceb.indicium;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UserDetails extends Activity {

    String name,email,age,sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_userdetails);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/mainfont.ttf");
        TextView t1 = (TextView)findViewById(R.id.textView1);
        t1.setTypeface(custom_font);

        Typeface custom_font2 = Typeface.createFromAsset(getAssets(),  "fonts/font2.ttf");
        TextView t2 = (TextView)findViewById(R.id.textView3);
        //t2.setTypeface(custom_font2);

        Button b1 = (Button)findViewById(R.id.button1);
        //b1.setTypeface(custom_font2);

        //Spinner-Age
        Spinner sage=(Spinner) findViewById(R.id.spinnerage);
        Integer[] age = new Integer[120];
        for(int i=0;i<120;++i)
            age[i]=i+1;
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,R.layout.spinner_item_bold, age);
        sage.setAdapter(adapter);

        //Spinner Sex
        Spinner ssex=(Spinner) findViewById(R.id.spinnersex);
        String[] sex = {"Male","Female"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.spinner_item_bold, sex);
        ssex.setAdapter(adapter2);
    }

    public void tosymp(View v){

        EditText e1 = (EditText)findViewById(R.id.editTextname);
        name = e1.getText().toString();

        EditText e2 = (EditText)findViewById(R.id.editText3);
        email = e2.getText().toString();

        Spinner s = (Spinner)findViewById(R.id.spinnerage);
        age = s.getSelectedItem().toString();

        Spinner s2 = (Spinner)findViewById(R.id.spinnersex);
        sex = s2.getSelectedItem().toString();

        Intent i = new Intent(this,Symptoms.class);
        i.putExtra("name",name);
        i.putExtra("email",email);
        i.putExtra("age",age);
        i.putExtra("sex",sex);
        startActivity(i);
        this.finish();

    }
}
