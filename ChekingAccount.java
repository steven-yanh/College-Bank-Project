import java.util.Scanner;

public class ChekingAccount extends BankAccount
{
    private MonetaryValue overdraftlimit;
    public ChekingAccount()
    {
        super();
        overdraftlimit = new MonetaryValue();
    }
    public ChekingAccount(int num,Name n,MonetaryValue b,MonetaryValue over)
    {
        super(num, n, b);
        overdraftlimit = new MonetaryValue(over);
    }
    public ChekingAccount(ChekingAccount old)
    {
        super((BankAccount)old);
        this.overdraftlimit = new MonetaryValue(old.overdraftlimit);
    }
    @Override
    public boolean equals(Object other)
    {   
        if(other instanceof ChekingAccount)
            if(super.equals((BankAccount)other))
                if(this.overdraftlimit.equals(((ChekingAccount)other).overdraftlimit))
                    return true;
                else 
                    return false;
            else
                return false;
        else
            return false;
    }       
    @Override
    public String toString()
    {
        return "Cheking Account: "+this.getAccountNumber()
                +"\nAccount Holder: "+super.printName()
                +"\nAccount Balance: "+super.printBalance()
                +"\nOverdraft limit: "+overdraftlimit;
    }
    public MonetaryValue getBalance()
    {
        return balance;
    }
    @Override
    public boolean withdraw(MonetaryValue amount)
    {
        MonetaryValue newBalance = new MonetaryValue(balance);
        newBalance.add(overdraftlimit);
        if(amount.isNegative() || amount.isGreaterThan(newBalance))
            return false;
        else
        {
            balance.subtract(amount);
            return true;
        }   
    }
    public ChekingAccount read(Scanner sc) 
    {
        ChekingAccount acc = new ChekingAccount();
        Name n = new Name();
        MonetaryValue b = new MonetaryValue();
        MonetaryValue over = new MonetaryValue();
        if(sc.hasNext())
        {
            int i = sc.nextInt();
            n = new Name(sc.next(),sc.next());
            b = new MonetaryValue(sc.nextDouble());
            over = new MonetaryValue(sc.nextDouble());
            acc = new ChekingAccount(i, n, b,over);
        }
        return acc;
    }
}
