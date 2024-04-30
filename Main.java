import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
      public static final int[] inputSizes={10000,50000,100000,500000,1000000};
      public static final int NUMITER=100;

    public static void main(String[] args) {
      /** For each input size n in inputSizes:
        1 Initialize durationList to be a 6-by-NUMITER array of ints.
        2 For each iteration k in range(NUMITER):
        2.1 Generate a random array A of size n
        2.2 For each algorithm i in range(6):
        2.2.1 Copy array A to an array B
        2.2.2 Start the timer and store the current time in startTime
        2.2.3 Sort B using the i-th algorithm
        2.2.4 Stop the timer and store the current time in endTime
        2.2.5 durationList[i,k] = endTime - startTime)*/
      long startTime, endTime;
      double duration;
      double sum=0;
      double[] avg=new double[6];
      double[][] durationList=new double[NUMITER][6];
      for (int i:inputSizes){
              int[] A=new int[i];
              Integer[] B=new Integer[i];
              int[] C=new int[i];
              Random randomGenerator = new Random();
          for (int k=0; k<NUMITER ; k++)
          {
              for (int j=0; j<i; j++)
                  A[j] = randomGenerator.nextInt();
              Sort s = new Sort();

              //quick sort class

              for (int j=0; j<i;j++)
                  B[j] = A[j];
              startTime = System.currentTimeMillis();
              s.quickSortClass(B);
              endTime = System.currentTimeMillis();
              duration = ((double) (endTime - startTime));
              durationList[k][0]=duration;

              //quick sort recitation

              for (int j=0; j<i;j++)
                  B[j] = A[j];
              startTime = System.currentTimeMillis();
              s.quickSortRecitation(B);
              endTime = System.currentTimeMillis();
              duration = ((double) (endTime - startTime));
              durationList[k][1]=duration;


                 //merge sort recursive

              for (int j=0; j<i;j++)
                  B[j] = A[j];
              startTime = System.currentTimeMillis();
              s.mergeSortRecursive(B);
              endTime = System.currentTimeMillis();
              duration = ((double) (endTime - startTime));
              durationList[k][2]=duration;

              //merge sort iterative

              for (int j=0; j<i;j++)
                  B[j] = A[j];
              startTime = System.currentTimeMillis();
              s.mergeSortIterative(B);
              endTime = System.currentTimeMillis();
              duration = ((double) (endTime - startTime));
              durationList[k][3]=duration;

              //radix sort recursive

              /**for (int j=0; j<i;j++)
                  C[j] = A[j];
              startTime = System.currentTimeMillis();
              Sort.radixSort(C,(int)Math.pow(2,10));
              endTime = System.currentTimeMillis();
              duration = ((double) (endTime - startTime));
              durationList[k][4]=duration;*/

              //Array sort

              for (int j=0; j<i;j++)
                  B[j] = A[j];
              startTime = System.currentTimeMillis();
              Arrays.sort(B);
              endTime = System.currentTimeMillis();
              duration = ((double) (endTime - startTime));
              durationList[k][5]=duration;
          }

      for (int y=0;y<NUMITER;y++)
      {
        System.out.println();

         for (int x = 0; x < 6; x++)
         {
             System.out.print(durationList[y][x] + "   ");
         }
      }
      System.out.println();
      System.out.println("averages:");

      for (int x = 0; x < 6; x++)
      {
          sum=0;
          for (int y=0;y<NUMITER;y++)
              sum+=durationList[y][x];

          System.out.print(sum/NUMITER+"  ");
          avg[x]=sum/NUMITER;
      }
          System.out.println();
          System.out.println("Split:");

          for (int x = 0; x < 6; x++) {
              sum = 0;

              for (int y = 0; y < NUMITER; y++)
                  sum += Math.pow((avg[x]-durationList[y][x]),2);
              System.out.print(Math.sqrt(sum/NUMITER)+"  ");
          }

      for (int p=0;p<5;p++)
          System.out.println();

    }
}}
