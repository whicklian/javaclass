public class MinExample {
    public static int min(int num1, int num2){
        int result;
        if (num1 < num2)
            result = num1;
        else
            result = num2;
        return result;
    }
    public static void main(String[] args){
        int x = 22;
        int y = 15;
        int z = min(x, y);
        System.out.println("The minimum of " + x + " and " + y + " is " + z);
    }
}
