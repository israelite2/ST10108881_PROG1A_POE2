/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package st10108881.st10108881_poe2;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Login {
    private static String username1;
    private static String password1;
    private String firstName;
    private String lastName;
    
    
    // checks if the username is correctly formatted
    public Boolean checkUserName() {
        
        return username1.contains("_") && username1.length() <= 5;
    }

    // checks if the password meets the complexity rules
    public Boolean checkPasswordComplexity() {
        String upCase = "(.*[0-9].*)";
        String spclChar = "(.*[!,@,#,$,%,^,&,*].*$)";
        return password1.matches(upCase) && password1.matches(spclChar) && password1.length() >= 8;
    }

    // returns a string message indicating the result of the registration
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        
        return "Username successfully captured";
    }

    // checks if the login details match those stored during registration
    public Boolean loginUser(String username2, String password2) {
        return this.username1.equals(username2) && this.password1.equals(password2);
    }

    // returns a string message indicating the result of the login
    public String returnLoginStatus(String username2, String password2) {
        if (loginUser(username2, password2)) {
            return "Welcome " + this.firstName + " " + this.lastName + ", it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
    
    public static boolean login(String username2, String password2) {
        // check if username and password are correct
        // return true if successful, false otherwise

        return password2.equals(password1) && username2.equals(username1);
    }

    public String getUsername() {
        return username1;
    }

    public void setUsername(String username) {
        this.username1 = username;
    }

    public String getPassword() {
        return password1;
    }

    public void setPassword(String password) {
        this.password1 = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}