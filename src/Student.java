import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    int id;
     String name;
     String gender;
     int age;
     String classRoom;
     float score;

    // todo constructor
    public Student(){}
    public Student(int id, String name, String gender, int age, String classRoom, float score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classRoom = classRoom;
        this.score = score;
    }
    //todo press Enter
    public static void pressEnter(Scanner input){
        System.out.print("==> Press Enter to continue...");
        input.nextLine();
        input.nextLine();
    }
    // todo try catch
    int enterId(Scanner input){
        boolean isValid = false;
        do{
            try{
                System.out.print("Enter ID: ");
                id = Integer.parseInt(input.nextLine());
                isValid =true;
            }catch (Exception e){
                System.out.println("Invalid ID format!! Please enter Integer...");
            }
        }while (!isValid);
        return id;
    }
     int enterAge(Scanner input){
        boolean isValid = false;
        do{
            try{
                System.out.print("Enter Age: ");
                age = Integer.parseInt(input.nextLine());
                isValid =true;
            }catch (Exception e){
                System.out.println("Invalid Age format!! Please enter Integer...");
            }
        }while (!isValid);
        return age;
    }
     float enterScore(Scanner input){
        boolean isValid = false;
        do{
            try{
                System.out.print("Enter Score: ");
                score = Float.parseFloat(input.nextLine());
                isValid =true;
            }catch (Exception e){
                System.out.println("Invalid Score format!! Please enter float...");
            }
        }while (!isValid);
        return score;
    }
     String enterGender(Scanner input){
        boolean isValid = false;
        do{
            try{
                System.out.print("Enter Gender: ");
                gender = input.nextLine();
                isValid =true;
            }catch (Exception e){
                System.out.println("Invalid Gender format!! Please enter String...");
            }
        }while (!isValid);
        return gender;
    }
    // end of try catch

    // todo Insert Method
    public void Insert(Scanner input){
        input.nextLine();
        enterId(input);
        System.out.print("Enter Name: ");
        name= input.nextLine();
        enterGender(input);
        enterAge(input);
        System.out.print("Enter Class: ");
        classRoom = input.nextLine();
        enterScore(input);
    }
    //todo Edit method
    public void edit(ArrayList<Student> students,Scanner input){
        System.out.print("Enter ID of the student you want to edit: ");
        int idToEdit = input.nextInt();
        boolean isFound = false;
        for(Student student : students){
            if(student.id == idToEdit){
                isFound = true;
                input.nextLine();
                System.out.println("Enter the new details for the student:");
                System.out.print("Enter New Name: ");
                student.name= input.nextLine();
                student.enterGender(input);
                student.enterAge(input);
                System.out.print("Enter New Class: ");
                student.classRoom = input.nextLine();
                student.enterScore(input);
                System.out.println("Student with ID " + idToEdit + " has been successfully updated.");
                break;
            }
        }
        if(!isFound){
            System.out.println("Student with ID " + idToEdit + " not found.");
        }
    }
    //todo Delete method
    public static void delete(ArrayList<Student> students,Scanner input){
        System.out.print("Enter ID of the student you want to delete: ");
        int idToDelete = input.nextInt();
        boolean isFound = false;
        for(Student student : students){
            if(student.id == idToDelete){
                isFound = true;
                students.remove(student);
                System.out.println("Student with ID " + idToDelete + " has been successfully deleted.");
                break;
            }
        }
        if(!isFound){
            System.out.println("Student with ID " + idToDelete + " not found.");
        }
    }
    // todo search student by id
    public static void searchByID(ArrayList<Student> students, Scanner input){
        System.out.println("Enter ID to search student: ");
        int idToSearch = input.nextInt();
        boolean isFound = false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).id == idToSearch ){
                isFound = true;
                students.get(i).show();
                break;
            }
        }
        if(!isFound){
            System.out.println("Student with ID " + idToSearch + " not found.");
        }
    }
    // todo search by name
    public static void searchByName(ArrayList<Student> students, Scanner input){
        input.nextLine();
        System.out.println("Enter Name to search student: ");
        String nameToSearch = input.nextLine();
        boolean isFound = false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).name.equalsIgnoreCase(nameToSearch)){
                students.get(i).show();
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("Student with name " + nameToSearch + " not found.");
        }
    }
    // todo search by gender
    public static void searchByGender(ArrayList<Student> students, Scanner input){
        input.nextLine();
        System.out.println("Enter Gender to search student: ");
        String genderToSearch = input.nextLine();
        boolean isFound = false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).gender.equalsIgnoreCase(genderToSearch)){
                students.get(i).show();
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("There're no "+ genderToSearch +" Student!!");
        }
    }
    // todo search by class
    public static void searchByClass(ArrayList<Student> students, Scanner input){
        System.out.println("Enter Class to search student: ");
        String classToSearch = input.nextLine();
        boolean isFound = false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).classRoom.equalsIgnoreCase(classToSearch)){
                students.get(i).show();
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("Class"+ classToSearch + "doesn't has any student!!");
        }
    }
    // todo Show method
    public void show(){
        System.out.println("ID: "+id+"\t | NAME: "+ name+
                "\t | Gender: "+ gender+ "\t | AGE: "+age+
                "\t | ClASS: "+ classRoom+"\t | SCORE: "+score);
    }
}
