import com.amaz.DistanceMatrix;
import com.amaz.Point;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/*
 * Test calculates Distance Matrix method  between two  points.
 */
public class CalcDistenceTest {

    @Test
    public void calcDistenceTest(){
        DistanceMatrix distanceMatrix =  new DistanceMatrix();
        double incorrectDistance = distanceMatrix.calcDistence(new Point(2,5),new Point(5,-2));
        assertFalse("Test failed on calculate distance ",666==incorrectDistance);
    }
}
