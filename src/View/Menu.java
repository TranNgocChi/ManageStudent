package View;
import java.util.ArrayList;
import Controller.Validation;

public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> mChon;
    Validation validation = new Validation();
    
    public Menu(){}
    
    public Menu(String td, String[] mc){
        title=td;
        mChon= new ArrayList<T>();
        for(String s:mc) mChon.add((T) s);
    }
//-------------------------------------------
    public void display(){
        System.out.println(title);
        System.out.println("--------------------------------");
        for(int i=0; i<mChon.size();i++)
            System.out.println((i+1)+"."+mChon.get(i));
        System.out.println("--------------------------------");
    }
//-------------------------------------------

    public abstract void execute(int n);
//-------------------------------------------
    public void run(int m){
        while(true){
            display();
            String mess = "Enter your choice: ";
            int n= validation.inputInt(mess,1,m);
            execute(n);
            if(n>=mChon.size()) break;
        }
    }
//-------------------------------------------    
}
