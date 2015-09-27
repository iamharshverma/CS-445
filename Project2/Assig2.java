import java.util.*;
import java.io.*;

public class Assig2
{
    private static ArrayStack<Crate> crates = new ArrayStack<Crate>(50);
    private static ArrayStack<Crate> tempCrates = new ArrayStack<Crate>(50);

    public static void main(String []args)
    {
        Crate crateOnCounter = null;
        int bClock = 0; //Banana Epoch
        int mrCrates = 0;
        double mrbCost = 0;
        int mrMoves = 0;
        double mrLabor = 0;
        double mrCost = 0;
        int tCrates = 0;
        double tbCost = 0;
        int tMoves = 0;
        double tLabor = 0;
        double tCost = 0;
        Scanner useri = new Scanner(System.in);
        System.out.println("What file would you like to read in?");
        String input = useri.nextLine();

        File inData = new File(input);
        Scanner dataIn = null;
        try
        {dataIn = new Scanner(inData);}
        catch (Exception e){}

        while (dataIn.hasNextLine())
        {
            String firstStep = dataIn.nextLine();
            if(firstStep.equals("receive"))
            {
               int sCount = Integer.parseInt(dataIn.nextLine());
               mrCrates = 0;
               mrbCost = 0;
               mrMoves = 0;
               mrLabor = 0;

               for(int j = 0; j < sCount; j++)
               {

                   int date = dataIn.nextInt();
                   int count = dataIn.nextInt();
                   double cost = dataIn.nextDouble();
                   dataIn.nextLine();
                   Crate truck = new Crate(date, count, cost);
                   mrCrates++;
                   mrbCost = mrbCost + cost;

                   if(crates.isEmpty())
                   {
                       mrMoves++;
                       crates.push(truck);
                   }
                   else
                   {
                       if(crates.peek().compareTo(truck) >= 0)
                       {
                           mrMoves++;
                           crates.push(truck);
                       }
                       else
                       {
                           while (!crates.isEmpty() && crates.peek().compareTo(truck) < 0)
                           {
                               mrMoves++;
                               tempCrates.push(crates.pop());
                           }
                           mrMoves++;
                           crates.push(truck);
                           while (!tempCrates.isEmpty())
                           {
                               mrMoves++;
                               crates.push(tempCrates.pop());
                           }
                       }
                   }

               }

                mrLabor = mrMoves;
                tLabor = tLabor + mrLabor;
                tCrates = tCrates + mrCrates;
                tbCost = tbCost + mrbCost;
                tMoves = tMoves + mrMoves;
                System.out.println("Receiving " + mrCrates + " crates of bananas");

                /*
                int sCount = Integer.parseInt(dataIn.nextLine());
                for(int i = 0; i < sCount; i++)
                {
                    int date = dataIn.nextInt();
                    int count = dataIn.nextInt();
                    double cost = dataIn.nextDouble();
                    dataIn.nextLine();
                    crates.push(new Crate(date, count, cost));
                    mrCrates++;
                    mrbCost = mrbCost + cost;
                }
                tCrates = tCrates + mrCrates;
                tbCost = tbCost + mrbCost;
                System.out.println("Receiving " + mrCrates + " crates of bananas");
                */
            }
            if(firstStep.equals("use"))
            {
                int needed = Integer.parseInt(dataIn.nextLine()); //number a bananas needed for the order
                int stillNeeded = needed; //Number of bananas that are still needed
                int used; //Number of bananas used from a crate
                int inCrate;
                System.out.println(needed + " bananas needed for order");

                if(crateOnCounter == null && !crates.isEmpty())
                {
                    crateOnCounter = crates.pop();
                    System.out.println("Getting crate: " + crateOnCounter + "\tfrom the stack");
                }

                if (crates.isEmpty())
                {
                    System.out.println("Store is out of bananas! The horror!");
                    stillNeeded = 0;
                }


                while (stillNeeded > 0)
                {
                    inCrate = crateOnCounter.getCurrentBC();
                    if (stillNeeded <= inCrate)
                    {
                        used = stillNeeded;
                        if ((inCrate - stillNeeded) == 0)
                        {
                            System.out.println(inCrate + " bananas used from current crate.");
                            stillNeeded = inCrate - stillNeeded;
                            crateOnCounter = crates.pop();
                            System.out.println("Crate on counter emptied, getting crate: " + crateOnCounter + " from stack");
                        }
                        else
                        {
                            crateOnCounter.setCurrentBC(crateOnCounter.getCurrentBC() - used);
                            System.out.println(used + " bananas used from current crate.");
                            stillNeeded = stillNeeded - used;
                        }
                    }
                    else
                    {
                        used = inCrate;
                        if (inCrate >= 1)
                        {
                            System.out.println(used + " bananas used from current crate.");
                            stillNeeded = stillNeeded - used;
                            crateOnCounter = crates.pop();
                            System.out.println("Getting crate: " + crateOnCounter + "\tfrom the stack");
                        }
                        else
                        {
                            crateOnCounter = crates.pop();
                            System.out.println("Getting crate: " + crateOnCounter + "\tfrom the stack");
                        }
                    }
                }
            }
            if(firstStep.equals("display"))
            {
                if (crates.isEmpty())
                {
                    System.out.println("No crates in the stack - please reorder!");
                }
                else
                {
                    if(crateOnCounter != null)
                    {
                        System.out.println("Current crate: " + crateOnCounter);
                    }
                    System.out.println("Stack crates (top to bottom)");
                    while (!crates.isEmpty())
                    {
                        Crate temp = crates.pop();
                        System.out.println(temp);
                        tempCrates.push(temp);
                    }
                    while (!tempCrates.isEmpty())
                    {
                        Crate temp = tempCrates.pop();
                        crates.push(temp);
                    }
                }

            }
            if(firstStep.equals("skip"))
            {
                bClock++;
                boolean top = false;
                System.out.println("The current Day is now Day " + bClock);
                if(!crates.isEmpty())
                {
                    if (bClock > crateOnCounter.getExpirationDate())
                    {
                        System.out.println("Current crate: " + crateOnCounter.toString() + " is expired!");
                    }
                    while (bClock > crates.peek().getExpirationDate())
                    {
                        System.out.println("Top crate: " + crates.pop() + " is expired!");
                    }

                }
            }
            if(firstStep.equals("report"))
            {
                mrCost = mrbCost + mrLabor;
                System.out.println("Lickety Splits Financial Statement:");
                System.out.println("\tMost Recent Shipment:");
                System.out.println("\t\tCrates: " + mrCrates);
                System.out.println("\t\tBanana cost: " + mrbCost);
                System.out.println("\t\tLabor (moves): " + mrMoves);
                System.out.println("\t\tLabor cost: " + mrLabor);
                System.out.println("\t\t----------------------");
                System.out.println("\t\tTotal cost: " + mrCost);

                tCost = tbCost + tLabor;
                System.out.println("\n\tOverall Expenses");
                System.out.println("\t\tCrates: " + tCrates);
                System.out.println("\t\tBanana cost: " + tbCost);
                System.out.println("\t\tLabor (moves): " + tMoves);
                System.out.println("\t\tLabor cost: " + tLabor);
                System.out.println("\t\t----------------------");
                System.out.println("\t\tTotal cost: " + tCost);
            }
            System.out.println();
        }
        System.out.println("End of Simulation");
    }

}
