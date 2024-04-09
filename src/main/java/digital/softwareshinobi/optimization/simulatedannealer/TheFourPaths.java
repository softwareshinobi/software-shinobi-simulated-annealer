package digital.softwareshinobi.optimization.simulatedannealer;

import java.util.Random;

/**
 * This class represents a specific situation (state) for the Simulated Annealing algorithm
 * in this implementation. It models a collection of four integer paths, aiming to find a combination
 * where the sum is closest to a target value (42 in this case). It implements the 
 * `SimulatedAnnealerSituation` interface, adhering to its required methods.
 */
public class TheFourPaths implements SimulatedAnnealerSituation<TheFourPaths>, Comparable<TheFourPaths> {

    // Instance variables representing the four integer paths
    private Integer pathOne;
    private Integer pathTwo;
    private Integer pathThree;
    private Integer pathFour;

    // Constructor
    public TheFourPaths(Integer pathOne, Integer pathTwo, Integer pathThree, Integer pathFour) {
        this.pathOne = pathOne;
        this.pathTwo = pathTwo;
        this.pathThree = pathThree;
        this.pathFour = pathFour;
    }

    // Static helper method to generate a random TheFourPaths object
    public static TheFourPaths random() {
        return new TheFourPaths(
                TheFourPaths.randomPath(),
                TheFourPaths.randomPath(),
                TheFourPaths.randomPath(),
                TheFourPaths.randomPath()
        );
    }

    // Static helper method to generate a random integer path value
    private static Integer randomPath() {
        int min = 0;
        int max = 42;
        return new Random().nextInt(max - min + 1) + min; // Generate random value within range
    }

    // Calculates the sum of the four paths
    public Integer sum() {
        return this.pathOne + this.pathTwo + this.pathThree + this.pathFour;
    }

    // Calculates the fitness based on the absolute difference between the sum and the target (42)
    @Override
    public Integer fitness() {
        int sum = this.sum();
        int target = 42; // Target value to find the closest sum to
        return Math.abs(target - sum);
    }

    // Mutates the current object by randomly changing the value of one of the four paths
    @Override
    public TheFourPaths mutate() {
        int randomIndex = (int) (Math.random() * 4); // Generate random index between 0 and 3

        TheFourPaths mutated = new TheFourPaths(this.pathOne, this.pathTwo, this.pathThree, this.pathFour); // Create a copy

        switch (randomIndex) {
            case 0:
                mutated.pathOne = TheFourPaths.randomPath();
                break;
            case 1:
                mutated.pathTwo = TheFourPaths.randomPath();
                break;
            case 2:
                mutated.pathThree = TheFourPaths.randomPath();
                break;
            case 3:
                mutated.pathFour = TheFourPaths.randomPath();
                break;
        }

        return mutated;
    }

    // Compares two TheFourPaths objects based on their fitness values
    @Override
    public int compareTo(TheFourPaths theOtherFourPaths) {
        return Double.compare(this.fitness(), theOtherFourPaths.fitness());
    }

    // String representation of the TheFourPaths object
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("pathOne=").append(pathOne);
        stringBuilder.append(", pathTwo=").append(pathTwo);
        stringBuilder.append(", pathThree=").append(pathThree);
        stringBuilder.append(", pathFour=").append(pathFour);
        stringBuilder.append(", sum=").append(this.sum());
        stringBuilder.append(", fitness=").append(this.fitness());
        stringBuilder.append("}");

        String toString = stringBuilder.toString();
        stringBuilder = null; // Clear the StringBuilder for memory efficiency

        return toString;
    }
}
