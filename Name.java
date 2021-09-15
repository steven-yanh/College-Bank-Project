import java.util.Scanner;

public class Name
{
    private String first;
    private String last;
    public Name()
    {
        first = "";
        last = "";
    }
    public Name(String first, String last)
    {
        this.first = first;
        this.last = last;
    }
    public Name(Name old)
    {
        this.first = new String(old.first);
        this.last = new String(old.last);
    }
    @Override
    public boolean equals (Object old)
    {
        if( old instanceof Name)
            if( ((Name)old).first == this.first && ((Name)old).last == this.last)
                return true;
            else 
                return false;
        else 
            return false;
    }
    @Override
    public String toString()
    {
        return first+" "+last;
    }
    public static Name read(Scanner sc)
    {
        Name name = new Name();
        if(sc.hasNext())
        {
           name = new Name(sc.next(),sc.next());
        }
        else  
            return null;
        return name;
    }
}