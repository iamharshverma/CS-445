import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Assig4
{
    public static void main(String []args)
    {
        boolean trace = false;
        PrintWriter fileOut = null;
        double timeStart;
        double timeEnd;
        double timeTaken;
        double timeTotal = 0;
        double timeAverage;

        Scanner useri = new Scanner(System.in);
        System.out.println("What is the size of the array to be tested?");
        int arraySize = Integer.parseInt(useri.nextLine());
        System.out.println("How many trials per run?");
        int trialNumber = Integer.parseInt(useri.nextLine());
        System.out.println("What should the output file be named?");
        String fileName = useri.nextLine();
        try
        {
            fileOut = new PrintWriter(new FileOutputStream(fileName, false));
        }
        catch (IOException q)
        {
            System.out.println("IO Exception thrown");
        }
        if(arraySize <= 20)
        {
            trace = true;
        }

        Integer[] random = new Integer[arraySize];
        Integer[] sorted = new Integer[arraySize];
        Integer[] reverseSorted = new Integer[arraySize];
        Integer[] copy = new Integer[arraySize];

        Random rand = new Random();
        for (int i = 0; i < arraySize; i++)
        {
            sorted[i] = i + 1;
            reverseSorted[i] = arraySize - i;
        }
        //******************************START SORT TESTS******************************//

        //***********************************RANDOM***********************************//


        double time1 = 0;
        double time2 = 0;
        double time3 = 0;
        double time4 = 0;
        double time5 = 0;
        double time6 = 0;

        for (int i = 0; i < trialNumber; i++)
        {
            for (int j = 0; j < arraySize; j++)
            {
                random[j] = rand.nextInt((arraySize - 1) + 1) + 1;
            }

            /*SIMPLE QUICKSORT*/
            if (arraySize <= 100000)
            {
                System.arraycopy(random, 0, copy, 0, random.length);

                if (trace) {
                    System.out.println("Algorithm: Simple QuickSort");
                    System.out.println("Array Size: " + arraySize);
                    System.out.println("Order: Random");
                    System.out.println("Data in array before sort: " + Arrays.toString(copy));
                }

                timeStart = System.nanoTime();
                Quick.quickSort1(copy, 0, arraySize - 1);
                timeEnd = System.nanoTime();
                timeTaken = timeEnd - timeStart;
                time1 += timeTaken;

                if (trace) {
                    System.out.println("Data in array after sort: " + Arrays.toString(copy));
                    System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
                }
            }

            /*Median of Three (5)*/
            System.arraycopy(random, 0, copy, 0, random.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (5)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Random");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort2(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            time2 += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }


            /*Median of Three (10)*/
            System.arraycopy(random, 0, copy, 0, random.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (10)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Random");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort3(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            time3 += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }


            /*Median of Three (20)*/
            System.arraycopy(random, 0, copy, 0, random.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (20)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Random");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort4(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            time4 += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }


            /*Random Pivot (5)*/
            System.arraycopy(random, 0, copy, 0, random.length );

            if(trace)
            {
                System.out.println("Algorithm: Random Pivot (5)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Random");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort5(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            time5 += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }


            /*MergeSort*/
            System.arraycopy(random, 0, copy, 0, random.length );

            if(trace)
            {
                System.out.println("Algorithm: MergeSort");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Random");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.mergeSort(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            time6 += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }


        if (arraySize <= 100000)
        {
            fileOut.println("Algorithm: Simple QuickSort");
            fileOut.println("Array Size: " + arraySize);
            fileOut.println("Order: Random");
            fileOut.println("Number of trials: " + trialNumber);
            fileOut.println("Average time per trial: " + (time1 / trialNumber / 1000000000) + " seconds\n");
        }

        fileOut.println("Algorithm: Median of Three (5)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Random");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (time2 / trialNumber / 1000000000) + " seconds\n");

        fileOut.println("Algorithm: Median of Three (10)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Random");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (time3 / trialNumber / 1000000000) + " seconds\n");

        fileOut.println("Algorithm: Median of Three (20)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Random");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (time4 / trialNumber / 1000000000) + " seconds\n");

        fileOut.println("Algorithm: Random Pivot (5)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Random");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (time5 / trialNumber / 1000000000) + " seconds\n");

        fileOut.println("Algorithm: MergeSort");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Random");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (time6 / trialNumber / 1000000000) + " seconds\n");


        //***********************************SORTED***********************************//
        /*SIMPLE QUICKSORT*/
        if (arraySize <= 100000)
        {
            timeTotal = 0;
            for (int i = 0; i < trialNumber; i++) {
                System.arraycopy(sorted, 0, copy, 0, sorted.length);

                if (trace) {
                    System.out.println("Algorithm: Simple QuickSort");
                    System.out.println("Array Size: " + arraySize);
                    System.out.println("Order: Sorted");
                    System.out.println("Data in array before sort: " + Arrays.toString(copy));
                }

                timeStart = System.nanoTime();
                Quick.quickSort1(copy, 0, arraySize - 1);
                timeEnd = System.nanoTime();
                timeTaken = timeEnd - timeStart;
                timeTotal += timeTaken;

                if (trace) {
                    System.out.println("Data in array after sort: " + Arrays.toString(copy));
                    System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
                }
            }
            //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
            fileOut.println("Algorithm: Simple QuickSort");
            fileOut.println("Array Size: " + arraySize);
            fileOut.println("Order: Sorted");
            fileOut.println("Number of trials: " + trialNumber);
            fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");
        }

        /*Median of Three (5)*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(sorted, 0, copy, 0, sorted.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (5)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Sorted");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort2(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: Median of Three (5)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Sorted");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");

        /*Median of Three (10)*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(sorted, 0, copy, 0, sorted.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (10)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Sorted");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort3(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: Median of Three (10)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Sorted");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");

        /*Median of Three (20)*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(sorted, 0, copy, 0, sorted.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (20)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Sorted");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort4(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: Median of Three (20)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Sorted");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");

        /*Random Pivot (5)*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(sorted, 0, copy, 0, sorted.length );

            if(trace)
            {
                System.out.println("Algorithm: Random Pivot (5))");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Sorted");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort5(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: Random Pivot (5)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Sorted");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");

        /*MergeSort*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(sorted, 0, copy, 0, sorted.length );

            if(trace)
            {
                System.out.println("Algorithm: MergeSort");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Sorted");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.mergeSort(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: MergeSort");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Sorted");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");


        //*******************************REVERSE SORTED*******************************//
        /*SIMPLE QUICKSORT*/
        if (arraySize <= 100000)
        {
            timeTotal = 0;
            for (int i = 0; i < trialNumber; i++) {
                System.arraycopy(reverseSorted, 0, copy, 0, reverseSorted.length);

                if (trace) {
                    System.out.println("Algorithm: Simple QuickSort");
                    System.out.println("Array Size: " + arraySize);
                    System.out.println("Order: Reverse");
                    System.out.println("Data in array before sort: " + Arrays.toString(copy));
                }

                timeStart = System.nanoTime();
                Quick.quickSort1(copy, 0, arraySize - 1);
                timeEnd = System.nanoTime();
                timeTaken = timeEnd - timeStart;
                timeTotal += timeTaken;

                if (trace) {
                    System.out.println("Data in array after sort: " + Arrays.toString(copy));
                    System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
                }
            }
            //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
            fileOut.println("Algorithm: Simple QuickSort");
            fileOut.println("Array Size: " + arraySize);
            fileOut.println("Order: Reverse");
            fileOut.println("Number of trials: " + trialNumber);
            fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");
        }

        /*Median of Three (5)*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(reverseSorted, 0, copy, 0, reverseSorted.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (5)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Reverse");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort2(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: Median of Three (5)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Reverse");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");

        /*Median of Three (10)*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(reverseSorted, 0, copy, 0, reverseSorted.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (10)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Reverse");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort3(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: Median of Three (10)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Reverse");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");

        /*Median of Three (20)*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(reverseSorted, 0, copy, 0, reverseSorted.length );

            if(trace)
            {
                System.out.println("Algorithm: Median of Three (20)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Reverse");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort4(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: Median of Three (20)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Reverse");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");

        /*Random Pivot (5)*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(reverseSorted, 0, copy, 0, reverseSorted.length );

            if(trace)
            {
                System.out.println("Algorithm: Random Pivot (5)");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Reverse");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.quickSort5(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: Random Pivot (5)");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Reverse");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.println("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds\n");

        /*MergeSort*/
        timeTotal = 0;
        for (int i = 0; i < trialNumber; i++)
        {
            System.arraycopy(reverseSorted, 0, copy, 0, reverseSorted.length );

            if(trace)
            {
                System.out.println("Algorithm: MergeSort");
                System.out.println("Array Size: " + arraySize);
                System.out.println("Order: Reverse");
                System.out.println("Data in array before sort: " + Arrays.toString(copy));
            }

            timeStart = System.nanoTime();
            TextMergeQuick.mergeSort(copy, 0, arraySize - 1);
            timeEnd = System.nanoTime();
            timeTaken = timeEnd - timeStart;
            timeTotal += timeTaken;

            if(trace)
            {
                System.out.println("Data in array after sort: " + Arrays.toString(copy));
                System.out.println("Time for run " + (i + 1) + ": " + timeTaken / 1000000000 + " sec.\n");
            }
        }
        //System.out.println("Average time: " + timeTotal / trialNumber / 1000000000 + "\n");
        fileOut.println("Algorithm: MergeSort");
        fileOut.println("Array Size: " + arraySize);
        fileOut.println("Order: Reverse");
        fileOut.println("Number of trials: " + trialNumber);
        fileOut.print("Average time per trial: " + (timeTotal / trialNumber / 1000000000) + " seconds");

        fileOut.close();
    }
}