package axell.com.androidcustomdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private Button btnOpenDialog;

    private Dialog customDialog;
    private EditText txtInputName;
    private Button btnInsertName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        initCustomDialog();
        initViewComponents();
    }

    private void initCustomDialog(){
        customDialog = new Dialog(MainActivity.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.custom_dialog);
        customDialog.setCancelable(true);

        txtInputName = customDialog.findViewById(R.id.txtInputName);
        btnInsertName = customDialog.findViewById(R.id.btnInsertName);
        btnInsertName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtInputName.getText().toString();
                txtName.setText(name);
                customDialog.dismiss();
            }
        });
    }

    private void initViewComponents(){
        txtName = findViewById(R.id.txtName);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }
        });
    }
}
