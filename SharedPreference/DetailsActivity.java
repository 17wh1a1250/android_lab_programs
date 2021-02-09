import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydetails);
        TextView result = findViewById(R.id.resultView);
        Button logoutBtn = findViewById(R.id.btnLogOut);
        SharedPreferences pref = getSharedPreferences("user_details",MODE_PRIVATE);
        Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
        result.setText("Hello, "+pref.getString("username",null));
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor e = pref.edit();
                e.clear();
                e.commit();
                startActivity(intent);
            }
        });
    }
}
