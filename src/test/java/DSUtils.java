import com.amaz.DistanceMatrix;
import com.amaz.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DSUtils {
    // helper method :calculate Distance Matrix iterative/no thread for Tests.
    public static double[][] calculatesDistanceMatrix(List<Point> points) {
        double[][] mat =  new double[points.size()][points.size()];
        DistanceMatrix distanceMatrix =  new DistanceMatrix();

        for(int i=0;i<mat.length;i++){
            for(int j=i;j<mat[i].length;j++){
                if(i!=j)
                   mat[i][j] = mat[j][i] = distanceMatrix.calcDistence(points.get(i),points.get(j));
            }
        }
        return mat;
    }
    //helper method  generate lisot of random points.
    public static List<Point> generateRandomPoints(int n){
        List<Point> points =  new ArrayList();
        for(int i=0;i<=n;i++){
            points.add(new Point((int)(Math.random()*10+1),(int)(Math.random()*10+1)));
        }
        return points;
    }
    /*
     * print
     */
    public static void printMat(double[][] matrix){
        for (double[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}
