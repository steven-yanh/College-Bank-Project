import java.util.Scanner;

public class MonetaryValue 
{
    private int cents;
    public MonetaryValue()
    {
        cents = 0;
    }
    public MonetaryValue(double value)
    {
        cents =(int)(value*100);
    }
    public MonetaryValue(MonetaryValue old)
    {
        this.cents = old.cents;
    }
    @Override
    public boolean equals(Object old)
    {
        if(old instanceof MonetaryValue)
            if(((MonetaryValue)old).cents == this.cents)
                return true;
            else
                return false;
        else return false;
    }
    @Override
    public String toString()
    {
        if(this.isNegative())
            return "-" + String.format("$%.2f", ((float)cents)/100);
        else 
            return String.format("$%.2f", ((float)cents)/100);
    }
    public boolean isLessThan (MonetaryValue other)
    {
        if(this.cents < other.cents)
            return true;
        else
            return false;
    }
    public boolean isGreaterThan (MonetaryValue other)
    {
        if(this.cents > other.cents)
            return true;
        else
            return false;
    }
    public boolean isNegative()
    {
        if(this.cents < 0)
            return true;
        else   
            return false;
    }
    public double doubleValue()
    {
        double value = ((double)cents)/100;
        return value;
    }
    public boolean add(MonetaryValue add)
    {
        if (add.isNegative())
            return false;
        else 
        {
            this.cents += add.cents;
            return true;
        }
    }
    public boolean subtract(MonetaryValue sub)
    {
        if(sub.isNegative())
            return false;
        else
        {
            this.cents -= sub.cents;
            return true;
        }
    }
    public static MonetaryValue read(Scanner sc)
    {
        MonetaryValue m = new MonetaryValue();
        if(sc.hasNext())
            m.cents = (sc.nextInt());
        else
            return null;
        return m;
    }
    public double getBalance()
    {
        return cents/100;
    }
}
//     public static void main(String[] args) 
//     {
//         MonetaryValue x = new MonetaryValue(88.34);
//         System.out.println(x.toString());
//     }

