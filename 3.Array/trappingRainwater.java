//Q) Given a non-negative integers representing an elevation map where the width of each br is 1 , compute how much water it can trap after raining.


public class trappingRainwater {
    public static int getRainwater(int height[]){
        int n=height.length;
        //arbitarary array/helper array to calculate left max
       int leftMax[]=new int[n]; 
       leftMax[0] =  height[0];
       for (int i = 1; i < n; i++) {
        leftMax[i]=Math.max(height[i],leftMax[i-1]);
       }
        //arbitarary array/helper array to calculate right max
       int rightMax[]=new int[height.length] ;
        rightMax[n-1]= height[n-1];
        for (int i = n-2; i >=0; i-- ) {
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        int trappedWater=0;
        for (int i = 0; i < n; i++) {
            //waterLevel=min(leftmax boundary,rightmax boundary)
           int waterLevel=Math.min(leftMax[i],rightMax[i]);
           //trapped water= waterLevel + height[i]
           trappedWater+=waterLevel-height[i];
        }

        
        
        return trappedWater;
    }
    
    
    public static void main(String[] args) {
        int height[] ={4,2,0,6,3,2,5};
       System.out.println("trapped rain water level is : "+ getRainwater(height));

    }
}
