# Queue Exercise

For this exercise we will be leverage two stacks(yes two!) instead of an array or linked to implement a queue data structure. We will be able to develop this in such a way that normal FIFO queue ordering and be generated even though we are utilizing LIFO stacks as the backing data store

```


      Back                                          Front+
       +                                                 |
       |                                                 |
       |   +------+------+------+------+------+------+   |
       |   |      |      |      |      |      |      |   |
       +-->|      |      |      |      |      |      |<--+
           |      |      |      |      |      |      |
           +------+------+------+------+------+------+



               +------+             +------+    Top
               |      |             |      |     +
               |      |             +------+     |
      Top      |      |             |      |<----+
       +       |      |             |      |
       |       +------+             +------+
       +------>|      |             |      |
               |      |             |      |
               +------+             +------+
               |      |             |      |
               |      |             |      |
               +------+             +------+
```

What allows us to achieve this task is the ability to leverage a single stack to reverse the order that a given list of items is in by pushing the entire list and then poping that same list from the stack. We will utilize that in our queue implementation by following these rules

- Push all new elements onto stack 1 during an enqueue
- On a dequeue check to see if stack 2 is empty, if it is pop all of the elements from stack 1 and push them onto stack 2, return the top from stack 2

By popping the contents from stack 1 to stack 2 during a dequeue we reverse the original stack ordering such that the current contents of stack 2 are in the correct order. From that point we can simply pop from stack 2 and return its contents. Below is a visualization:

`push('d')`



     +---+        +---+
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     |   |        |   |
     +---+        |   |
     | d |        |   |
     +---+        +---+
      S1           S2
`push('o')`

```


 +---+        +---+
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 +---+        |   |
 | o |        |   |
 +---+        |   |
 | d |        |   |
 +---+        +---+
  S1           S2
```

`push('g')`

```


 +---+        +---+
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 +---+        |   |
 | g |        |   |
 +---+        |   |
 | o |        |   |
 +---+        |   |
 | d |        |   |
 +---+        +---+
  S1           S2
```

`pop()` - first flip the stack

```


 +---+        +---+
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        +---+
 |   |        | d |
 |   |        |---|
 |   |        | o |
 |   |        |---|
 |   |        | g |
 +---+        +---+
  S1           S2
```

`pop()` - then pop s2

```


 +---+        +---+
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |   |
 |   |        |---|
 |   |        | o |
 |   |        |---|
 |   |        | g |
 +---+        +---+
  S1           S2
```

A `Stack` implementation has been provided in `Stack.java`. Use this to finish implementing the `Queue` api which is found in `Queue.java`. Remember to `push` all new elements onto stack 1 and then either pop from stack 2 or flip the stacks and then pop from stack 2.

Some tests have been provided and can be run by running the `run_tests.sh` script.
