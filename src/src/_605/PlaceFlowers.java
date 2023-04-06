package _605;

public class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (n<=0) {
                break;
            }
            
            if (flowerbed[i] == 0) {
                boolean canPlaceOnLeft = true;
                if (i-1>=0 && flowerbed[i-1] == 1) {
                    canPlaceOnLeft = false;
                }
                boolean canPlaceOnRight = true;
                if (i+1<flowerbed.length && flowerbed[i+1] == 1) {
                    canPlaceOnRight = false;
                }
                
                if (canPlaceOnLeft && canPlaceOnRight) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
            
        }
        
        return n<=0;
    }
    
    public void driver() {
        int[] flowerbed = new int[] {1,0,0,0,1};
        int n = 2;
        boolean answer = canPlaceFlowers(flowerbed, n);
        System.out.println(answer);
    }
}
