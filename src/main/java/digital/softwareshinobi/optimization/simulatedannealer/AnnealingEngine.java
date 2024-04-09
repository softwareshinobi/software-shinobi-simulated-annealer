package digital.softwareshinobi.optimization.simulatedannealer;

/**
 * Represents the core engine for executing the Simulated Annealing algorithm.
 */
public class AnnealingEngine {

    // Core parameters of the Simulated Annealing process
    private final double initialTemperature;  // Initial temperature for exploration
    private final double coolingRate;        // Rate at which the temperature is cooled
    private final int maxIterations;         // Maximum number of iterations to run

    // State tracking variables
    private TheFourPaths best;               // Stores the current best solution
    private int currentBestFitness;          // Fitness value of the current best solution
    private int globalIterationCount;        // Counts the total number of iterations executed
    private int improvementCount;           // Counts the number of times a better solution is found

    /**
     * Constructs an AnnealingEngine with the specified parameters.
     *
     * @param initialTemperature The initial temperature for the algorithm
     * @param coolingRate The rate at which the temperature is cooled
     * @param maxIterations The maximum number of iterations to run
     */
    public AnnealingEngine(double initialTemperature, double coolingRate, int maxIterations) {
        this.initialTemperature = initialTemperature;
        this.coolingRate = coolingRate;
        this.maxIterations = maxIterations;
    }

    /**
     * Runs the Simulated Annealing algorithm, starting from the provided
     * `startingState`.
     *
     * @param startingState The initial state to start the algorithm from
     * @return The best solution found during the annealing process
     */
    public TheFourPaths run(TheFourPaths startingState) {
        // Initialize state variables
        this.best = startingState;
        this.currentBestFitness = best.fitness();
        this.globalIterationCount = 0;
        this.improvementCount = 0;

        double temperature = this.initialTemperature;

        // Annealing loop
        while (temperature > 0 && this.globalIterationCount < this.maxIterations) {
            // Print current state information (for debugging)
            System.out.println("currentBestFitness / " + currentBestFitness);
            System.out.println("globalIterationCount / " + globalIterationCount);
            System.out.println("improvementCount / " + improvementCount);
            System.out.println("best / " + best);

            // Generate a neighboring solution by mutating the current best
            TheFourPaths neighbor = this.best.mutate();

            // Print neighbor information (for debugging)
            System.out.println("neighbor / " + neighbor);
            System.out.println();

            // Evaluate the fitness of the neighbor
            int neighborFitness = neighbor.fitness();

            // Check for perfect solution or equality
            if (neighborFitness == 0) {
                System.out.println("perfect match found");
                break;
            } else if (neighborFitness == this.currentBestFitness) {
                System.out.println("they are equal. stopping. mission accomplished");
                break;
            }

            // Calculate fitness difference
            int fitnessDifferential = neighborFitness - this.currentBestFitness;

            // Acceptance criteria:
            // - Accept better solutions unconditionally
            // - Accept worse solutions with a probability based on temperature
            if (fitnessDifferential < 0) {
                this.best = neighbor;
                this.currentBestFitness = neighborFitness;
                this.improvementCount++;
            } else {  // fitnessDifferential > 0 (worse solution)
                // Disabled for simplicity in this implementation
                // double probability = Math.exp(-fitnessDifferential / temperature);
                // if (Math.random() < probability) {
                //     this.best = neighbor;
                //     this.currentBestFitness = neighborFitness;
                // }
            }

            // Cool down the temperature and increment iteration count
            temperature = temperature * this.coolingRate;
            this.globalIterationCount++;
        }

        return this.best;  // Return the best solution found
    }

    // Getters for state information
    public int getGlobalIterationCount() {
        return this.globalIterationCount;
    }

    public int getImprovementCount() {
        return this.improvementCount;
    }
}
