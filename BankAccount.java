public class BankAccount
{
    private int accountNumber;
    private Name name;
    protected MonetaryValue balance;
    
    public BankAccount ()
    {
        accountNumber = 0;
        name = new Name();
        balance = new MonetaryValue();
    }
    public BankAccount(int num,Name n,MonetaryValue b)
    {
        accountNumber = num;
        name = new Name(n);
        balance = new MonetaryValue(b);
    }
    public BankAccount(BankAccount old)
    {
        this.accountNumber = old.accountNumber;
        this.name = new Name(old.name);
        this.balance = new MonetaryValue(old.balance);
    }
    @Override
    public boolean equals (Object other)
    {
        if(other instanceof BankAccount)
            if(((BankAccount)other).accountNumber == this.accountNumber && ((BankAccount)other).balance == this.balance &&
             ((BankAccount)other).name == this.name)
                return true;
            else
                return false;
        else return false;
        
    }
    @Override
    public String toString()
    {
        return "Account Number: "+ accountNumber+
                "\n Account Holder: "+ name.toString()+
                "\n Account balance: "+ balance+
                "\n";
    }
    public int getAccountNumber()
    {
        return accountNumber;
    }
    public MonetaryValue getBalance()
    {
        return balance;
    }
    public boolean deposit(MonetaryValue amount)
    {
        if(amount.isNegative())
            return false;
        else
        {
            balance.add(amount);
            return true;
        }   
    }
    public boolean withdraw(MonetaryValue amount)
    {
        if(amount.isNegative() || amount.isGreaterThan(balance))
            return false;
        else
        {
            balance.subtract(amount);
            return true;
        }   
    }
    public String printName()
    {
        return name.toString();
    }
    public String printBalance()
    {
        return balance.toString();
    }
}
