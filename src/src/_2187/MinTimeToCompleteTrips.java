package _2187;

public class MinTimeToCompleteTrips {

    public long minimumTime(int[] time, int totalTrips) {
        long currTime = 0;
        while (totalTrips > 0) {
            currTime++;
            for (int t: time) {
                if (currTime%t == 0) {
                    totalTrips--;
                    if (totalTrips <=0) {
                        break;
                    }
                }
            }
        }
        return currTime;
    }

    public void driver() {
        int[] time = new int[]{2};
        int totalTrips = 1;
        long answer = minimumTime(time, totalTrips);
        System.out.println(answer);
    }

}
