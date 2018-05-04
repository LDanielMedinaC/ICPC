import java.util.Scanner;

public class A{

    public static long factiorial(int n){
        long ans = 1;
        for(int i = 2; i <= n; i++)
            ans *= (long)i;
        return ans;
    }

    public static long permutation(int[] rep){
        long divident = 0;
        long divisor  = 1;
        for(int i = 0; i <= 9; i++){
            divisor *= factiorial(rep[i]); 
            divident += rep[i];
        }
        return factiorial((int)divident)/divisor;
    }

    public static void calc(String num){
        int[] rep = new int[11];
        long pot = 1;
        long sumPot = 0;
        long ans = 0;
        for(int i = 0; i < num.length();i++){
            rep[(int)num.charAt(i) - (int)'0']++;
            sumPot += pot;
            pot = pot*10;
        }
        for(int i = 0; i < 10; i++){
            if(rep[i] != 0){
                rep[i]--;
                ans += permutation(rep)*sumPot*i;   
                rep[i]++; 
            } 
        }
        System.out.println(permutation(rep) + " " + ans);
    } 

    public static void main(String[] stg){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        String number = "";
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            number = sc.next();
            calc(number);
            //System.out.println(calc(number));
        }
    }

}