import java.util.*;

class student {

    int subject_1, subject_2, subject_3, subject_4, subject_5, subject_6, total_marks,avg_per;

    void check(int c) {
        if (c > 100) {
            System.out.println("Enter the marks in range, less than 100");
            System.out.println();
            get_marks();
        }
    }

    void get_marks() {

        Scanner ans = new Scanner(System.in);

        try {
            System.out.println("Enter the Marks obtained in Subject_1 (out of 100): ");
            subject_1 = ans.nextInt();
            check(subject_1);

            System.out.println("Enter the Marks obtained in Subject_2 (out of 100): ");
            subject_2 = ans.nextInt();
            check(subject_2);

            System.out.println("Enter the Marks obtained in Subject_3 (out of 100): ");
            subject_3 = ans.nextInt();
            check(subject_3);

            System.out.println("Enter the Marks obtained in Subject_4 (out of 100): ");
            subject_4 = ans.nextInt();
            check(subject_4);

            System.out.println("Enter the Marks obtained in Subject_5 (out of 100): ");
            subject_5 = ans.nextInt();
            check(subject_5);

            System.out.println("Enter the Marks obtained in Subject_6 (out of 100): ");
            subject_6 = ans.nextInt();
            check(subject_6);
        } catch (InputMismatchException e) {
            System.out.println("Enter the value in integer");
            System.out.println();
            get_marks();
        }
        ans.close();
        calculate_total_marks();
    }

    void calculate_total_marks() {
        total_marks = subject_1 + subject_2 + subject_3 + subject_4 + subject_5 + subject_6;
        System.out.println("\nTotal Marks obtained (out of 600) is: " + total_marks);
        calculate_average_percentage();
    }

    void calculate_average_percentage() {
        avg_per = total_marks / 6;
        System.out.println("Average Percentage obtained is: " + avg_per);
        calculate_grade();
    }

    void calculate_grade() {
        if (avg_per >= 90)
            System.out.println("Congratulations! You've earned an A+ Grade");
        else if (avg_per >= 80)
            System.out.println("Great job! You've earned an A Grade");
        else if (avg_per >= 70)
            System.out.println("Well done! You've earned a B+ Grade");
        else if (avg_per >= 60)
            System.out.println("Good work! You've earned a B Grade");
        else if (avg_per >= 50)
            System.out.println("Keep it up! You've earned a C Grade");
        else if (avg_per >= 40)
            System.out.println("You passed, but there's room for improvement. You've earned a D Grade");
        else
            System.out.println("Unfortunately, you failed. Better luck next time!");
    }
}

public class student_grade_calculator {
    public static void main(String[] args) {
        student s1 = new student();
        s1.get_marks();
    }
}