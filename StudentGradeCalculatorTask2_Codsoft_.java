package task;

import java.util.Scanner;

class StudentGradeCalculator {
    private int numSubjects;
    private int[] marks;
    private int totalMarks;
    private double averagePercentage;
    private char grade;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter a valid number: ");
            scanner.next();
        }
        numSubjects = scanner.nextInt();

        marks = new int[numSubjects];
        inputMarks(scanner);
        calculateTotalAndAverage();
        determineGrade();
        displayResults();

        scanner.close();
    }

    private void inputMarks(Scanner scanner) {
        System.out.println("\nEnter marks obtained (out of 100) for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Enter a valid mark (0-100): ");
                scanner.next();
            }
            int mark = scanner.nextInt();
            while (mark < 0 || mark > 100) {
                System.out.print("Invalid mark! Enter a value between 0 and 100: ");
                mark = scanner.nextInt();
            }
            marks[i] = mark;
        }
    }

    private void calculateTotalAndAverage() {
        totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        averagePercentage = (double) totalMarks / numSubjects;
    }

    private void determineGrade() {
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    private void displayResults() {
        System.out.println("\n🎓 Results:");
        System.out.println("📌 Total Marks: " + totalMarks);
        System.out.printf("📌 Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("📌 Grade: " + grade);
    }
}

public class StudentGradeCalculatortask2  {
    public static void main(String[] args) {
        StudentGradeCalculator calculator = new StudentGradeCalculator();
        calculator.start();
    }
}



