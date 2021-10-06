1.	<RelativeLayout xmlns:androclass="http://schemas.android.com/apk/res/android"  
2.	    xmlns:tools="http://schemas.android.com/tools"  
3.	    android:layout_width="match_parent"  
4.	    android:layout_height="match_parent"  
5.	    tools:context=".MainActivity" >  
  <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content" 
  
                android:layout_height="wrap_content" 
  
                android:layout_marginLeft="8dp" 
  
        android:layout_marginRight="8dp" 
  
        android:layout_marginTop="65dp" 
  
        android:hint="Phone No." 
  
       
        android:inputType="phone" 
  
        app:layout_constraintHorizontal_bias="0.503" 
        app:layout_constraintLeft_toLeftOf="parent" 
        app:layout_constraintRight_toRightOf="parent" 
        app:layout_constraintTop_toTopOf="parent" /> 
  
    <Button
        android:id="@+id/button"
  
        
        android:layout_width="wrap_content" 
  
        
        android:layout_height="wrap_content" 
  
        android:layout_marginLeft="8dp" 
        android:layout_marginRight="8dp" 
        android:layout_marginTop="67dp" 
  
        android:onClick="Call" 
  
        android:text="DIAL" 
  
        
        app:layout_constraintLeft_toLeftOf="parent" 
        app:layout_constraintRight_toRightOf="parent" 
        app:layout_constraintTop_toBottomOf="@+id/editText" 
    /> 
6.	
7.	    <EditText  
8.	        android:id="@+id/editText1"  
9.	        android:layout_width="wrap_content"  
10.	        android:layout_height="wrap_content"  
11.	        android:layout_alignParentRight="true"  
12.	        android:layout_alignParentTop="true"  
13.	        android:layout_marginRight="20dp"  
14.	        android:ems="10" />  
15.	  
16.	    <EditText  
17.	        android:id="@+id/editText2"  
18.	        android:layout_width="wrap_content"  
19.	        android:layout_height="wrap_content"  
20.	        android:layout_alignLeft="@+id/editText1"  
21.	        android:layout_below="@+id/editText1"  
22.	        android:layout_marginTop="26dp"  
23.	        android:ems="10"  
24.	        android:inputType="textMultiLine" />  
<EditText
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        android:id="@+id/et_url_input"
	        android:hint="Enter the Url"
	        android:layout_margin="10dp"/>
25.	
26.	  
27.	    <TextView  
28.	        android:id="@+id/textView1"  
29.	        android:layout_width="wrap_content"  
30.	        android:layout_height="wrap_content"  
31.	        android:layout_alignBaseline="@+id/editText1"  
32.	        android:layout_alignBottom="@+id/editText1"  
33.	        android:layout_toLeftOf="@+id/editText1"  
34.	        android:text="Mobile No:" />  
35.	  
36.	    <TextView  
37.	        android:id="@+id/textView2"  
38.	        android:layout_width="wrap_content"  
39.	        android:layout_height="wrap_content"  
40.	        android:layout_alignBaseline="@+id/editText2"  
41.	        android:layout_alignBottom="@+id/editText2"  
42.	        android:layout_alignLeft="@+id/textView1"  
43.	        android:text="Message:" />  
44.	  
45.	    <Button  
46.	        android:id="@+id/button1"  
47.	        android:layout_width="wrap_content"  
48.	        android:layout_height="wrap_content"  
49.	        android:layout_alignLeft="@+id/editText2"  
50.	        android:layout_below="@+id/editText2"  
51.	        android:layout_marginLeft="34dp"  
52.	        android:layout_marginTop="48dp"  
53.	        android:text="Send SMS" />  
<Button
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        android:text="Open Web"
	        android:layout_margin="10dp"
	        android:onClick="showWebPage"/>
54.	
55.	  
56.	</RelativeLayout>  
 Android-Manifest.xml
1.	<?xml version="1.0" encoding="utf-8"?>  
2.	<manifest   
3.	xmlns:androclass="http://schemas.android.com/apk/res/android"  
4.	    package="com.example.sendsms"  
5.	    android:versionCode="1"  
6.	    android:versionName="1.0" >  
7.	  
8.	    <uses-sdk  
9.	        android:minSdkVersion="8"  
10.	        android:targetSdkVersion="16" />  
11.	  
12.	    <uses-permission android:name="android.permission.SEND_SMS"/>  
13.	    
14.	    <uses-permission android:name="android.permission.RECEIVE_SMS"/>  
<uses-permission android:name="android.permission.CALL_PHONE"/>
15.	
16.	    <application  
17.	        android:allowBackup="true"  
18.	        android:icon="@drawable/ic_launcher"  
19.	        android:label="@string/app_name"  
20.	        android:theme="@style/AppTheme" >  
21.	        <activity  
22.	            android:name="com.example.sendsms.MainActivity"  
23.	            android:label="@string/app_name" >  
24.	            <intent-filter>  
25.	                <action android:name="android.intent.action.MAIN" />  
26.	  
27.	                <category android:name="android.intent.category.LAUNCHER" />  
28.	            </intent-filter>  
29.	        </activity>  
30.	    </application>  
31.	  
32.	</manifest>  
MainActivity.java
1.	package com.example.sendsms;  
2.	  
3.	import android.os.Bundle;  
4.	import android.app.Activity;  
5.	import android.app.PendingIntent;  
6.	import android.content.Intent;  
7.	import android.telephony.SmsManager;  
8.	import android.view.Menu;  
9.	import android.view.View;  
10.	import android.view.View.OnClickListener;  
11.	import android.widget.Button;  
12.	import android.widget.EditText;  
13.	import android.widget.Toast;  
14.	  
15.	public class MainActivity extends Activity {  
16.	  
17.	    EditText mobileno,message;  
18.	    Button sendsms;  EditText mEditText;
19.	    @Override  
20.	    protected void onCreate(Bundle savedInstanceState) {  
21.	        super.onCreate(savedInstanceState);  
22.	        setContentView(R.layout.activity_main);  
23.	          
24.	        mobileno=(EditText)findViewById(R.id.editText1);  
25.	        message=(EditText)findViewById(R.id.editText2);  
26.	        sendsms=(Button)findViewById(R.id.button1); 
27.	mEditText=findViewById(R.id.et_url_input);
28.	 
29.	          
30.	    //Performing action on button click  
public void showWebPage(Viewview) {
	String myUrl= mEditText.getText().toString();
	        Uri uri=Uri.parse("https://www."+myUrl+".in");
	        Intent i=new Intent(Intent.ACTION_VIEW,uri);
	        startActivity(i);
	
	    }
31.	
32.	        sendsms.setOnClickListener(new OnClickListener() {  
33.	              
34.	            @Override  
35.	            public void onClick(View arg0) {  
36.	                String no=mobileno.getText().toString();  
37.	                String msg=message.getText().toString();  
38.	                  
39.	                //Getting intent and PendingIntent instance  
40.	                Intent intent=new Intent(getApplicationContext(),MainActivity.class);  
41.	                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);  
42.	                  
43.	                //Get the SmsManager instance and call the sendTextMessage method to send message  
44.	                SmsManager sms=SmsManager.getDefault();  
45.	                sms.sendTextMessage(no, null, msg, pi,null);  
46.	                  
47.	                Toast.makeText(getApplicationContext(), "Message Sent successfully!",  
48.	                    Toast.LENGTH_LONG).show();  
49.	            }  
50.	        });  
51.	    }  
52.	  
53.	    @Override  
54.	    public boolean onCreateOptionsMenu(Menu menu) {  
55.	        // Inflate the menu; this adds items to the action bar if it is present.  
56.	        getMenuInflater().inflate(R.menu.activity_main, menu);  
57.	        return true;  
58.	    }  
59.	      
60.	public  void Call(View v) 
61.	    { 
62.	EditText e = (EditText)findViewById(R.id.editText); 
63.	  
64.	        Toast.makeText(this, "clicked", Toast.LENGTH_LONG) 
65.	             .show(); 
66.	  
67.	        Uri u = Uri.parse("tel:" + e.getText().toString()); 
68.	  
69.	        Intent i = new Intent(Intent.ACTION_DIAL, u); 
70.	  
71.	        try
72.	        { 
73.	            startActivity(i);  
74.	        } 
75.	        catch (SecurityException s) 
76.	        { 
77.	             
78.	            Toast.makeText(this, "An error occurred", Toast.LENGTH_LONG) 
79.	                 .show(); 
80.	        } 
81.	    } 
82.	} 
83.	


