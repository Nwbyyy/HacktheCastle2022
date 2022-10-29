import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// TODO:
// - Add language option, to switch to other languages (ex. Spanish, Creole, etc.)
//      * Ran out of time

public class Main {

    public static void main(String[] args) {

        try {   
            File studentSave = new File("studentUsers.txt");
            File volunteerSave = new File("volunteerUsers.txt");
            if (studentSave.createNewFile()) {
                System.out.println("File created: " + studentSave.getName());
            } 
            else {
                System.out.println("File " + studentSave.getName() + " already exists.");
            }
            if (volunteerSave.createNewFile()) {
                System.out.println("File created: " + volunteerSave.getName());
            } 
            else {
                System.out.println("File " + volunteerSave.getName() + " already exists.");
            }
        } 
        catch (IOException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }


        JFrame frame = new JFrame("IFSI Tutor Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton createStuProfileButton = new JButton("Create Student Profile");
        ActionListener stuProfileActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JTextField firstName = new JTextField();
                JTextField lastName = new JTextField();
                JTextField age = new JTextField();
                JTextField fields = new JTextField();

                Object[] studentInfo = {
                    "First Name:", firstName,
                    "Last Name:", lastName,
                    "Age:", age,
                    "What educational areas do you need help with? (seperated by commas)", fields
                };

                int option = JOptionPane.showConfirmDialog(null, studentInfo, "Information", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION && firstName.getText().length() > 0) {
                    UserStu userStudent = new UserStu(firstName.getText(), lastName.getText(), Integer.parseInt(age.getText()), fields.getText());

                    try {
                        FileWriter myWriter = new FileWriter("studentUsers.txt", true);
                        myWriter.write(userStudent.getLastName() + ", " + userStudent.getFirstName() + "; " + userStudent.getAge() + "; " +         userStudent.getFields() + "\n");
                        myWriter.close();
                        System.out.println("Successfully wrote to the studentUsers.txt file.");
                    } 
                    catch (IOException exception) {
                        System.out.println("An error occurred.");
                        exception.printStackTrace();
                    }

                }               
                else {
                    System.out.println("Profile Creation Canceled");
                }
            }
        };
        createStuProfileButton.addActionListener(stuProfileActionListener);

        JButton createVolProfileButton = new JButton("Create Volunteer Profile");
        ActionListener volProfileActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JTextField name = new JTextField();
                JTextField age = new JTextField();
                JTextField fields = new JTextField();
                JTextField availableTutor = new JTextField();
                JTextField availableVolunteer = new JTextField();
                JTextField languages = new JTextField();
                JTextField phoneNum = new JTextField();
                JTextField email = new JTextField();


                Object[] volunteerInfo = {
                    "Full Name:", name,
                    "Age:", age,
                    "Fields of Expertise: (seperated by commas)", fields,
                    "Are you available to tutor? (true or false)", availableTutor,
                    "Are you available to volunteer? (true or false)", availableVolunteer,
                    "What languages do you speak? (seperated by commas)", languages,
                    "What is your phone number?", phoneNum,
                    "What is your email?", email
                };

                int option = JOptionPane.showConfirmDialog(null, volunteerInfo, "Information", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION && name.getText().length() > 0) {
                    // create student
                    UserVol userVolunteer = new UserVol(name.getText(), Integer.parseInt(age.getText()), fields.getText(), Boolean.parseBoolean(availableTutor.getText()), Boolean.parseBoolean(availableVolunteer.getText()), languages.getText(), phoneNum.getText(), email.getText());

                    try {
                        FileWriter myWriter = new FileWriter("volunteerUsers.txt", true);
                        myWriter.write(userVolunteer.getName() + ", " + userVolunteer.getAge() + "; " + userVolunteer.getFields() + "; " +         userVolunteer.getAvailableTutor() + "; " + userVolunteer.getAvailableVolunteer() + "; " + userVolunteer.getListOfLangs() + "; " + userVolunteer.getPhoneNum() + "; " + userVolunteer.getEmail() + "\n");
                        myWriter.close();
                        System.out.println("Successfully wrote to the volunteerUsers.txt file.");
                    } 
                    catch (IOException exception) {
                        System.out.println("An error occurred.");
                        exception.printStackTrace();
                    }


                    }               
                else {
                    System.out.println("Profile Creation Canceled");
                }
            }
        };
        createVolProfileButton.addActionListener(volProfileActionListener);

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(createStuProfileButton);
        buttonPanel.add(createVolProfileButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(300,100);
        frame.setVisible(true);

    }

}



// Pre-GUI-integration test code
/*
String[] langs;
UserVol u2 = new UserVol();

u2.createUser();

//Final Output
System.out.print("\nName: " + u2.getName() + 
"\nAge: " + u2.getAge() + 
"\nAvailblity to Tutor: " + u2.getAvailableTutor() +
"\nAvailbility to Volunteer: " + u2.getAvailableVolunteer() + 
"\nLanguages Spoken: " + u2.getListOfLangs());


if(u2.getFields().equals("") || u2.getFields().equals(" ")) {
    System.out.print("\nFields of Expertise: Not Tutoring");
}
else {
    System.out.print("\nFields of Expertise: " + u2.getFields());
}

System.out.println("\nPhone Number: " + u2.getPhoneNum());
System.out.println("Email Adress: " + u2.getEmail());
*/