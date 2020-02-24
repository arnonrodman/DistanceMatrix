import com.amaz.DistanceMatrix;
import com.amaz.Point;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


/*
 * Test calculatesDistanceMatrix method ,main method for calculating the matrix
 * and compare/equal ,for the test, for iterative matirx calculation  , non threads .
 */
public class DistanceMatrixTest {

    @Test
    public void DistanceMatrixTestEquals(){
        DistanceMatrix distanceMatrix =  new DistanceMatrix();
        int numPoint = 5,totalNumberOfThreads=3;
        List<Point> points = DSUtils.generateRandomPoints(numPoint);

        double[][] nonThreadMatrix=null,threadMatrix=null;
        try {
            threadMatrix = distanceMatrix.calculatesDistanceMatrix(points,totalNumberOfThreads);
        } catch (InterruptedException e) {
            assertFalse(false);
            return;
        }
        //compare iterative single thread distance matrix.
        nonThreadMatrix = DSUtils.calculatesDistanceMatrix(points);
        assertTrue("Distance matirx  is valid ",Arrays.deepEquals(nonThreadMatrix,threadMatrix));
    }

    @Test
    public void DistanceMatrixTestNonEquals(){
        DistanceMatrix distanceMatrix =  new DistanceMatrix();
        int numPoint = 5,totalNumberOfThreads=3;
        List<Point> points = DSUtils.generateRandomPoints(numPoint);

        double[][] nonThreadMatrix=null,threadMatrix=null;
        try {
            threadMatrix = distanceMatrix.calculatesDistanceMatrix(points,totalNumberOfThreads);
        } catch (InterruptedException e) {
            assertFalse(false);
            return;
        }
        //compare iterative single thread distance matrix.
        nonThreadMatrix = DSUtils.calculatesDistanceMatrix(points);
        nonThreadMatrix[numPoint/2][numPoint/3]=666;
        assertFalse(" non equals array ",Arrays.deepEquals(nonThreadMatrix,threadMatrix));
    }
}
