public class Main {
    public static void main(String args[]){

        int i = 3; int k = 1;
        switch(i) {
            case 1: {
                k += 1;
                System.out.println(1);
            }
            case 2: {
                k++;
                System.out.println(2);
            }
            case 3: {
                k = 0;
                System.out.println(3);
            }
            case 4: {
                k += 3;
                System.out.println(4);
            }
            case 5: {
                k -= 10;
                System.out.println(5);
            }
            default: k--;
        }
        System.out.print(k);

    }
}