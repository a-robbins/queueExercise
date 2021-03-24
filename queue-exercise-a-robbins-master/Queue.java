public class Queue<Item> {
    Stack<Item> s1;
    Stack<Item> s2;

    public Queue() {
        s1 = new Stack<Item>();
        s2 = new Stack<Item>();
    }


    // push all new items onto stack 1
    public void push(Item item) {
        s1.push(item);
    }

    // which stack should we pop from to return something back to the caller?
    // when should we pop everything from stack 1 onto stack 2?
    public Item pop() {
        if (s2.isEmpty() && !s1.isEmpty()) {
            for (int i = 0; !s1.isEmpty(); i++) {
                Item val = s1.pop();
                s2.push(val);
            }
        }
        else if(s1.isEmpty() && s2.isEmpty())
        {
            return null;
        }
        else {
            return s2.pop();
        }
        return s2.pop();
    }


    // how similiar should this function implementation be to pop()?
    public Item peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        else if (s2.isEmpty() && !s1.isEmpty()) {

                for (int i = 0; !s1.isEmpty(); i++) {
                    Item val = s1.pop();
                    s2.push(val);
                }
        }
        if (s1.isEmpty() && s2.isEmpty()) {
            return null;
        }
        return s2.peek();
    }

        // make sure to fully flesh out this check
        public boolean isEmpty () {
            return s1.isEmpty();
        }

        public static void main (String[]args){
            Queue<String> q = new Queue<String>();

            while (!StdIn.isEmpty()) {
                String cmd = StdIn.readString();
                if (cmd.equals("push")) {
                    cmd = StdIn.readString();
                    q.push(cmd);
                }
                else if (cmd.equals("pop")) {
                    cmd = q.pop();
                    StdOut.printf("popped: %s\n", cmd);
                }
                else if (cmd.equals("isEmpty")) {
                    if (q.isEmpty()) {
                        StdOut.println("The queue is empty");
                    }
                    else {
                        StdOut.println("The queue is not empty");
                    }
                }
                else if (cmd.equals("peek")) {
                    cmd = q.peek();
                    StdOut.printf("peek: %s\n", cmd);
                }
                else {
                    StdOut.println("I don't know that command");
                }
            }
        }
    }


