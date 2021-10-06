activity-main.xml
<?xml version="1.0" encoding="utf-8"?> 
<RelativeLayout
	xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:app="http://schemas.android.com/apk/res-auto"
	xmlns:tools="http://schemas.android.com/tools"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	tools:context=".Main_activity"> 

	<EditText
		android:id="@+id/send_text_id"
		android:layout_width="300dp"
		android:layout_height="wrap_content"
		android:textSize="25dp"
		android:hint="Input"
		android:textStyle="bold"
		android:layout_marginTop="20dp"
		android:layout_marginLeft="40dp"/> 
	<Button
		android:id="@+id/send_button_id"
		android:layout_width="wrap_content"
		android:layout_height="40dp"
		android:text="send"
		android:textStyle="bold"
		android:layout_marginTop="150dp"
		android:layout_marginLeft="150dp"/> 

</RelativeLayout>
activity-main2.xml
<?xml version="1.0" encoding="utf-8"?> 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:app="http://schemas.android.com/apk/res-auto"
	xmlns:tools="http://schemas.android.com/tools"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	tools:context="Mainactivity2"> 

	<TextView
		android:id="@+id/received_value_id"
		android:layout_width="300dp"
		android:layout_height="50dp"
		android:textStyle="bold"
		android:textSize="40dp"
		android:layout_marginTop="20dp"
		android:layout_marginLeft="40dp"/> 

</RelativeLayout>

Main-activity.java
import android.content.Intent; 
import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 

public class MainActivity extends AppCompatActivity { 

	Button send_button; 
	EditText send_text; 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{ 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 
		send_button = (Button)findViewById(R.id.send_button_id); 
		send_text = (EditText)findViewById(R.id.send_text_id); 
		send_button.setOnClickListener(new View.OnClickListener() { 
			@Override
			public void onClick(View v) 
			{ 
				String str = send_text.getText().toString(); 

	Intent intent = new Intent(getApplicationContext(), Mainactivity2.class); 
              intent.putExtra("message_key", str);
			startActivity(intent); 
			} 
		}); 
	} 
}
MainActivity2.java

package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView receiver_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        receiver_msg = (TextView)findViewById(R.id.received_value_id);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String str = intent.getStringExtra("message_key");

        // display the string into textView
        receiver_msg.setText(str);
    }
}
