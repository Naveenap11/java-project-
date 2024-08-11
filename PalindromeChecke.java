import java.util.Scanner;
public class PalindromeChecke
{
    public static void main(String[] args)
    {


        String reverse="";
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter a word or phrase: ");
        String a=sc.nextLine();
        int length=a.length();
        for(int i= length-1;i>=0;i--)
        {
            reverse=reverse+a.charAt(i);
        }
        if(a.equals(reverse))
        {
            System.out.println("\"" + a + "\" is a palindrome.");
        }
        else
        {
            System.out.println("\"" + a + "\" is not a palindrome.");
        }
    }
}
