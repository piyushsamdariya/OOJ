import java.util.Scanner;

class Student {
    private String usn;
    private String name;
    private int[] credits;
    private int[] marks;
    private int numSubjects;

    public Student(int numSubjects) {
        this.numSubjects = numSubjects; 
        credits = new int[numSubjects];
        marks = new int[numSubjects];
    }

    public void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your USN:");
        usn = sc.nextLine();
        System.out.println("Enter your name:");
        name = sc.nextLine();
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter number of credits for subject " + (i + 1) + ":");
            credits[i] = sc.nextInt();
            System.out.println("Enter number of marks for subject " + (i + 1) + ":");
            marks[i] = sc.nextInt();
        }
    }

    public void displayDetails() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);

        System.out.println("SGPA is:"+calculateSGPA());
    }

    public double calculateSGPA() {
        double sum = 0;
        int totalCredits = 0;
        for (int j = 0; j < numSubjects; j++) {
            sum += ((marks[j] / 10.0) + 1) * credits[j]; 
            totalCredits += credits[j];
        }
        return (sum / totalCredits);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int numStudents = scan.nextInt();
        System.out.println("Enter number of subjects:");
        int numSubjects = scan.nextInt();

        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            students[i] = new Student(numSubjects);
            students[i].acceptDetails();
        }
        for (int i = 0; i < numStudents; i++) {
            students[i].displayDetails();
        }
        scan.close(); 
    }
}
