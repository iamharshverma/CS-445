import java.util.*;

public class MultiDS<T> implements PrimQ<T>, Reorder
{
    private Object [] data;
    private int numItems;
    private int max;

    public MultiDS(int size)
    {
        data = new Object[size];
        numItems = 0;
        max = size;
    }

    public boolean addItem(T a)
    {
        if(numItems <= max)
        {
            //System.out.println(a);
            //System.out.println(numItems);
            data[numItems] = a;
            numItems++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public T removeItem()
    {
        if(numItems == 0)
        {
            return null;
        }
        else
        {
            T temp = (T) data[0];
            for(int i = 0; i < numItems -1; i++)
            {
                data[i] = data[i + 1];
            }
            data[numItems - 1] = null;
            numItems--;
            return temp;
        }
    }

    public boolean full()
    {
        return numItems >= max;
    }

    public boolean empty()
    {
        if(numItems == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int size()
    {
        return numItems;
    }

    public void clear()
    {
        numItems = 0;
    }

    public void reverse()
    {
        T temp;
        for(int i = 0; i < (numItems) /2 ; i++)
        {
            temp = (T) data[i];
            data[i] = data[numItems - 1 - i];
            data[numItems - 1 - i] = temp;
        }
    }

    public void shiftRight()
    {
        T last = (T) data[numItems - 1];
        //System.out.println("Last: " + last);
        for(int i = numItems - 2; i >= 0; i--)
        {
            //System.out.println("Data in spot " + data[i + 1] + " moved to " + data[i]);
            data[i + 1] = data[i];
        }
        data[0] = last;
    }

    public void shiftLeft()
    {
        T first = (T) data[0];
        for(int i = 0; i < numItems - 1; i++)
        {
            data[i] = data[i + 1];
        }
        data[numItems - 1] = first;
    }

    public void shuffle()
    {
        Random rnd = new Random();
        for (int i = numItems - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            T a = (T) data[index];
            data[index] = data[i];
            data[i] = a;
        }
    }

    public String toString()
    {
        String printData = "Contents:\n";
        for(int i = 0; i < numItems; i++)
        {
            printData = printData + data[i].toString() + " ";
        }
        return printData;
    }
}