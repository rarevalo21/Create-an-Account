/******************************************************************************
Programmer: Rafael Arevalo
Date: 10/23/2025
Lab 9 
Instructor: Dr. Rafael Azuaje
College: San Antonio College

*******************************************************************************/

import java.util.Scanner;

public class CreateAccountApp {
    
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String fullName = getFullName();
        System.out.println();
        
        String password = getPassword();
        System.out.println();

        String email = getEmail();
        System.out.println();
        
        String msg = getSuccessMessage(fullName, getPhoneNumber()); 
        System.out.println(msg);

    }
    //method to get valid full name
    private static String getFullName() {
        while(true) {
            System.out.print("Enter full name: ");
            String name = sc.nextLine().trim();
            if(name.contains(" ")) {
                return name;
            } else {
                System.out.println("You must enter your full name.");
            }
        }
    }

    //method to get valid password
    private static String getPassword() {
        while(true) {
            System.out.print("Enter password: ");//
            String password = sc.nextLine().trim(); //.trim() removes beginning and ending spaces
            
            boolean isMinLength = false;
            boolean hasDigit = false;
            boolean hasUppercase = false;           

            if (password.length() >= 8) {
                isMinLength = true;
            }
            
            for (char c: password.toCharArray()) { //convert string to char array
                if (Character.isDigit(c)) { //check if char is digit
                    hasDigit = true; //
                } else if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                }
            }
            
            if (isMinLength && hasDigit && hasUppercase) {
                return password;
            } else {
                System.out.println("Password must be 8 characters or more\n" 
                    + "with at least one digit and one uppercase letter.\n");
            }
        }
    }
    //method to get valid email
    private static String getEmail() {
        while (true) {
            System.out.print("Enter email address. ");

            //.trim() removes beginning and ending spaces
            String email = sc.nextLine().trim();

            Boolean hasAtSymbol = false;
            Boolean hasDotCom = false;

            //check for @ symbol  
            if (email.contains("@")) {
                hasAtSymbol = true;
            }
            //check for .com
            if (email.endsWith(".com")) {
                hasDotCom = true;
            } 
            if (hasAtSymbol && hasDotCom) {
                return email;
            } else {
                System.out.println("Please enter a valid email address.");

            }
        }
    }

    //method to get valid phone number
    private static String getPhoneNumber() {
        while (true) {
            System.out.print("Enter phone number:");
            String phoneNumber = sc.nextLine().trim();
            String digits = phoneNumber.replaceAll("[^\\d]", ""); //remove non-digit characters

            if (digits.length() == 10) { //check for 10 digits
                // "%s" means String format & "." is separator
                return String.format("%s.%s.%s", 
                        //substring to split digits into 3 sections
                        digits.substring(0, 3), 
                        digits.substring(3, 6), 
                        digits.substring(6, 10));
            } else {
                System.out.println("Please enter a valid 10-digit phone number.");
            }
    
        }
    }

    
    private static String getSuccessMessage(String fullName, String phoneNumber) {
        int index = fullName.indexOf(" ");
        String firstName = fullName.substring(0,1).toUpperCase() +  
                           fullName.substring(1, index).toLowerCase();

        return  "\n Hi " + firstName + ", thanks for creating an account." +  " \n We'll text you your confirmation code to this number: " + phoneNumber;
    }
} //main 