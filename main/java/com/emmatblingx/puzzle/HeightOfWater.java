package com.emmatblingx.puzzle;

public class HeightOfWater{
    //{0,1,0,2,1,0,1,3,2,1,2,1}
    public int getAmountOfWater(int[] elevations){
        int count = 0;
        int current = 0;

        while (current < (elevations.length - 1)){
            if(elevations[current] > 0 && (elevations[current] > elevations[current + 1])) ++count;

            ++current;
        }

        return 0;
    }
}
