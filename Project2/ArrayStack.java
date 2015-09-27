import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T>
{
    private Object [] data;
    private int top;

    public ArrayStack(int size)
    {
        data = new Object[size];
        top = -1;
    }

    /** Adds a new entry to the top of this stack.
     @param newEntry an object to be added to the stack */
    public void push(T newEntry)
    {
        if (top >= data.length - 1)
        {
            Object [] switchArray = Arrays.copyOf(data, (data.length * 2));
            data = switchArray;
        }
        top++;
        data[top] = newEntry;
    }

    /** Removes and returns this stack’s top entry.
     @return either the object at the top of the stack or, if the
     stack is empty before the operation, null */
    public T pop()
    {
        T sendBack = (T) data[top];
        top--;
        return sendBack;
    }

    /** Retrieves this stack’s top entry.
     @return either the object at the top of the stack or null if
     the stack is empty */
    public T peek()
    {
        if (top == -1)
        {
            System.out.println("Stack is empty");
            return null;
        }
        return (T) data[top];

    }

    /** Detects whether this stack is empty.
     @return true if the stack is empty */
    public boolean isEmpty()
    {
        return (top == -1);
    }

    /** Removes all entries from this stack */
    public void clear()
    {
        top = -1;
    }
}