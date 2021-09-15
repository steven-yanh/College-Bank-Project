import java.util.Scanner;

public class SavingsAccount extends BankAccount
{
    private static double annualInterstRate = 1.5;
    public SavingsAccount()
    {
        super();
        annualInterstRate = 1.5;
    }
    public SavingsAccount(int num,Name n,MonetaryValue b)
    {
        super(num, n, b);
    }
    public SavingsAccount(SavingsAccount old)
    {
        super((BankAccount)old);
    }
    @Override
    public boolean equals (Object other)
    {
        if(other instanceof SavingsAccount)
            if(super.equals((BankAccount)other))
                return false;
            else
                return false;
        else
            return false;
    }
    @Override 
    public String toString()
    {
        return "SavingsAccount Number: "+this.getAccountNumber()
                +"\nAccount Holder: "+this.printName()
                +"\nAccount Balance: "+this.printBalance()
                +"\nAnnual Interest Rate: "+annualInterstRate+"%"
                +"\nMonthly Interest: "+getMonthlyInterest().toString();
    }
    public static boolean setInterestRate (double rate)
    {
        if(rate <=0)
            return false;
        else
        {
            annualInterstRate = rate;
            return true;
        }
    }
    public MonetaryValue getBalance()
    {
        return balance;
    }
    public MonetaryValue getMonthlyInterest()
    { 
        double amount = (balance.getBalance())*(annualInterstRate/12)/100;
        MonetaryValue interest = new MonetaryValue(amount);
        return interest;
    }
    public SavingsAccount read(Scanner sc) 
    {
        SavingsAccount acc = new SavingsAccount();
        Name n = new Name();
        MonetaryValue b = new MonetaryValue();
        if(sc.hasNext())
        {
            int i = sc.nextInt();
            n = new Name(sc.next(),sc.next());
            b = new MonetaryValue(sc.nextDouble());
            acc = new SavingsAccount(i, n, b);
        }
        return acc;
    }
}
