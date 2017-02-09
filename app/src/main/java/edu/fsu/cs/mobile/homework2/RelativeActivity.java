package edu.fsu.cs.mobile.homework2;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeActivity extends AppCompatActivity {

    EditText emp;
    EditText name;
    RadioGroup rg;
    RadioButton rbm;
    RadioButton rbf;
    EditText mail;
    EditText code1;
    EditText code2;
    Spinner dep;
    CheckBox ad;

    TextView empL;
    TextView nameL;
    TextView rgL;
    TextView mailL;
    TextView code1L;
    TextView code2L;
    TextView depL;
    TextView adL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);

        emp = (EditText)findViewById(R.id.emID);
        name = (EditText)findViewById(R.id.name);
        rg = (RadioGroup)findViewById(R.id.rg);
        rbm = (RadioButton)findViewById(R.id.male_button);
        rbf = (RadioButton)findViewById(R.id.female_button);
        mail = (EditText)findViewById(R.id.emailText);
        code1 = (EditText)findViewById(R.id.editText);
        code2 = (EditText)findViewById(R.id.editText2);
        dep = (Spinner)findViewById(R.id.spinner);
        ad = (CheckBox)findViewById(R.id.checkBox);

        empL = (TextView)findViewById(R.id.emIDLabel);
        nameL = (TextView)findViewById(R.id.nameLabel);
        rgL = (TextView)findViewById(R.id.genLabel);
        mailL = (TextView)findViewById(R.id.emailLabel);
        code1L = (TextView)findViewById(R.id.accCode1);
        code2L = (TextView)findViewById(R.id.accCode2);
        depL = (TextView)findViewById(R.id.depLabel);
        adL = (TextView)findViewById(R.id.adLabel);

        empL.setTextColor(Color.BLACK);
        nameL.setTextColor(Color.BLACK);
        rgL.setTextColor(Color.BLACK);
        mailL.setTextColor(Color.BLACK);
        code1L.setTextColor(Color.BLACK);
        code2L.setTextColor(Color.BLACK);
        depL.setTextColor(Color.BLACK);
        adL.setTextColor(Color.BLACK);
    }

    public void resetClick(View view) {
        emp.setText("");
        name.setText("");
        rg.clearCheck();
        mail.setText("");
        code1.setText("");
        code2.setText("");
        dep.setSelection(0);
        ad.setChecked(false);

        setColors();
    }

    public void submitClick(View view) {
        setColors();

        boolean validID = false;

        String ids[] = getResources().getStringArray(R.array.empids);
        String entry = emp.getText().toString();

        for (int i = 0; i < ids.length; i++)
            if (entry.equals(ids[i]))
                validID = true;

        if (!validID)
        {
            empL.setTextColor(Color.RED);
            Toast.makeText(this, "Invalid Employee ID", Toast.LENGTH_SHORT).show();
            return;
        }

        if (name.getText().toString().equals(""))
        {
            nameL.setTextColor(Color.RED);
            Toast.makeText(this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (!rbm.isChecked() && !rbf.isChecked())
        {
            rgL.setTextColor(Color.RED);
            Toast.makeText(this, "Please select a valid gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mail.getText().toString().equals(""))
        {
            mailL.setTextColor(Color.RED);
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!code1.getText().toString().equals(code2.getText().toString()) || code1.getText().toString().equals("")
                || code2.getText().toString().equals(""))
        {
            code1L.setTextColor(Color.RED);
            code2L.setTextColor(Color.RED);
            Toast.makeText(this, "Access codes do not match", Toast.LENGTH_SHORT).show();
            code1.setText("");
            code2.setText("");
            return;
        }
    }

    public void setColors()
    {
        empL.setTextColor(Color.BLACK);
        nameL.setTextColor(Color.BLACK);
        rgL.setTextColor(Color.BLACK);
        mailL.setTextColor(Color.BLACK);
        code1L.setTextColor(Color.BLACK);
        code2L.setTextColor(Color.BLACK);
        depL.setTextColor(Color.BLACK);
        adL.setTextColor(Color.BLACK);
    }

}
