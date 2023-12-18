import java.util.*;
import java.io.*;

class student1 {

    int roll_no, grade;
    String name;

    int get() {
        int roll_number = 0;
        try {
            Scanner ans = new Scanner(System.in);
            System.out.println("\nEnter the Roll-no: ");
            roll_number = ans.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter the value in Integer");
        }
        return roll_number;
    }

    void add() {

        Scanner ans = new Scanner(System.in);

        try {
            System.out.println("Enter the Name:");
            name = ans.nextLine();

            System.out.println("Enter the Roll No:");
            roll_no = ans.nextInt();

            System.out.println("Enter the Grade");
            grade = ans.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter in proper format");
            add();
        }

        String path = System.getProperty("user.dir") + "//" + "list_of_students" + "//" + roll_no + ".txt";
        try {
            File file = new File(path);
            if (file.createNewFile()) {
                FileWriter fw = new FileWriter(path, true);
                fw.write("Name: " + name + "\nRoll-no: " + roll_no + "\nGrade: " + grade);
                fw.close();
                System.out.println("\nStudent added Successfully!!\n");
            } else {
                System.out.println("\nStudent is already added\n");
            }
        } catch (IOException e) {
            System.out.println("Failed");
        }
    }

    void remove() {
        String path = System.getProperty("user.dir") + "//" + "list_of_students" + "//" + get() + ".txt";
        File file = new File(path);
        if (file.delete()) {
            System.out.println("\nStudent Deleted\n");
        } else {
            System.out.println("Failed");
        }
    }

    void search() {
        String path = System.getProperty("user.dir") + "//" + "list_of_students" + "//" + get()+ ".txt";
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("This Student is not added");
        } else {
            try {
                Scanner sc = new Scanner(file);
                System.out.println();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println(line);
                }
                sc.close();
                System.out.println();
            } catch (FileNotFoundException e) {
                System.out.println("Failed");
            }
        }
    }

    void display() {
        try {
            String path = System.getProperty("user.dir") + File.separator + "list_of_students";
            File dir = new File(path);

            try (PrintWriter pw = new PrintWriter(path + File.separator + "output.txt")) {
                String[] fileNames = dir.list();

                if (fileNames != null) {
                    for (String fileName : fileNames) {

                        File f = new File(dir, fileName);

                        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                            String line = br.readLine();
                            while (line != null) {
                                pw.println(line);
                                line = br.readLine();
                            }
                        } catch (IOException e) {
                            System.out.println("Failed");
                        }

                        pw.println();
                    }
                } else {
                    System.out.println("Directory is empty");
                }

            } catch (IOException e) {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            System.out.println("Failed");
        }

        String path = System.getProperty("user.dir") + "//" + "list_of_students" + "//" + "output.txt";
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Problem in file");
        } else {
            try {
                Scanner sc = new Scanner(file);
                System.out.println();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println(line);
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println("Failed");
            }
        }
    }
}

class sms extends student1 {

    void select() {
        System.out.println("Select your choice");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display all Student");
        System.out.println("5. Exit");

        try {
            Scanner ans = new Scanner(System.in);
            int g = ans.nextInt();

            switch (g) {
                case 1:
                    super.add();
                    select();

                case 2:
                    super.remove();
                    select();

                case 3:
                    super.search();
                    select();

                case 4:
                    super.display();
                    select();

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Enter the correct choice\n");
                    select();

            }
        } catch (InputMismatchException e) {
            System.out.println("Enter the Value in Integer\n");
            select();
        }
    }
}

public class student_management_system {
    public static void main(String[] args) {
        sms s1 = new sms();
        s1.select();
    }
}
