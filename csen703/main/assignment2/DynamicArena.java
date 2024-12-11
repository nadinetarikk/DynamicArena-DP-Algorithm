package csen703.main.assignment2;
import java.util.*;
public class DynamicArena {
    public static int ClimbDynamicArenaDP(int [] floors){
        Hashtable <String,Integer> dp = new Hashtable<>();
        int max = 0;
        if(floors.length<=1){
            return 0 ;
        }
        else{

        
            for(int i =0 ; i< floors.length;i++){
                for(int j =i+1 ;j<floors.length;j++){

                    if(floors[j]>floors[i]){
                        // System.out.println("i: "+floors[i]+" ,j: "+floors[j]);
                        if(!dp.containsKey(Arrays.toString(Arrays.copyOfRange(floors, i, j)))){
                            int[] subArray = (j + 2 < floors.length) 
                            ? Arrays.copyOfRange(floors, j + 2, floors.length) 
                                : new int[0];
                            System.out.println();
                            int returned=ClimbDynamicArenaDP(subArray);
                            // System.out.println("returned: "+returned);
                            max=Math.max(max,(floors[j]-floors[i])+returned);
                            dp.put(Arrays.toString(subArray), returned);
                            // System.out.println(dp.toString());
                        }
                    
                        else{
                            max=Math.max(max,(j-i)+dp.get(Arrays.toString(Arrays.copyOfRange(floors, i, j))));
                            System.out.println("hamada");
                        }
                    }
                }
            }
            return max;
        }
        
    }

    public static void main(String[] args) {
        //int[] floors= {8, 8, 8, 9, 2, 8, 5, 8, 0, 8, 0, 1, 0, 1, 3, 0, 2, 8, 5, 5, 6, 9, 10, 1, 2, 1, 4, 7, 6, 4, 5, 2, 0, 2, 9, 5, 10, 8, 3, 3, 3, 1, 1, 8, 4, 2, 1, 10, 7, 7};
        int [] floors = {1,2,3,0,5};
        System.out.println(ClimbDynamicArenaDP((floors)));
    }
}