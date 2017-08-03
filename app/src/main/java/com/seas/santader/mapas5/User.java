package com.seas.santader.mapas5;
public class User
{
    String name,username,password;
    int saldo;

    public User(String name,int saldo,String username,String password)
    {
        this.name=name;
        this.saldo=saldo;
        this.username=username;
        this.password=password;

    }
    public User(String username,String password)
    {
        this.name="";
        this.saldo=-1;
        this.username=username;
        this.password=password;
    }
}
