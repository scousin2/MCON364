package Module1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate random list for grades
        System.out.print("Enter the number of students for random list: ");
        int randomNumberOfStudents = scanner.nextInt();
        List<Student> randomStudents = generateRandomStudents(randomNumberOfStudents);
        System.out.println("\nRandom list of students:");
        printStudents(randomStudents);

        // Sort random list using QuickSort
        QuickSort<Student> quickSort = new QuickSort<>();
        List<Student> quickSortedRandom = quickSort.sort(new ArrayList<>(randomStudents));
        System.out.println("\nQuickSorted random students:");
        printStudents(quickSortedRandom);

        // Sort random list using MergeSort
        MergeSort<Student> mergeSort = new MergeSort<>();
        List<Student> mergeSortedRandom = mergeSort.sort(new ArrayList<>(randomStudents));
        System.out.println("\nMergeSorted random students:");
        printStudents(mergeSortedRandom);

        // Input list of grades
        List<Student> userInputStudents = inputStudents(scanner);
        System.out.println("\nInput list of students:");
        printStudents(userInputStudents);

        // Sort input list using QuickSort
        List<Student> quickSortedInput = quickSort.sort(new ArrayList<>(userInputStudents));
        System.out.println("\nQuickSorted input students:");
        printStudents(quickSortedInput);

        // Sort input list using MergeSort
        List<Student> mergeSortedInput = mergeSort.sort(new ArrayList<>(userInputStudents));
        System.out.println("\nMergeSorted input students:");
        printStudents(mergeSortedInput);

        scanner.close();
    }

    private static List<Student> generateRandomStudents(int numberOfStudents) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = "Student" + (i + 1);
            int grade = random.nextInt(101); // random grade between 0 and 100
            students.add(new Student(name, grade));
        }

        return students;
    }

    private static List<Student> inputStudents(Scanner scanner) {
        List<Student> students = new ArrayList<>();
        System.out.print("Enter the number of students for input list: ");
        int numberOfStudents = scanner.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.next();
            System.out.print("Enter student grade: ");
            int grade = scanner.nextInt();
            students.add(new Student(name, grade));
        }

        return students;
    }

    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("Name: " + student.getname() + ", Grade: " + student.getgrade());
        }
    }
}
