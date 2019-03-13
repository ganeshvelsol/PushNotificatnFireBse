package gif.ganesh.pushnotififirebase.androidMVVMExmples.model;

import android.databinding.BaseObservable;
import android.text.TextUtils;

public class RegisterModel extends BaseObservable
{
    public String name,mobile;

    public RegisterModel() {
    }

    public RegisterModel(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public boolean isValidData()
    {
        return !TextUtils.isEmpty(getName())&& getName().length()>11;
    }
}
