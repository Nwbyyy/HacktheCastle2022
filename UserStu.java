import java.util.Scanner;

public class UserStu{
    
    String firstName;
    String lastName;
    int age;
    String Fields;

//Default Constructor
    public UserStu()
    {
        firstName = "test";
        lastName = "last";
        age = 0;
        Fields = "math";
        }

//Loaded Contructor
    public UserStu (String fn, String ln, int a, String f) //firstName, lastName, age
    {    
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
        this.Fields = f;
    }
    
    //Get and set methods for all instance variables
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String fn){   
        this.firstName = fn;
    }
    
     public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String ln){
        this.lastName = ln;
    }
    
    public int getAge(){
        return this.age;
    }
     public void setAge(int a){
        this.age = a;
    }
    
    public String getFields(){
        return this.Fields;
    }
    public void setFields(String f){
        this.Fields = f;
    }
}