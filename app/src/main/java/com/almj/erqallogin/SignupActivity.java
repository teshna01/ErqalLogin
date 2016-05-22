package com.almj.erqallogin;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @Bind(R.id.input_phone) EditText _phoneText;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.input_password_again) EditText _rePasswordText;
    @Bind(R.id.input_code) EditText _testCode;
    @Bind(R.id.btn_code) Button _getTestCode;
    @Bind(R.id.btn_signup) Button _signupButton;
    @Bind(R.id.link_login) TextView _loginLink;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("تىزىملىتىۋاتىدۇ...");
        progressDialog.show();

        String phoneNum = _phoneText.getText().toString();
        String Password = _passwordText.getText().toString();
        String rePassword=_rePasswordText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "تىزىملىتىش مەغلۇب بولدى", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String phoneNum = _phoneText.getText().toString();
        String password = _passwordText.getText().toString();
        String rePassword = _rePasswordText.getText().toString();
        String testCode=_testCode.getText().toString();

        if (phoneNum.isEmpty() || phoneNum.length() < 11) {
            _phoneText.setError("توغرا يانفۇن نومۇرىنى تولدۇرۇڭ");
            valid = false;
        } else {
            _phoneText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("4 تىن 10 غىچە بەلگىدىن تۈزۈلگەن پارول تولدۇرۇڭ");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (rePassword.isEmpty() || rePassword.length() < 4 || rePassword.length() > 10) {
            _rePasswordText.setError("4 تىن 10 غىچە بەلگىدىن تۈزۈلگەن پارول تولدۇرۇڭ");
            valid = false;
        } else {
            if(!password.equals(rePassword)){
                _rePasswordText.setError("ئىككى پارول بىردەك ئەمەس");
                valid = false;
            }else{
                _rePasswordText.setError(null);
            }

        }
        if(testCode.isEmpty()){
            _testCode.setError("تەستىق نومۇرنى كىرگۈزۈڭ");
            valid=false;
        }else{
          _testCode.setError(null);
        }

        return valid;
    }
}