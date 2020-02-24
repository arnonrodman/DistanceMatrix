package com.amaz;


import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DistanceMatrix {

    /*
    * 1) One approche is that  each line will be created by different thread points.size()%numThreads
    *    each tread  will work on block of raws.
    *
    * 2) second approche is generate all combination pairs of points add them to blocking queue and each thread
    *    will calculate the distance PIPY and update PYPI as well.
    */
    public double[][] calculatesDistanceMatrix(List<Point> points,int totalThreads)throws InterruptedException{
        double[][] mat =  new double[points.size()][points.size()];
        int block = mat.length / totalThreads;
        CountDownLatch workers = new CountDownLatch(totalThreads);
        for (int i = 0; i < totalThreads; i++) {
            int index = i;
            new Thread(
                    () -> {
                        int startIndex = index * block;
                        int endBatch = startIndex + block ;
                        if((startIndex + block + 2) == points.size())
                            endBatch+=1;
                        for (int j = startIndex; j < endBatch && j < mat.length; j++) {
                            for (int k = 0; k < mat[j].length; k++) {
                                if(j!=k)
                                    mat[j][k] = mat[k][j] = calcDistence(points.get(j),points.get(k));
                            }
                        }
                        workers.countDown();
                    }
            ).start();
        }
        workers.await();
        return mat;
    }

    //dist((x, y), (a, b)) = √(x - a)² + (y - b)²
    public double calcDistence(Point p1,Point p2){
        return Math.sqrt(Math.pow((p1.getX() -p2.getX()),2)+Math.pow((p1.getY()- p2.getY()),2));
    }
}
