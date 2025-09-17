

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.projects.linearregression.RegressionSolver;

public class RegressionSolverTest {

    RegressionSolver solver;


    @Test
    public void setup() {
        solver = new RegressionSolver();
    }
    public void testGetRegressionPoly_linear() {
        // y = 2x + 1
        double[][] points = {
                {0, 1},
                {1, 3},
                {2, 5},
                {3, 7}
        };
        solver.getRegressionPoly(1, points);
        String coeffStr = solver.getPolyString();
        assertNotNull(coeffStr);
        assertEquals(1.0, solver.betaMat.get(0, 0), 1e-6);
        assertEquals(2.0, solver.betaMat.get(1, 0), 1e-6);
    }

    @Test
    public void setup1() {
        solver = new RegressionSolver();
    }
    public void testPoly_evaluation() {
        double[][] points = {{0, 1}, {1, 3}, {2, 5}, {3, 7}
        };
        solver.getRegressionPoly(1, points);

        double yVal = solver.poly(4);
        assertEquals(9.0, yVal, 1e-6);

        // Evaluate at x=0, expect y=1
        assertEquals(1.0, solver.poly(0), 1e-6);
    }

    @Test
    public void setup2() {
        solver = new RegressionSolver();
    }
    public void testGetRegressionPoly_quadratic() {
        double[][] points = {{0, 1},
                {1, 4}, {2, 9},
                {3, 16}
        };

        solver.getRegressionPoly(2, points);

        assertEquals(1.0, solver.betaMat.get(0, 0), 1e-6);
        assertEquals(2.0, solver.betaMat.get(1, 0), 1e-6);
        assertEquals(1.0, solver.betaMat.get(2, 0), 1e-6);
        double yVal = solver.poly(4);
        assertEquals(25.0, yVal, 1e-6);
    }

}