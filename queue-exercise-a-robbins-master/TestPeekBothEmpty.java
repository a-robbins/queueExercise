public class TestPeekBothEmpty {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();

        q.peek();
        if(q.peek() == null)
        {
            StdOut.println("Test Passed!");
        }

    }
}
