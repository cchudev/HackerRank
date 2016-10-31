# HackerRank/Poisonous Plants
My solutions to HackerRank challenges - Poisonous Plants

https://www.hackerrank.com/challenges/poisonous-plants/

## Solution 1
Solution1.java implements a straightforward algorithm to process all input from the end of the list. In each iteration element P[i] is removed if it's value is larger than P[i-1]. The application then count number of iterations where the size of the list equals to previous iteration (where no more node being removed). Standard Java LinkedList is used as a deque for efficient adding, getting and removing elements from either start or end of the list.  

This straightforward approach get timed out in test cases where number of iteration is close to the size of the list O(n2).

## Solution 2
Solution2.java calculates the iterations required to remove the element P[i] at the time it read from the input. Last element of each iterations are maintained in a list. For each new element fulfilling P[i] <= P[i-1], it compares to each iteration to determine at which iteration the element would be removed. If an element P[i] is removed in nth iteration, there should be at least n+1 iterations. Below table represent the algorithm to determine the last element of each iteration.

| Input | 6 | 5 | 8 | 4 | 7 | 10 | 9 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Iteration 0 | 6 | 5 | 8 | 4 | 7 | 10 | 9 |
| Iteration 1 |   |   | 5 | 4 | 4 | 4 | 9 |
| Iteration 2 |   |   |   |   |   |   | 4 |

1. First input is 6, it is the 1st element in the list, so it is assigned to iteration 0.
1. Next input is 5, as it is smaller than previous element, so last element of iteration 0 is set to 5.
1. Next input is 8, which is larger than previous element and it would be removed at iteration 1. Thus last element of iteration 1 is set to 5.
1. Next input is 4, which is smaller than previous element and the last element of iteration 1, so last element of iteration 0 and iteration 1 are set to 4.
1. Next input is 7, which is larger than previous element and it would be removed at iteration 1. Thus last element of iteration 1 remains unchanged.
1. Next input is 10, which is larger than previous element and it would be removed at iteration 1. Thus last element of iteration 1 remains unchanged.
1. Next input is 9, which is smaller than previous element but larger then last element of iteration 1. Which means this element would  be removed in iteration 2. Thus last element of iteration 1 is 9 and last element of iteration 2 is 4.
1. After all input is processed there are only 2 iterations. So the result is 2.

The above algorithm archive much better time complexity O(nm) [where n is number of elements and m is the total iterations] compare to Solution 1. However it still getting timeout for test cases while m and n is large.

## Solution 3
The problem with Solution 2 is it compare elements to last element of each iteration, which slows down when the iterations to finish is large. Solution 3 removed this loop by storing 2 additional integer firstN and firstNValue to represent identical value from 1 to nth elements. By skipping the first N elements in the search it archives O(n log n) and passed all test cases without timeout.
