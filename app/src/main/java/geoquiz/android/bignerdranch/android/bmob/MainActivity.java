package geoquiz.android.bignerdranch.android.bmob;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb_check;
    private EditText mName;
    private EditText mPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "c22f7d5f3cf16e33db01670599e9487c");
        //[1]找到我们关心的控件
        mName = (EditText) findViewById(R.id.et_username);
        mPassword = ((EditText) findViewById(R.id.et_userpassword));
        cb_check = ((CheckBox) findViewById(R.id.cb_check));
        //提交数据
        InputMethodManager inputMethodManager =(InputMethodManager)MainActivity.this.getApplicationContext().
                getSystemService(Context.INPUT_METHOD_SERVICE);

        EditText editText = (EditText)findViewById(R.id.et_userpassword);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void login(View v) {
        String name = mName.getText().toString().trim();
        String pasw = mPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pasw)) {
            Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.text_7), Toast.LENGTH_SHORT).show();
        } else {
            //[2.4]如果密码不为空，进行登录的逻辑
            if (cb_check.isChecked()) {
                Person personObj = new Person();    //实例化实体类
                personObj.setName(name);  //封装数据
                personObj.setPassword(pasw);
                personObj.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId, BmobException e) {
                        if (e == null) {
                            Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.text_5) , Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.text_6) , Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            } else {
                Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.text_8), Toast.LENGTH_SHORT).show();
            }
        }

    }


}



