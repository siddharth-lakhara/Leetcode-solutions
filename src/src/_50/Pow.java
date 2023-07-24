package _50;

public class Pow {
    public double myPow(double x, int n) {
        if(n>=0){
            return calPower(x,n);
        }
        else{
            return 1/calPower(x,n);
        }
    }

    private double calPower(double x, int n){
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return x;
        }

        double ans=calPower(x,n/2);
        if(n%2!=0){
            return ans*ans*x;
        }
        return ans*ans;
    }
    
    public void driver() {
        double answer = myPow(2.0, 10);
        System.out.println(answer);
    }
}
