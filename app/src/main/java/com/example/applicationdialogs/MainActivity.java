package com.example.applicationdialogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MiDialog.NoticeDialogListener {

    private TextView mTextView;
    private Button mButtonStartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtResult);
        mButtonStartDialog = findViewById(R.id.bStartDialog);

        mButtonStartDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new MiDialog();
                newFragment.show(getSupportFragmentManager(), "MiDialog");
            }
        });
    }

    @Override
    public void onGetUser(String user, String password) {
        if(user.equals("Miquel") && password.equals("1234")) {
            mTextView.setText("Login Correcto");
        } else {
            mTextView.setText("El nombre de usuario o la contraseña no son correctos");
        }
    }

    @Override
    public void onCancel() {
        mTextView.setText("Loguéese para entrar");
    }
}