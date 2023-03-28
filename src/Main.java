import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students= new ArrayList<>() {{
            add(new Student(1,"odin","f",20,"dev",100.0f));
            add(new Student(2,"odin","m",23,"dev",200.0f));
            add(new Student(3,"phea","f",18,"data",99.0f));
        }};
        Scanner input = new Scanner(System.in);
        int op=0;
        do{
            System.out.println("-------------------------------------------");
            System.out.println("        Student Management System       ");
            System.out.println("-------------------------------------------");
            System.out.println("1. Insert Student");
            System.out.println("2. Edit Student Information");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Show Student");
            System.out.println("6. Exit");
            System.out.println("-------------------------------------------");
            System.out.print("Choose option 1-6: ");
                try{
                    op = Integer.parseInt(input.nextLine());
                }catch (Exception e){
                    op = 0;
                    System.out.println("Please Input Integer");
                    Student.pressEnter(input);
                }
            switch (op){
                case 1:
                    System.out.println("------------INSERT STUDENT------------");
                    Student newStudent = new Student();
                    newStudent.Insert(input);
                    students.add(newStudent);
                    System.out.println("Successfully added...");
                    newStudent.pressEnter(input);
                    break;
                case 2:
                    System.out.println("-------------EDIT STUDENT INFORMATION -----------");
                    Student std= new Student();
                    std.edit(students,input);
                    break;
                case 3:
                    int option=0;
                    do{
                        System.out.println("----------------SEARCH STUDENT----------------");
                        System.out.println("1. Search by ID");
                        System.out.println("2. Search by Name");
                        System.out.println("3. Search by Gender");
                        System.out.println("4. Search by Class");
                        System.out.println("5. Exit");
                        System.out.print("Choose Option 1-4: ");
                       try{
                           option =Integer.parseInt(input.nextLine());
                       }catch (Exception e){
                           option = 0;
                           System.out.println("Please Input Number!!");
                           Student.pressEnter(input);
                       }
                        switch (option){
                            case 1:
                                System.out.println("-----------Search by ID----------");
                                Student.searchByID(students,input);
                                break;
                            case 2:
                                System.out.println("-----------Search by Name-----------");
                                Student.searchByName(students,input);
                               break;
                            case 3:
                                System.out.println("-----------Search by Gender-----------");
                                Student.searchByGender(students,input);
                                break;
                            case 4:
                                System.out.println("-----------Search by Class------------");
                                Student.searchByClass(students,input);
                                break;
                            case 5:
                                System.out.println("System Terminated...");
                                break;
                        }

                    }while (option!=5);
                    break;
                case 4:
                    System.out.println("-----------------DELETE STUDENT-----------------");
                    Student.delete(students,input);
                    break;
                case 5:
                    System.out.println("-----------------------------STUDENT INFORMATION--------------------------------");
                    for (Student student: students){
                        student.show();
                    }
                    break;
                case 6:
                    System.out.println("System Terminated...!!");
                    break;
            }
        }while (op!=6);
    }
}