/**
 * Main class serves as the main interface for this program. It prompts the user for project
 * details including room dimensions, budget, and paint can price, then calculates the
 * amount of paint required, cost of one or more coats, and how much budget remains.
 *
 * @author Lehem Temesgen
 * @version 07/16/2024
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the project's title: ");
        String title = scanner.nextLine();

        System.out.print("Enter your budget: ");
        float budget = scanner.nextFloat();

        System.out.print("Enter wall height (feet): ");
        float height = scanner.nextFloat();

        System.out.print("Enter wall width (feet): ");
        float width = scanner.nextFloat();

        System.out.print("Enter wall length (feet): ");
        float length = scanner.nextFloat();

        System.out.print("Enter the price of a can of paint: ");
        float canPrice = scanner.nextFloat();

        PaintJob paintJob = new PaintJob(title, height, width, length);
        paintJob.setBudget(budget);
        paintJob.setCanPrice(canPrice);

        printPattern('*',50);
        System.out.printf("\nProject name: %s", paintJob.getProjectName());
        System.out.printf("\nWall area: %.2f ft^2\n", paintJob.getArea());
        printPattern('*',50);

        for (int coats = 1; coats <= 3; coats++) {
            paintJob.paintCoatCost(coats);
            System.out.printf("\nAmount of paint needed: %.4fL", paintJob.getPaintNeeded());
            System.out.printf("\nNumber of paint cans needed: %d cans", paintJob.getNumCans());
            System.out.printf("\nThe price of %d coat(s) of paint: %.2f$", coats, paintJob.coatCost);
            System.out.printf("\nThe amount of money left from the budget after %d coat(s): %.2f$\n", coats, paintJob.getBudget() - paintJob.getCoatCost());
            printPattern('*',50);
        }

        scanner.close();
    }

    /**
     * Method to print a pattern of a given character and length.
     * @param pattern
     * @param patternLength
     */
    public static void printPattern(char pattern, int patternLength){
        for(int i = 0; i <= patternLength; i++){
            System.out.printf("%c", pattern);
        }
    }
}