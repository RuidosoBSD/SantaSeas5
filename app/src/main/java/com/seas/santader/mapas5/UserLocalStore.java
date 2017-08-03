package com.seas.santader.mapas5;

        import android.content.Context;
        import android.content.SharedPreferences;

public class UserLocalStore
{
    public static final String SP_User="userDetails";
    SharedPreferences userLocalDatabase;
    public UserLocalStore(Context context)
    {
        userLocalDatabase=context.getSharedPreferences(SP_User,0);
    }
    public void storeUserData(User user)
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putInt("saldo", user.saldo);
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.commit();
    }
    public User getLoggedInUser()
    {
        String name     =userLocalDatabase.getString("name", "");
        int saldo         =userLocalDatabase.getInt("saldo", -1);
        String username =userLocalDatabase.getString("username", "");
        String password =userLocalDatabase.getString("password","");

        User user       =new User(name,saldo,username,password);
        return user;
    }
    public  void setUserLoggedIn(boolean loggedIn)
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }
    public void  clearUserData()
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
    public boolean getUserLoggedIn()
    {
        return userLocalDatabase.getBoolean("loggedIn", false);
    }
}
