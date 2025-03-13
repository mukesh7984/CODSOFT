import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.println("StudentGradeCalculator");
        System.out.print("Enter the number of students: ");
        int numberOfStudents = S.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter scores for student " + (i + 1) + ":");

            double totalScore = 0;
            int numberOfSubjects = 5;

            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print("Score for subject " + (j + 1) + " (out of 100): ");
                double score = S.nextDouble();
                totalScore += score;
            }

            double averagePercentage = totalScore / numberOfSubjects;
            char grade = calculateGrade(averagePercentage);

            System.out.println("Total Marks: " + totalScore);
            System.out.println("Average Percentage: " + averagePercentage);
            System.out.println("Grade: " + grade);
            System.out.println();
        }

        S.close();
    }

    public static char calculateGrade(double score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
