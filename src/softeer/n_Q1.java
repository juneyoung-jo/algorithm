package softeer;

import java.util.Arrays;

public class n_Q1 {
	
	public static void main(String[] args) {
		
		int[] prices = {13000, 88000, 10000};
		int[] discounts = {30, 20};
		int answer = 0;
        
        Arrays.sort(prices);
        Arrays.sort(discounts);
        
        int count = discounts.length-1;
                
        for(int i = prices.length-1; i >= 0; i--) {
            
            if(count < 0) answer+= prices[i];
            else{ 
                 answer += prices[i] / 100 * (100-discounts[count]);
                 count--;
            }
        }
	}

}
