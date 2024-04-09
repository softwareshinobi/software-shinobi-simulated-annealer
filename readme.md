## Software Shinobi Annealer: Explore Your Optimization Problems

This repository implements a Simulated Annealing algorithm in Java, designed to tackle optimization problems. The current implementation focuses on finding a set of four integers that, when summed together, reach a value closest to a target number (**42** by default). This scenario can be visualized as the peak of a **parabola that opens downwards**.

Simulated Annealing mimics the process of slowly cooling metal, allowing it to settle into a state with the lowest energy level. In our case, the "energy" represents the absolute difference between the sum of the four integers and the target value. By iteratively modifying the integer values (like shaking the metal), the algorithm strives to find the combination that minimizes this difference.

This project offers:

* A practical example of applying Simulated Annealing to a mathematical problem.
* A well-structured and documented codebase for easy understanding and modification.
* Potential for exploration and adaptation to various optimization tasks.

### Getting Started

**Prerequisites:**

* Java installed and configured on your system ([https://www.java.com/en/download/](https://www.java.com/en/download/))
* Basic understanding of Java programming

**Running the Project:**

1. Clone this repository:

   ```bash
   git clone https://github.com/softwareshinobi/software-shinobi-annealer.git
   ```

2. Compile the code:

   ```bash
   cd software-shinobi-annealer
   mvn compile
   ```

3. Run the program with the following command, replacing the bracketed values with your desired parameters:

   ```bash
   mvn exec:java -Dexec.mainClass="digital.softwareshinobi.optimization.simulatedannealer.SimulatedAnnealer" \
   -Dexec.args="<initial_temperature> <cooling_rate> <max_iterations>"
   ```

   * `<initial_temperature>`: The initial temperature for the annealing process (e.g., 100).
   * `<cooling_rate>`: The rate at which the temperature cools (e.g., 0.9).
   * `<max_iterations>`: The maximum number of iterations to run the algorithm (e.g., 10000).

**Example:**

```bash
mvn exec:java -Dexec.mainClass="digital.softwareshinobi.optimization.simulatedannealer.SimulatedAnnealer" \
-Dexec.args="100 0.9 10000"
```

This command will run the program with an initial temperature of 100, a cooling rate of 0.9, and a maximum of 10000 iterations. It will print information about the best solution found and the number of iterations and improvements.

### Understanding the Code

The codebase is well-structured and documented, making it easy to understand the implementation details. Key components include:

* `SimulatedAnnealer.java`: The entry point for running the algorithm.
* `AnnealingEngine.java`: Handles the core logic of Simulated Annealing.
* `TheFourPaths.java`: Represents a state (collection of four integers) in the optimization problem.

Comments and annotations throughout the code explain the functionalities and decision points.

### Extending the Project

This implementation serves as a foundational example. You can explore various ways to extend it:

* Modify the `TheFourPaths.java` class to represent different problem scenarios and fitness calculation methods.
* Experiment with different cooling rate schedules and stopping criteria in the `AnnealingEngine.java` class.
* Explore the impact of initial temperature and maximum iteration settings on the results.

Feel free to contribute your improvements and explore the potential of Simulated Annealing for your optimization challenges!

### License

This project is licensed under the terms of the MIT License: [https://opensource.org/licenses/MIT](https://opensource.org/licenses/MIT). Please refer to the LICENSE file for details.

## why i really wrote this

this project is just the r and d for the trading robot.

which is r and d for something else.

anyways. i'm going to optimize a trading robot configuration using SA and GAs.

so step one is reviving my old shit i lost. in this case all the ai stuff i wrote.

ugh. committee machines, genetic algorithms, annealers. whatever.

redid it in a fucking hour.
