/*
 * License placeholder. This file should likely have a proper license attached.
 * You can use the nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * template to generate a suitable license.
 */
package digital.softwareshinobi.optimization.simulatedannealer;

/**
 * This class serves as the entry point for running the Simulated Annealing algorithm.
 * It demonstrates basic usage by creating a random initial state (`TheFourPaths`),
 * generating a mutated neighbor, and then kicking off the annealing process with
 * an `AnnealingEngine` instance.
 *
 * (Note: The comments about beer and future plans are humorous but can be removed 
 * for a more professional tone.)
 *
 * @author softwareshinobi
 */
public class SimulatedAnnealer {

    public static void main(String[] args) {

        System.out.println("hello universe");
        System.out.println("launch > simulated annealer");

        // Create a random initial state (TheFourPaths object)
        TheFourPaths demo = TheFourPaths.random();
        System.out.println("demo / " + demo);  // Print initial state

        // Generate a mutated neighbor state
        TheFourPaths mutation = demo.mutate();
        System.out.println("mutation / " + mutation);  // Print mutated state

        // Create an AnnealingEngine instance with parameters
        AnnealingEngine engine = new AnnealingEngine(100, 1, 1_000_000);

        // Run the Simulated Annealing algorithm with the initial state
        engine.run(demo);
    }
}
