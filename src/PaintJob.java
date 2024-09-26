/**
 * PaintJob class calculates the amount of paint needed, the number of cans required, and the total
 * cost for one or more coats of paint based on room dimensions and paint can price given by the user.
 *
 * @author Lehem Temesgen
 * @version 07/16/2024
 */
public class PaintJob {

    public int numCans;
    public float coatCost;
    public float paintNeeded;

    private String projectName;
    private float height;
    private float width;
    private float length;
    private float area;
    private float budget;
    private float canPrice;
    private static final float LITER_COVERS_SQUARE_FEET = 100.0f;

    /**
     * Class's default constructor.
     */
    public PaintJob() {
        this.numCans = 0;
        this.coatCost = 0.0f;
        this.paintNeeded = 0.0f;
        this.projectName = " ";
        this.height = 0.0f;
        this.width = 0.0f;
        this.length = 0.0f;
        this.area = 0.0f;
        this.budget = 0.0f;
        this.canPrice = 0.0f;
    }

    /**
     * Class's overload constructor that sets the values of specific attributes based on user input.
     *
     * @param projectName
     * @param height
     * @param width
     * @param length
     */
    public PaintJob(String projectName, float height, float width, float length) {
        this.numCans = 0;
        this.coatCost = 0.0f;
        this.paintNeeded = 0.0f;
        this.projectName = projectName;
        this.height = height;
        this.width = width;
        this.length = length;
        // surface area of a rectangular prism, excluding the floor & ceiling.
        this.area = 2* ((this.height * this.length) + (this.height * this.width));
        this.budget = 0.0f;
        this.canPrice = 0.0f;
    }

    /**
     * Method to set the number of paint cans needed.
     * @param numCans
     */
    public void setNumCans(int numCans) {
        this.numCans = numCans;
    }

    /**
     * Method to get the number of paint cans needed.
     * @return number of cans
     */
    public int getNumCans() {
        return this.numCans;
    }

    /**
     * Method to set the cost of the coat of paint.
     * @param coatCost
     */
    public void setCoatCost(float coatCost) {
        this.coatCost = coatCost;
    }

    /**
     * Method to get the cost of the coat of paint.
     * @return cost of coat
     */
    public float getCoatCost() {
        return this.coatCost;
    }

    /**
     * Method to set the amount of paint needed (litres).
     * @param paintNeeded
     */
    public void setPaintNeeded(float paintNeeded) {
        this.paintNeeded = paintNeeded;
    }

    /**
     * Method to get the amount of paint needed (litres).
     * @return litres of paint needed
     */
    public float getPaintNeeded() {
        return this.paintNeeded;
    }


    /**
     * Method to get the project's name.
     * @return project's name
     */
    public String getProjectName() {
        return this.projectName;
    }

    /**
     * Method to get the room's surface area.
     * @return room's surface area.
     */
    public float getArea() {
        return this.area;
    }

    /**
     * Method to set the project budget.
     * @param budget
     */
    public void setBudget(float budget) {
        this.budget = budget;
    }

    /**
     * Method to get the project budget
     * @return project budget
     */
    public float getBudget() {
        return this.budget;
    }

    /**
     * Method to set the price of a can of paint.
     * @param canPrice
     */
    public void setCanPrice(float canPrice) {
        this.canPrice = canPrice;
    }

    /**
     * Method to calculate the amount of paint needed in litres, the number of cans needed and the cost of each coat of paint.
     * @param coats
     */
    public void paintCoatCost(int coats) {
        this.paintNeeded = (this.area * coats) / LITER_COVERS_SQUARE_FEET;
        this.setPaintNeeded(paintNeeded);
        this.numCans = (int) Math.ceil(this.paintNeeded / 3.7f);
        this.setNumCans(numCans);
        this.coatCost = this.numCans * this.canPrice;
        this.setCoatCost(coatCost);
    }
}
