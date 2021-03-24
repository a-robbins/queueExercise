public class TestSmall {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();

        for (int i = 0; i < 10; i++) {
            q.push(i);
        }

        for (int i = 0; i < 10; i++) {
            int x = q.pop();
            if (i != x) {
                StdOut.printf("should have got %d but got %d\n", i, x);
                System.exit(1);
            }
        }
        StdOut.println("Test passed!");
    }
}
