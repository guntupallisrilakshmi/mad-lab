Activity_main.xml:
<?xml version="1.0" encoding="utf-8"?>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".MainActivity" >
    <LinearLayout
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        >


        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Registration From !"
            android:textSize="20dp"
            android:textColor="@color/colorPrimary"
            android:gravity="center"
            />

        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Enter the User name"
            android:layout_margin="1dp"
            android:id="@+id/et_name"/>
        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Enter the Roll number"
            android:layout_margin="1dp"
            android:id="@+id/et_roll"/>
        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:inputType="textEmailAddress"
            android:hint="Enter the User email"
            android:id="@+id/email"/>

        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:inputType="number"
            android:hint="Enter the User mobile number"
            android:id="@+id/et_mobilenumber"/>
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/date"
            android:text="Select Date of birth"/>
        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:inputType="number"
            android:hint="Enter Your Age"
            android:id="@+id/age"/>
        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="1dp"
            android:inputType="text"
            android:hint="Enter Your Address"
            android:id="@+id/address"/>

        <LinearLayout
            android:layout_width="match_parent"
            android:orientation="vertical"
            android:layout_height="wrap_content">
            <RadioGroup
                android:layout_width="wrap_content"
                android:orientation="horizontal"
                android:layout_margin="2dp"
                android:layout_height="wrap_content">
                <RadioButton
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="male"
                    android:layout_margin="10dp"
                    android:id="@+id/male"/>
                <RadioButton
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="female"
                    android:layout_margin="10dp"
                    android:id="@+id/female"/>
            </RadioGroup>

        </LinearLayout>

        <Spinner
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/spinner_states"
            android:entries="@array/states"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="submit"
            android:id="@+id/submit_btn_id"
            android:layout_gravity="center"/>
        <ScrollView
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:id="@+id/tv"
                android:textSize="30sp"
                android:autoLink="all"
                android:layout_margin="1dp"/>
        </ScrollView>

    </LinearLayout>
</layout>

MainActivity.java:


package com.example.registration_form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Calendar;

import com.example.registration_form.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityMainBinding binding;
    String gender;
    String lang;
    Button datepicker;
    int c_year,c_month,c_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);binding= DataBindingUtil.setContentView(this
                ,R.layout.activity_main);
        datepicker=findViewById(R.id.date);
        datepicker.setOnClickListener(this);

        binding.submitBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.male.isChecked()){
                    gender="Male";
                }else {
                    gender="Female";
                }


                binding.tv.setText("name :"+binding.etName.getText().toString()+"\n"+
                        "Number "+binding.etMobilenumber.getText().toString()+"\n"+
                        binding.email.getText().toString()+"\n"+
                        binding.age.getText().toString()+"\n"+binding.address.getText().toString()+"\n"+
                        gender+"\n"+binding.date.getText().toString()+"\n"+
                        binding.spinnerStates.getSelectedItem().toString()+"\n"+lang);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.date:
                openDatepicker();
                break;

    }
}
    private void openDatepicker() {
        Calendar c = Calendar.getInstance();
        c_year = c.get(Calendar.YEAR);
        c_month = c.get(Calendar.MONTH);
        c_date = c.get(Calendar.DAY_OF_MONTH);
        //DatePickerDialog is a class predefined
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String mydate = i + "-" + (i1 + 1) + "-" + i2;
                Toast.makeText(MainActivity.this, mydate, Toast.LENGTH_SHORT).show();
            }
        }, c_year, c_month, c_date);
        datePickerDialog.show();
    }
}

strings.xml:
<resources>
    
    <string-array name="states">

        <item>Andhra Pradesh</item>
        <item>Arunachal Pradesh</item>
        <item>Assam</item>
        <item>Bihar</item>
        <item>Chhattisgarh</item>
        <item>Goa</item>
        <item>Gujarat</item>
        <item>Haryana</item>
        <item>Telangana</item>

    </string-array>
</resources>

Build.gradle(:app):
apply plugin: 'com.android.application'

android {
    compileSdkVersion 30
    buildToolsVersion "30.0.2"

    defaultConfig {
        applicationId "com.example.registration_form"
        minSdkVersion 14
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    dataBinding{
        enabled=true
    }
}

dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar"])
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'

}
