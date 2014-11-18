package cn.edu.gdmec.simplepreferencedemo;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	TextView mytv1,mytv1mytv3;
	EditText etName,etAge,etHeight;
	public static final String PREFERENCE_NAME="SaveSetting";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etName = (EditText) findViewById(R.id.editText1);
		etAge = (EditText) findViewById(R.id.editText2);
		etHeight = (EditText) findViewById(R.id.editText3);
		
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void Read(View v){
		SharedPreferences myPre = getSharedPreferences(PREFERENCE_NAME, Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
		String name = myPre.getString("name", "MA");
		int age = myPre.getInt("age", 18);
		float height = myPre.getFloat("height", 1.6f);
		etName.setText(name);
		etAge.setText(String.valueOf(age));
		etHeight.setText(String.valueOf(height));
	}
	public void Write(View v){
		SharedPreferences myPre = getSharedPreferences(PREFERENCE_NAME, Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
		SharedPreferences.Editor myEditor = myPre.edit();
		myEditor.putString("name", etName.getText().toString());
		myEditor.putInt("age", Integer.parseInt(etAge.getText().toString()));
		myEditor.putFloat("height", Float.parseFloat(etHeight.getText().toString()));
		myEditor.commit();
		
		
	}
	
	
	
}
