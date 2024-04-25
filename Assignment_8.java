import java.util.Arrays;
public class Assignment_8{
    // Function to perform Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }

    // Function to display the top five scores
    public static void displayTopFiveScores(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Top Five Scores:");
        for (int i = arr.length - 1; i >= Math.max(0, arr.length - 5); i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        // Input: Array of second-year percentages
        int[] percentages = {82, 91, 76, 89, 96, 72, 100, 85, 90, 80};

        


        // Sorting using Shell Sort
        shellSort(percentages);
        System.out.println("After Shell Sort:");
        System.out.println(Arrays.toString(percentages));

        // Display the top five scores
        displayTopFiveScores(percentages);

        // Take input from user and create a new list
        System.out.print("Enter number of students whose percentage are to be displayed: ");
        int n = Integer.parseInt(System.console().readLine());
        int[] newPercentages = new int[n];
        System.out.println("Enter percentage for " + n + " students (Press ENTER after every student's marks):");
        for (int i = 0; i < n; i++) {
            newPercentages[i] = Integer.parseInt(System.console().readLine());
        }

    

        // Sorting using Shell Sort
        shellSort(newPercentages);
        System.out.println("After Shell Sort:");
        System.out.println(Arrays.toString(newPercentages));

        // Display the top five scores
        displayTopFiveScores(newPercentages);
    }
}



