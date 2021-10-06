Creating and Using Fragments in Android :
In this example, we are using 2 Fragments in Activity and changing it on Click button.
 Add following Strings in app>res>values> strings.xml, Always recommend to use the standard way of development. It will be easy to change in the future.
strings.xml
strings.xml
<resources>
    <string name="app_name">Fragment</string>
    <string name="frgone">Fragment One</string>
    <string name="frgtwo">Fragment Two</string>
</resources>
Add following Strings in app>res>values>colors.xml
Added new colors bluegray, teal and white.
colors.xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#3F51B5</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="bluegray">#607d8b</color>
    <color name="teal">#009688</color>
    <color name="white">#ffffff</color>
</resources>
Create new fragment layout app>res>layout>”fragment_own.xml”
with <TextView> Widget.
fragment_own.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/teal"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/frgone"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="@color/white" />
</LinearLayout>
Create new fragment layout app>res>layout>”fragment_two.xml”
fragment_two.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/bluegray"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/frgtwo"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="@color/white" />
</LinearLayout>
Add following line in app>res>layout> activity_main.xml
added <FrameLayout> to show fragment dynamically and 2 button for android fragments transaction.
activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="eyehunt.in.fragment.MainActivity">
    <LinearLayout
        android:id="@+id/ll_btn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:weightSum="2">
        <Button
            android:id="@+id/btn_frg_one"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="@string/frgone"/>
        <Button
            android:id="@+id/btn_frg_two"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="@string/frgtwo"/>
    </LinearLayout>
    <FrameLayout
        android:id="@+id/fragment_container"
        android:layout_below="@id/ll_btn"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</RelativeLayout>
 Create new Fragment class app>src>java>”FragmentOne.java”
FragmentOne.java
ppackage eyehunt.in.fragment;
	
	import android.app.Fragment;
	import android.os.Bundle;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	
	public class FragmentOne extends Fragment {
	
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        View view=inflater.inflate(R.layout.fragment_one,container,false);
	        return view;
	    }
	}
FragmentTwo.java

	import android.app.Fragment;
	import android.os.Bundle;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	
	public class FragmentTwo extends Fragment {
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        View view=inflater.inflate(R.layout.fragment_two,container,false);
	        return view;
	    }
	}
MainActivity.java

import               android.app.FragmentManager;
	import android.app.FragmentTransaction;
	import android.support.v7.app.AppCompatActivity;
	import android.os.Bundle;
	import android.view.View;
	import android.widget.Button;
	
	public class MainActivity extends AppCompatActivity {
	
	    Button btn_frg_one,btn_frg_tow;
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	
	        FragmentOne fragmentOne = new FragmentOne();
	        FragmentManager fragmentManager = getFragmentManager();
	        FragmentTransaction transaction = fragmentManager.beginTransaction();
	        transaction.add(R.id.fragment_container, fragmentOne);
	        transaction.commit();
	
	        btn_frg_one=(Button)findViewById(R.id.btn_frg_one);
	        btn_frg_one.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                FragmentOne fragmentOne = new FragmentOne();
	                FragmentManager fragmentManager = getFragmentManager();
	                FragmentTransaction transaction = fragmentManager.beginTransaction();
	                transaction.replace(R.id.fragment_container, fragmentOne);
	                transaction.commit();
	            }
	        });
	
	        btn_frg_tow=(Button)findViewById(R.id.btn_frg_two);
	        btn_frg_tow.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                FragmentTwo fragmentTwo = new FragmentTwo();
	                FragmentManager fragmentManager = getFragmentManager();
	                FragmentTransaction transaction = fragmentManager.beginTransaction();
	                transaction.replace(R.id.fragment_container, fragmentTwo);
	                transaction.commit();
	            }
	        });
	    }
Android Fragments dynamically Output Screen shot :
 
 

