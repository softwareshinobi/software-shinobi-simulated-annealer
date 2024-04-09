/*
 * License placeholder. This file should have a proper license attached.
 * You can use the nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * template to generate one.
 */
package digital.softwareshinobi.optimization.simulatedannealer;

/**
 * This interface outlines the core requirements for a "situation" to be 
 * compatible with the Simulated Annealing algorithm. It defines two essential
 * methods:
 *
 * - `fitness()`: Calculates a numerical value representing the fitness (quality)
 *   of a given situation. This value is used to evaluate the potential solutions.
 * - `mutate()`: Generates a modified version of the current situation, representing
 *   a slight perturbation or exploration of the problem space.
 *
 * @param <T> The type of the situation being modeled
 */
public interface SimulatedAnnealerSituation<T> {

    /**
     * Calculates and returns a numerical value indicating the fitness of this situation.
     *
     * @return A Number representing the fitness of the situation
     */
    public Number fitness();

    /**
     * Creates and returns a mutated version of this situation, representing a slight
     * modification to explore different possibilities.
     *
     * @param <D> The type of the mutated situation (which is a subtype of T)
     * @return A mutated version of this situation
     */
    public <D extends T> D mutate();
}
