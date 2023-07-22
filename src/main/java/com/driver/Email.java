package com.driver;
import java.io.*;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(newPassword==oldPassword && otherConditions(newPassword)==true && newPassword.length()>=8){
                password = newPassword;
            }
    }

    private boolean otherConditions(String newPassword){
        int countUpper = 0;
        int countLower = 0;
        int countDigit =0;
        int countSpecial= 0;
        for(int i=0; i<newPassword.length(); i++){
            char ch = newPassword.charAt(i);
            if(Character.isLetter(ch)==true){
                if(Character.isUpperCase(ch)){
                    countUpper+=1;
                }else{
                    countLower+=1;
                }
            }else if(Character.isDigit(ch)){
                countDigit++;
            }else if(!Character.isWhitespace(ch)){
                countSpecial++;
            }
        }

        if(countUpper>0&&countLower>0&&countSpecial>0&&countDigit>0){
            return true;
        }

        return false;
    }

}
