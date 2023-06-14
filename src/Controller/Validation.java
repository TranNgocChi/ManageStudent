
package Controller;

import Model.Address;
import Model.Student;
import java.util.ArrayList;
import java.util.Scanner;


public class Validation {
    Scanner sc = new Scanner(System.in);
  
//    ----------------------------------------
    
    public int inputInt(String message, int min, int max) {
        System.out.print(message);
        while(true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }
//    -------------------------------------------------------
    public int inputn(String message) {
    System.out.print(message);
        while(true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            }
            catch (NumberFormatException e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }
    //    -------------------------------------------------------
    public int inputID(String message, ArrayList<Student> students) {
        System.out.print(message);
        int a=0;
        while(true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                for(Student student: students){
                    if (student.getId() == number){
                        number = a;
                    }
                }
                if(number == a){
                    System.err.println("Please input the different integer");
                    continue;
                }
                return number;
            }
            catch (NumberFormatException e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }
//    -----------------------------------------------------
    public String inputString(String message, String regex){
        System.out.println(message);
        while(true){
            String input = sc.nextLine();
            if(!input.matches(regex)){
                System.out.println("Please input match regex (" + regex + "). ");
                continue;
            }
            return input;
        }
    }
//    --------------------------------------------------------
    public String checkNumberOfDaNang(String message, ArrayList<Student> students, Address adr){
        int countDN = 0;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getAddress().getCity().equals("Da Nang")){
                countDN++;
            }
        }     
        System.out.println(message);
        while(true){
            String input = sc.nextLine();  
            if (input.equals("Da Nang")) { 
                if (countDN >= 6) {
                    System.err.println("There are only 6 students in Da Nang. Please input the different city!");
                    continue;
                } else {
                    countDN++;
                }
            }
            return input;
        }
    }
//----------------------------------------------------------------------------
    public double inputDouble(String message, double min, double max){
        System.out.println(message);
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an double number: ");
            }
        }
    }
//    ------------------------------------------------------------------------
}
