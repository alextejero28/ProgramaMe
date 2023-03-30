import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author alex
 */
public class ConstanteKaprekar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int iteraciones, n, numeroVueltas, nAsc, nDesc;
                
        iteraciones = sc.nextInt();
        
        String number, numberAsc = "", numberDesc = "";
        
        int[] resultado = new int[iteraciones];
        int[] digits;
        
        for (int i = 0; i < iteraciones; i++) {
            numeroVueltas = 0;
            n = sc.nextInt();

            

            while(n!=6174){
            
            number = String.valueOf(n);
            
            switch (number.length()) {
                case 1 -> number = "000" + number;
                case 2 -> number = "00" + number;
                case 3 -> number = "0" + number;
                default -> {
                }
            }
            
            digits = new int[number.length()];
            
            for (int j = 0; j < number.length(); j++) {
                 digits[j] = Character.digit(number.charAt(j), 10);                
            }
            
            Arrays.sort(digits);
            
            for (int k = 0; k < number.length(); k++) {
                numberAsc += digits[k];
            }

            for (int l = number.length()- 1; l >= 0; l--) {
                numberDesc += digits[l];
            }

            nAsc = Integer.parseInt(numberAsc);
            nDesc = Integer.parseInt(numberDesc);

            if(nAsc > nDesc){
                n = nAsc - nDesc;
            }else{
                n = nDesc - nAsc;
            }
            
            numeroVueltas++;
            
            
            
            
            
            
        }
        resultado[i] = numeroVueltas;
        
    }

    for(r = 0; r < iteraciones; r++){
        System.out.println(resultado[r]);
    }

    
}
}