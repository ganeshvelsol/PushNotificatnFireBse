package gif.ganesh.pushnotififirebase.androidMVVMExmples.viewModel;

import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;

import gif.ganesh.pushnotififirebase.androidMVVMExmples.model.RegisterModel;

public class RegisterViewModel extends BaseObservable
{

    RegisterModel rm;

    String success="success";
    String failure="failure";

    public RegisterViewModel()
    {
        rm=new RegisterModel("","");
    }





}
