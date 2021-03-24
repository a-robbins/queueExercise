public class TestBothEmpty {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();

        if (q.pop() == null)
        {
            StdOut.println("Test passed!");
        }

    }
}
