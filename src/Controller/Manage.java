
package Controller;

import Model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

    
public class Manage{
    Validation valid= new Validation();
    ArrayList<Student> students = new ArrayList<Student>();
    Address adr = new Address();
    
    Scanner sc = new Scanner(System.in);
    
    public Manage() {        
        
        students.add(new ITstudent(1, "Gau Gau", new Address("VN","Da Nang","Ngu Hanh Son","12"), 8.2, 7.2));   
        students.add(new ITstudent(2, "Cap Cap", new Address("VN","HCM","Cam Le","14"), 7, 5)); 
        students.add(new ITstudent(3, "Um Bo", new Address("VN","Da Nang","Thanh Khe","10"), 1, 7.7)); 
        students.add(new ITstudent(4, "Gao Uom", new Address("VN","Da Nang","QUan 1","12"), 8.6, 7)); 
        students.add(new ITstudent(5, "Ộp Ộp", new Address("VN","HN","Quan 5","12"),2, 5)); 
        
        students.add(new BizStudent(6, "Cristiano", new Address("VN","Da Nang","Ngu Hanh Son","19"), 8.6, 7)); 
        students.add(new BizStudent(7, "Messi", new Address("VN","HN","Lien Chieu","11"), 2, 4)); 
        students.add(new BizStudent(8, "Ronaldo", new Address("VN","Da Nang","Son Tra","17"), 3, 4)); 
        students.add(new BizStudent(9, "Torres", new Address("VN","HCM","Ngu Hanh Son","12"), 2.7, 4)); 
        students.add(new BizStudent(10, "Harry Macguire", new Address("VN","Da Nang","Ngu Hanh Son","12"), 8.4, 7.9)); 
        
    }
//    ------------------------------------------------------------------------
    public void inputStudent(){
        int n = valid.inputn("Enter your number of students you want to add: ");
        
        for(int i = 0; i < n; i++){
            String choice = valid.inputString("Input IT Student(I) or Biz Student(B): ", "[IB]");
            
            int id = valid.inputID("Input your ID: ", students);

            System.out.println("Input Full Name: ");
            String name = sc.nextLine();

            System.out.println("Input Your Country: ");
            String country = sc.nextLine();

            String city = valid.checkNumberOfDaNang("Input Your City: ", students, adr);

            System.out.println("Input Your Distinct: ");
            String distinct = sc.nextLine();

            System.out.println("Input Your Street: ");
            String street = sc.nextLine();

            adr.setCountry(country);
            adr.setCity(city);
            adr.setDistinct(distinct);
            adr.setStreet(street);        

            if(choice.equals("I")){
                double javaScore = valid.inputDouble("Enter the Java score: ", 0, 10);
                double cssScore = valid.inputDouble("Enter the CSS score: ", 0, 10);
                students.add(new ITstudent(id, name, adr,javaScore, cssScore));
                System.err.println("Added");
            }
            else if(choice.equals("B")){
                 double accountScore = valid.inputDouble("Enter the accounting score: ", 0, 10);
                  double marketScore = valid.inputDouble("Enter the marketing score: ", 0, 10);
                  students.add(new BizStudent(id, name, adr,accountScore, marketScore));
                  System.err.println("Added");
            }
            else{
                System.err.println("Error!");
            }
            System.out.println("-------------------");
        }

    }
//    ------------------------------------------------------------------------
    public void displayStudent(){
        System.out.println("==========LIST OF Students==========");
        
        String result="";
        
        for(Student student: students){
            result += "ID: " + student.getId() + "\n";
            result += "Full Name: " + student.getFullName() + "\n";
            result += "Address| " + student.getAddress().toString() + "|" + "\n";
            if(student instanceof BizStudent){
                ((BizStudent) student).CaculateAverageScore();
                result += "Average Score: " + student.getAverageScore() + "\n";
            }
            else{
                ((ITstudent) student).CaculateAverageScore();
                result += "Average Score: " + student.getAverageScore() + "\n";
            }
        }
        System.out.println(result);
    }
//    --------------------------------------------------------------------
    public void sortByName(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getFullName().compareTo(s2.getFullName());
            }
        });
        System.out.println("------List Of Students Sorted------");
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).getFullName());
        }
    }
//   --------------------------------------------------------------------- 
    public void sameCity(){
        ArrayList<String> arrCity = new ArrayList<String>();
        for(Student student: students){
            arrCity.add(student.getAddress().getCity());
        }
        
        Map<String, Integer> count = new HashMap<String,Integer>();      
        for(String city: arrCity){
            if (count.containsKey(city)){
                count.put(city, count.get(city) + 1);
            }
            else{
                count.put(city, 1);
            }
        }
        System.out.println("===List students have same cities===");
        for(Entry<String, Integer> entry: count.entrySet()){
            if(entry.getValue() == 1){
                continue;
            }
            else{
                System.out.println("There are " + entry.getValue() + " students in " + entry.getKey());
            }
            for(int i = 0; i < students.size(); i++){
                if(students.get(i).getAddress().getCity().equals(entry.getKey())){
                    System.out.println(students.get(i).getFullName());
                }
            }
        }
    }
//    ----------------------------------------------------------------------
    public void updateAndDelete(){
        
        int id = valid.inputInt("Input your ID you want to find: ", 0, students.size());
        
        Student check = null;
        for(Student student: students){
            if(student.getId() == id){
                check = student;
                System.out.println("-----Student Information-----");
                String info = "ID: " + check.getId() + "\n" +
                              "Full Name: " + check.getFullName() + "\n" +
                              "Address |" + check.getAddress() + "|" ;
                System.out.println(info);
                break;
                
            }
        }
        if (check == null){
            System.err.println("Can't find this student!");
        }
        else{
            String choice = valid.inputString("Do you want to update (U) or delete (D) student? ", "[UD]");

            if(choice.equals("D")){
                students.remove(check);
            }
            else if(choice.equals("U")){

                for(int i = 0; i < students.size(); i++){
                    if(id == students.get(i).getId()){
                        
                        System.out.println("Input Full Name: ");
                        String name = sc.nextLine();
                        
                        System.out.println("Input Your Country: ");
                        String country = sc.nextLine();
                        
                        String city = valid.checkNumberOfDaNang("Input Your City: ", students, adr);
                        
                        System.out.println("Input Your Distinct: ");
                        String distinct = sc.nextLine();
                        
                        System.out.println("Input Your Street: ");
                        String street = sc.nextLine();

                        Address adr = new Address();

                        adr.setCountry(country);
                        adr.setCity(city);
                        adr.setDistinct(distinct);
                        adr.setStreet(street);

                        students.get(i).setFullName(name);
                        students.get(i).setAddress(adr);
                    }
                }
            }
            else{
                System.err.println("Input Error!!");
            }
        }
        
    }
    
//    --------------------------------------------------------------------
    public void Report(){
        int countITstudentPassed = 0;
        int countBizstudentPassed = 0;
        int countTotalPassed;
        
        System.out.println("=======List Of Passed Students========");
        
        for(Student student: students){
            if(student instanceof ITstudent){
                ((ITstudent) student).CaculateAverageScore();
                if(student.getAverageScore()     >= 5){
                    String std = "Full Name: " + student.getFullName() + "\n"
                                 + "GPA: " + student.getAverageScore() + "\n";
                    System.out.println(std);
                    countITstudentPassed ++;
                }
            }
            
            else if(student instanceof BizStudent){
                ((BizStudent) student).CaculateAverageScore();
                if(student.getAverageScore() >= 5){
                    String std = "Full Name: " + student.getFullName() + "\n"
                                 + "GPA: " + student.getAverageScore() + "\n";
                    System.out.println(std);
                    countBizstudentPassed ++;
                }
            }
        }
        countTotalPassed  = countITstudentPassed + countBizstudentPassed;
        System.out.println("The total of passed students: " + countTotalPassed);
    }
//    --------------------------------------------------------------------

}


