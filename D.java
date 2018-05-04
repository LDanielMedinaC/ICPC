import java.util.*;
import java.math.BigInteger;

public class D{
    public static void main(String[] stg){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String hexNum = sc.next();
            BigInteger num = new BigInteger(hexNum,16);
            if(num.mod(new BigInteger("17")).equals(BigInteger.ZERO)){
                System.out.println("yes");
            }else
                System.out.println("no");
        }
    }
}
