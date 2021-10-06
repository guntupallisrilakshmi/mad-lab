activity_main.xml (or) main.xml and add following code :

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >
    
<TextView
        android:id="@+id/textView1"
        android:textSize="20dp"
        android:textColor="#FF0000"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="110dp"
        android:text="Static ImageView" />
 
    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true"
        android:src="@drawable/gkbs_logo" />
 
    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="80dp"
        android:text="Change" />
 
    <EditText
        android:id="@+id/editText1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="105dp"
        android:ems="10" >
<ImageButton
        android:id="@+id/imageButton1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:src="@drawable/gkbs_logo" />

 
        <requestFocus />
    </EditText>
 
    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:text="Proceed" />
 
</RelativeLayout>
Open src -> package -> MainActivity.java and add following code :

package balaji.edittext_static;
 
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

 
public class MainActivity extends Activity {
 
	Button b; ImageButton imgbutton;

	EditText et1;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b = (Button) findViewById(R.id.button1);
        et1 = (EditText) findViewById(R.id.editText1);
        
        b.setOnClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getBaseContext(), et1.getText().toString(),
				Toast.LENGTH_SHORT).show();
		}
	});
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
imgbutton  = (ImageButton) findViewById(R.id.imageButton1);
        
        imgbutton.setOnClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			imgbutton.setImageResource(R.drawable.gkbs_logo_red);
			Toast.makeText(getBaseContext(), "ImageButton Clicked",
				Toast.LENGTH_SHORT).show();
		}
	});
        
        imgbutton.setOnLongClickListener(new View.OnLongClickListener() {
			
		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
				
			imgbutton.setImageResource(R.drawable.gkbs_logo_megenta);
			Toast.makeText(getBaseContext(), "ImageButton Long Clicked",
				Toast.LENGTH_SHORT).show();
			
			return true;
		}
	});
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

}
Open res ->values ->strings.xml and add following code :

<resources>
 
    <string name="app_name">EditText_Static</string>
    <string name="hello_world">Hello world!</string>
    <string name="menu_settings">Settings</string>
    <string name="title_activity_main">MainActivity</string>
 
</resources
