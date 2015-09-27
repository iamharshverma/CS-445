public class Crate implements Comparable<Crate>
{

    private int expirationDate;
    private int initialBC;
    private int currentBC;
    private double crateCost;

    public Crate(int ed, int ibc, double cc)
    {
        expirationDate = ed;
        initialBC = ibc;
        currentBC = ibc;
        crateCost = cc;
    }
    public int compareTo(Crate comp)
    {
        if(this.getExpirationDate() < comp.getExpirationDate())
        {
            return -1;
        }
        else if(this.getExpirationDate() == comp.getExpirationDate())
        {
            return 0;
        }
        else//(this.getExpirationDate() > comp.getExpirationDate())
        {
            return 1;
        }
    }


    public void setExpirationDate(int date)
    {
        expirationDate = date;
    }
    public void setInitialBC(int ibc)
    {
        initialBC = ibc;
    }
    public void setCurrentBC(int cbc)
    {
        currentBC = cbc;
    }
    public void setCrateCost(double cc)
    {
        crateCost = cc;
    }

    public int getExpirationDate()
    {
        return expirationDate;
    }
    public int getInitialBC()
    {
        return initialBC;
    }
    public int getCurrentBC()
    {
        return currentBC;
    }
    public double getCrateCost()
    {
        return crateCost;
    }

    public String toString()
    {
        String sendBack = "Expires: " + getExpirationDate() + "\tStart Count: " + getInitialBC() + "\tRemain: " + getCurrentBC() + "\tCost: " + getCrateCost();
        return sendBack;
    }
}