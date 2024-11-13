import java.util.*;

public class Fibo{

    public static int stepCountR=0,stepCountI=0;

    public static int fiboR(int n){
        stepCountR++;
        if(n<=1) return n;
        return fiboR(n-1)+fiboR(n-2);
    }

    public static int fiboI(int n){
        if(n<=1) return n;
        
        int a=0,b=1,result=0;

        for(int i=2;i<=n;i++){
            result=a+b;
            a=b;
            b=result;
            stepCountI++;
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int res1=fiboR(n);
        int res2=fiboI(n);
        System.out.println(n+"th fibonacci number: "+res1);
        System.out.println("Step count using recursive method: "+stepCountR);
        System.out.println("Step countusing iterative method: "+stepCountI);
    }
}