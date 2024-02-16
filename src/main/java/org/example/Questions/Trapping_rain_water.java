package org.example.Questions;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Trapping_rain_water {
    public static void main(String[] args) {

        int trap[] = {3, 2, 0, 5, 1, 3, 6};

        calculateTrappedWater(trap) ;
    }

    public static int calculateTrappedWater(int[] trap) {
        int left_max [] = new int[7] ;
        int right_max [] = new int [7] ;

        if(trap.length == 0 || trap.length ==1){
            return 0 ;
        }

        int lmax = Integer.MIN_VALUE ;
        int rmax = Integer.MIN_VALUE ;

        ///to calculate left max
        for(int i=0;i<7;i++){
            if(trap[i]>lmax){
                left_max[i] = trap[i] ;
                lmax = trap[i] ;
            }else{
                left_max[i] =lmax ;
            }
        }

        // to calculate the right max
        for(int i=6;i>=0;i--){
            if(trap[i]>rmax){
                right_max[i] = trap[i] ;
                rmax = trap[i] ;
            }else{
                right_max[i] = rmax ;
            }
        }

        // System.out.println("the left max is " + Arrays.toString(left_max));
        // System.out.println("the right max is" + Arrays.toString(right_max));
        int total_unit =0 ;
        for(int i=0;i<trap.length ;i++){
            int ans =  Math.min(left_max[i],right_max[i]) - trap[i] ;
            if(ans>0){
                total_unit += ans ;
            }

        }
        System.out.println("the total unit of water got stored is  "+ total_unit);

        return total_unit ;
    }

}

//// The time complexity for the code is going to be O(n)