
package View;

import Controller.Manage;
import Controller.Validation;


public class main extends Menu<String> {
    static String[] mc = {"Input The Student", "Display All Of Students Infomation",
    "Sort and Print Students Infomation By Name ", "Count and Print Students Who Have The Same City",
    "Update Or Detele Student", "Report And Display", "Exit"};
    
    Manage manage = new Manage();
    Validation valid = new Validation();
    
    public main(){
        super("STUDENT MANAGEMENT", mc);
    }
    public static void main(String[] args) {
        
       new main().run(7);
    }
    @Override
    public void execute(int n){
        switch(n){
                case 1: manage.inputStudent();
                    break;
                case 2: manage.displayStudent();
                    break;
                case 3: manage.sortByName();
                    break;
                case 4: manage.sameCity();
                    break;
                case 5: manage.updateAndDelete();
                    break;
                case 6: manage.Report();
                    break;
                case 7: System.out.println("THANKS FOR USING MY SOFTWARE");
                        break;
            }
    }
}
