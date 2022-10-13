package pawanshobu.cceb.indicium;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends Activity {

    String diag="Achilles tendon rupture;(heel tendon tear)\nBaker's cyst;fluid sac behind knee\nContusion;bruise\necchymosis\nDeep venous thrombosis DVT; venous blood clot\nDislocation;joint out of place\nGout\nMuscle strain";
    String symp;
    String name,email,age,sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_result);

        Intent intent = getIntent();
        symp = intent.getExtras().getString("symptoms");
        name = intent.getExtras().getString("name");
        email = intent.getExtras().getString("email");
        age = intent.getExtras().getString("age");
        sex = intent.getExtras().getString("sex");

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/mainfont.ttf");
        TextView t1 = (TextView)findViewById(R.id.textView1);
        t1.setTypeface(custom_font);

        Typeface custom_font2 = Typeface.createFromAsset(getAssets(),  "fonts/font2.ttf");
        TextView t2 = (TextView)findViewById(R.id.textView3);
        //t2.setTypeface(custom_font2);

        EditText e1 = (EditText)findViewById(R.id.editTextname);
        e1.setText(name);
        e1.setEnabled(false);

        EditText e2 = (EditText)findViewById(R.id.editTextage);
        e2.setText(age);
        e2.setEnabled(false);

        EditText e3 = (EditText)findViewById(R.id.editTextsex);
        e3.setText(sex);
        e3.setEnabled(false);

        EditText d =(EditText)findViewById(R.id.disp);
        d.setText("Diagnosis:\n"+diag);


        Button b1 = (Button)findViewById(R.id.button1);
    }

    public void openurl(View v){

        String u = "https://www.webmd.com/drugs/2/search?type=drugs&query=";

        Uri uri = Uri.parse(u+"muscle pull"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void fin(View v){
        CheckBox c = (CheckBox)findViewById(R.id.checkBox);
        if(c.isChecked()==true) {
            String msg = "Name: " + name + "\n" + "Age: " + age + "\tSex: " + sex + "\nDiagnosis=\n" + diag;
            try {
                GMailSender sender = new GMailSender("indiciumhealth@gmail.com", "MADlabviva123");
                sender.sendMail("INDICIUM Report",
                        msg,
                        "indiciumhealth@gmail.com",
                        email);
                Toast.makeText(getApplicationContext(), "Email Sent! Goodbye", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), email+"*\n"+msg, Toast.LENGTH_SHORT).show();

                this.finish();


            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
                Toast.makeText(getApplicationContext(), "Error Sending Email!", Toast.LENGTH_SHORT).show();

            }
        }
        else {
            Toast.makeText(getApplicationContext(), "GoodBye!", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }
}
