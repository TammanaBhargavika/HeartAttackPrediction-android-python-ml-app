package com.example.heartattackprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;
public class FormPage extends AppCompatActivity {
    EditText etName,etAge,etTrp,etChol,etThalach,etOldPeak;
    RadioGroup rgGender,rgCP,rgFbs,rgECG,rgExang,rgSlope,rgCa,rgThal;
//    String Namestr,Agestr,Trpstr,Cholstr,Thalachstr,Oldpeakstr;

    //defining AwesomeValidation object
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_page);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Assign Edit Text variable
        etName=findViewById(R.id.et_name);
        etAge=findViewById(R.id.et_age);
        etTrp=findViewById(R.id.et_trp);
        etChol=findViewById(R.id.et_chol);
        etThalach=findViewById(R.id.et_thalach);
        etOldPeak=findViewById(R.id.et_oldpeak);

        //Initializing radiresGenerate group variables
        rgGender= (RadioGroup) findViewById(R.id.rg_gender);
        rgCP= (RadioGroup) findViewById(R.id.rg_cp);
        rgFbs= (RadioGroup) findViewById(R.id.rg_fbs);
        rgECG= (RadioGroup) findViewById(R.id.rg_ecg);
        rgExang= (RadioGroup) findViewById(R.id.rg_exang);
        rgSlope= (RadioGroup) findViewById(R.id.rg_slope);
        rgCa= (RadioGroup) findViewById(R.id.rg_ca);
        rgThal= (RadioGroup) findViewById(R.id.rg_thal);
    }

    public void MoveResult(View view) {
        String sname=etName.getText().toString();

        //adding required for radio buttons
        int Gender = rgGender.getCheckedRadioButtonId();
        RadioButton rdGender = findViewById(Gender);

        int ChestPain = rgCP.getCheckedRadioButtonId();
        RadioButton rdCP = findViewById(ChestPain);

        int FBS = rgFbs.getCheckedRadioButtonId();
        RadioButton rdFbs = findViewById(FBS);

        int ECG = rgECG.getCheckedRadioButtonId();
        RadioButton rdECG = findViewById(ECG);

        int Exang = rgExang.getCheckedRadioButtonId();
        RadioButton rdExang = findViewById(Exang);

        int Slope = rgSlope.getCheckedRadioButtonId();
        RadioButton rdSlope = findViewById(Slope);

        int Ca = rgCa.getCheckedRadioButtonId();
        RadioButton rdCa = findViewById(Ca);

        int Thal = rgThal.getCheckedRadioButtonId();
        RadioButton rdThal = findViewById(Thal);

        //adding validation to edittexts

        //Validation for Name
        awesomeValidation.addValidation(this, R.id.et_name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);

        //Validation for Age Attribute
        awesomeValidation.addValidation(this, R.id.et_age, Range.closed(13, 80), R.string.ageerror);

        //Validation for Gender Attribute whether Radio button is selected or not
        if (Gender == -1){
            Toast.makeText(FormPage.this, "Please give Gender", Toast.LENGTH_SHORT).show();
        }else{
            String Genderstr=rdGender.getText().toString();
        }

        //Validation for Chest Pain Attribute whether Radio button is selected or not
        if (ChestPain == -1){
            Toast.makeText(FormPage.this, "Please give Chest Pain", Toast.LENGTH_SHORT).show();
        }else{
            String Cpstr=rdCP.getText().toString();
        }

        //Validation for trp Attribute
        awesomeValidation.addValidation(this, R.id.et_trp, Range.closed(90, 160), R.string.trperror);

        //Validation for Cholestrol Attribute
        awesomeValidation.addValidation(this, R.id.et_chol,Range.closed(120, 600), R.string.cholerror);

        //Validation for FBS Attribute whether Radio button is selected or not
        if (FBS == -1){
            Toast.makeText(FormPage.this, "Please give FBS Value", Toast.LENGTH_SHORT).show();
        }else{
            String Fbsstr=rdFbs.getText().toString();
        }

        //Validation for ECG Attribute whether Radio button is selected or not
        if (ECG == -1){
            Toast.makeText(FormPage.this, "Please give ECG Value", Toast.LENGTH_SHORT).show();
        }else{
            String ECGstr=rdECG.getText().toString();
        }

        //Validation for thalach Attribute
        awesomeValidation.addValidation(this, R.id.et_thalach,Range.closed(60, 220), R.string.thalacherror);

        //Validation for Exang Attribute whether Radio button is selected or not
        if (Exang == -1){
            Toast.makeText(FormPage.this, "Please give Exang Value", Toast.LENGTH_SHORT).show();
        }else{
            String Exangstr=rdExang.getText().toString();
        }

        //Validation for Old Peak Attribute
        awesomeValidation.addValidation(this, R.id.et_oldpeak,Range.closed(13, 60), R.string.OldPeakerror);

        //Validation for Slope Attribute whether Radio button is selected or not
        if (Slope == -1){
            Toast.makeText(FormPage.this, "Please give Slope Value", Toast.LENGTH_SHORT).show();
        }else{
            String Slopestr=rdSlope.getText().toString();
        }

        //Validation for Ca Attribute whether Radio button is selected or not
        if (Ca == -1){
            Toast.makeText(FormPage.this, "Please give Ca Value", Toast.LENGTH_SHORT).show();
        }else{
            String Castr=rdCa.getText().toString();
        }

        //Validation for Thal Attribute whether Radio button is selected or not
        if (Thal == -1){
            Toast.makeText(FormPage.this, "Please give Thal Value", Toast.LENGTH_SHORT).show();
        }else{
            String Thalstr=rdThal.getText().toString();
        }

        //Checking radio attributes checked or not
        if (awesomeValidation.validate()) {
                Intent i=new Intent(FormPage.this,ResPage.class);
                i.putExtra("key",sname);
                startActivity(i);
        }
    }
}