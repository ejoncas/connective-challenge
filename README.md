# Connective Coding Challenge

* JAVA Problem 1 is solved in class [TwoSumCalculator](src/main/java/com/nanducoder/TwoSumCalculator.java)
* JAVA Problem 2 is solved in class [WaterContainerOptimizer](src/main/java/com/nanducoder/WaterContainerOptimizer.java)
* SQL Problem 1 is solved in file [problem1.sql](sql/problem1.sql)
* SQL Problem 2 is solved in file [problem2.sql](sql/problem2.sql)

The sql problems were tested on DBFiddle:

* SQL problem 1 https://dbfiddle.uk/?rdbms=postgres_14&fiddle=67a05524420ced2a666fcb014d7719a7
* SQL problem 2 https://dbfiddle.uk/?rdbms=postgres_14&fiddle=28eac0e352368b3a49f4873cae4c5cab
  * Intermediate solutions:
    * Step 1: https://dbfiddle.uk/?rdbms=postgres_14&fiddle=da90e890b7e4ebe4d5912591b24ca469
    * Step 2: https://dbfiddle.uk/?rdbms=postgres_14&fiddle=ab88609f2bc699642af6d89fafd89a58
    * Step 3: https://dbfiddle.uk/?rdbms=postgres_14&fiddle=30a4e17d1c433a23b4163001711ed9b9

## Implementation Considerations

### Java Problem 1

It could have been implemented with 2 nested `for` loops with simpler code, given the problem has no restrictions about the size of the input array I had to assume worst case scenario where for big input arrays it would simply take too long.
The solution does 2 passes on the whole array, one to generate the lookup Map and another one to find the result.

### Java Problem 2

Again, this could have been implemented with 2 nested `for` loops, where for each bar you would calculate the area against every other bar and change the result variable if the calculated area is bigger.
For a more efficient solution, using two punters starting on the widest possible setting and moving the pointers from the lowest bar achieves the same result in a linear cost.

### SQL Problem 1

This problem could have been solved using LIMIT and OFFSET but I found that this version is fairly easy to comprehend. Worth noticing that it only works for the second highest. If needed the third highest then I would have use `LIMIT 1 OFFSET 2`

### SQL Problem 2

This one needed a bit of research. I end up using a [LAG](https://www.postgresqltutorial.com/postgresql-window-function/postgresql-lag-function/) function which lets you access the previous row to compare against the current value. This helps to identify when we should stop counting for consecutive occurences.