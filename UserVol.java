import java.util.Scanner;

public class UserVol{

    String name;
    int age;
    String fields; // Fields of expertise (ie computer science, math, )
    boolean availableTutor;
    boolean availableVolunteer;
    String listOfLangs;
    String phoneNum;
    String email;

    // User Constructor
    public UserVol(String n, int a, String f, boolean at, boolean av, String loL, String pn, String e){
        this.name = n;
        this.age = a;
        this.fields = f;
        this.availableTutor = at;
        this.availableVolunteer = av;
        this.listOfLangs = loL;
        this.phoneNum = pn;
        this.email = e;
    }

    // Default User Constructor
    public UserVol() {
        this.name = "Test";
        this.age = 0;
        this.fields = "English, Math";
        this.availableTutor = true;
        this.availableVolunteer = false;
        this.listOfLangs = "English, Creole";
        this.phoneNum = "000-000-000";
        this.email = "test@gmail.com";
    }
    
    // Get/Set Methods
    public String getName(){
        return this.name;
    }
    public void setName(String n){
        this.name = n;
    }
    
    public int getAge(){
        return this.age;
    }
    public void setAge(int a){
        this.age = a;
    }
     
    public String getFields(){
        return this.fields;
    }
    public void setFields(String f){
        this.fields = f;
    }

    public boolean getAvailableTutor(){
        return this.availableTutor;
    }
    public void setAvailableTutor(boolean at){
        this.availableTutor = at;
    }
    
    public boolean getAvailableVolunteer(){
        return this.availableVolunteer;
    }
    public void setAvailableVolunteer(boolean av){
        this.availableVolunteer = av;
    }
    
    public String getListOfLangs(){
        return this.listOfLangs;
    }
    public void setListOfLangs(String loL){
        this.listOfLangs = loL;
    }
    
    public String getPhoneNum(){
        return this.phoneNum;
    }
    public void setPhoneNum(String pn){
        this.phoneNum = pn;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String e){
        this.email = e;
    }


    //Creation of User
    public void createUser() {
        //Scanner keys  
        Scanner kbString = new Scanner(System.in);
        Scanner kbBoolean = new Scanner(System.in);
        Scanner kbInts = new Scanner(System.in);

        //Beginning of questions
        System.out.println("What is your name?");
        String userName = kbString.nextLine();
        this.setName(userName);

        System.out.println("What is your age?");
        int userAge = kbInts.nextInt();
        this.setAge(userAge);
        
        while (true){
            System.out.println("Will you be Tutoring?");
            String userAvailableTutor = kbString.nextLine();
            if(userAvailableTutor.equalsIgnoreCase("yes")){
                this.setAvailableTutor(true);
                break;
                }
            else if(userAvailableTutor.equalsIgnoreCase("no")){
                this.setAvailableTutor(false);
                break;
                }
            else{
                System.out.println("Not a valid answer. Please respond with yes or no.");
                }
        }
        
        while (true){
            System.out.println("Will you be Volunteering?");
            String userAvailableVolunteer = kbString.nextLine();
            if(userAvailableVolunteer.equalsIgnoreCase("yes")){
                this.setAvailableVolunteer(true);
                break;
                }
            else if(userAvailableVolunteer.equalsIgnoreCase("no")){
                this.setAvailableVolunteer(false);
                break;
                }
            else{
                System.out.println("Not a valid answer. Please respond with yes or no.");
                }
        }

        if(this.getAvailableTutor() == false) {
            this.setFields("");
        }
        else {
            System.out.println("What fields do you specialize in? (seperated by commas)");
            String userFields = kbString.nextLine();
            this.setFields(userFields);

        }

        System.out.println("What languages do you speak? (seperated by commas)");
        String userLangs = kbString.nextLine();
        this.setListOfLangs(userLangs);
            

        System.out.println("What is your phone number?");
        String userPhoneNum = kbString.nextLine();
        this.setPhoneNum(userPhoneNum);

        System.out.println("What is your email?");
        String userEmail = kbString.nextLine();
        this.setEmail(userEmail);
        
    }
        
}
