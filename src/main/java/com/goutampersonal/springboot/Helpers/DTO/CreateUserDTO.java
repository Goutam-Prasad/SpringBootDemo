package com.goutampersonal.springboot.Helpers.DTO;

public class CreateUserDTO {

    String userName;
    String email;

    public String getUserName(){
        return this.userName;
    }

    public String getUserEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }
}
