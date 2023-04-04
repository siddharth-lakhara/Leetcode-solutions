package _881;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int firstPtr = 0;
        int lastPtr = people.length-1;
        int numOfBoats = 0;

        Arrays.sort(people);
        
        while (firstPtr <= lastPtr) {
            if (firstPtr == lastPtr) {
                numOfBoats++;
                break;
            }
            
            if (people[lastPtr] >= limit || people[firstPtr] + people[lastPtr] > limit) {
                lastPtr--;
                numOfBoats++;
            } else {
                lastPtr--;
                firstPtr++;
                numOfBoats++;
            }
        }
        
        return numOfBoats;
    }

    public void driver() {
        int[] people = new int[]{3,2,2,1};
        int limit = 3;
        int answer = numRescueBoats(people, limit);
        System.out.println(answer);
    }
}
