import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
	Button loginBtn;
	Intent intent;
	EditText name, pwd;
	SharedPreferences pref;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitymain);
		loginBtn = findViewById(R.id.btnLogin);
		intent = new Intent(MainActivity.this, DetailsActivity.class)
		name = findViewById(R.id.txtName);
		pwd = findViewById(R.id.txtPwd);
		pref = getSharedPreferences("user_details", MODEE_PRIVATE);
		if(pref.contains("username") && pref.contains("password"))
			startActivity(intent);
		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String username = name.getText().toString();
				String password = name.getText().toString();
				if(username.equals("Likitha") && password.equals("Gudiboina")) {
					SharedPreferences.Editor e = pref.edit();
					e.putString("username", username);
					e.putString("password", password);
					e.commit();
					Toast.makeText(getApplicationContent(), "Welcome!!!, Login Successful:-)", Toast.LENGTH_SHORT).show();
					startActivity(intent); 
				} else {	
					Toast.makeText(getApplicationContent(), "Login Failed..!!", Toast.LENGTH_SHORT).show();
				}
			}
`		});
	}
}  
