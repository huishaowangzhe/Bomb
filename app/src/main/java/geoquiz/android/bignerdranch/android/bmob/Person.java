package geoquiz.android.bignerdranch.android.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by asus on 2018/4/17.
 */

public class Person extends BmobObject {
        private String name;
        private String password;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
