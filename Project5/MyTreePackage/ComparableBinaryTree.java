package MyTreePackage;


public class ComparableBinaryTree<T extends Comparable<? super T>> extends BinaryTree<T> implements ComparableTreeInterface<T>
{

    public ComparableBinaryTree()
    {
        super();
    } // end default constructor



    public T getMax()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            return rMax(getRootNode(), null);
        }
    }
    public T rMax(BinaryNode<T> node, T max)
    {
        if(!isEmpty())
        {
            if(node.hasLeftChild())
                max = rMax(node.getLeftChild(), max);
            if(node.hasRightChild())
                max = rMax(node.getRightChild(), max);

            if (max == null)
                max = node.getData();
            else if (max.compareTo(node.getData()) == -1)
                max = node.getData();
        }

        return max;
    }

    // If the tree is not empty, return the maximum
    // value in the tree; otherwise return null


    /*
    public T getMin()
    {
        minValue(getRootNode());

        return (T)min;
    }
    public void minValue(BinaryNode<T> node)
    {
        if(node == null)
            min = null;
            return;
        if(node.getData().compareTo(min) < 0)
            min.setData(node.getData());
        if(node.getLeftChild() !=null && node.getLeftChild().getData().compareTo(min) < 0)
            min.setData(node.getLeftChild().getData());
        if(node.getRightChild() !=null && node.getRightChild().getData().compareTo(min) < 0)
            min = (Integer)node.getRightChild().getData();
        minValue(node.getLeftChild(), min);
        minValue(node.getRightChild(), min);
    }*/

    public T getMin()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            return rMin(getRootNode(), null);
        }
    }
    public T rMin(BinaryNode<T> node, T min)
    {
        if(!isEmpty())
        {
            if(node.hasLeftChild())
            {
                min = rMin(node.getLeftChild(), min);
            }
            if(node.hasRightChild())
            {
                min = rMin(node.getRightChild(), min);
            }

            if (min == null) //if neither side has a child, set min to the node
            {
                min = node.getData();
            }
            else if (min.compareTo(node.getData()) == 1)
            {
                min = node.getData();
            }
        }

        return min;
    }



    public boolean isBST()
    {
        return bst(getRootNode());
    }
    public boolean bst(BinaryNode<T> node)
    {
        if(node.getData() == null)
        {
            return true;
        }

        if(node.getLeftChild() != null && node.getData().compareTo(node.getLeftChild().getData()) < 0) {
            return false;
        }

        if(node.getRightChild() != null && node.getData().compareTo(node.getRightChild().getData()) < 0) {
            return false;
        }

        return (node.getLeftChild() == null || bst(node.getLeftChild())) && (node.getRightChild() == null || bst(node.getRightChild()));
    }
    // Return true if the the tree meets the
    // recursive definition of a BST; else
    // return false
}