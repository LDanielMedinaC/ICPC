import java.util.*;

public class C{

    public static void calc(String adn){
        int[] counter = new int[2050];///lo voy a utilizar como un map, podriamos utilizar map y no necesitariamos pasar la cadena a numero, pero asi es mas rapido.
        int value = 0;
        int ans= 0;
        int length = 0;
        for(int i =0; i < adn.length();i++){
            if(adn.charAt(i) == 'A' || adn.charAt(i) == 'T'){
                length++;
                value *= 2;
                value %= 2048;
                if(adn.charAt(i) == 'A')
                    value++;
                
                if(length >= 10)
                    counter[value]++;
                
            }else{
                value = 0;
                length = 0;
            }
        }
        for(int i = 0; i < 2048; i++){
            if(counter[i] != 0 && counter[2047-i] != 0){////El 2047 - i sirve para la "negar" el num. i y ver si la cadena opuesta existe.
                ans += counter[i];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] stg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String adn;
        for(int i = 0; i < n; i++){
            adn = sc.next();
            calc(adn);
        }

    }
}