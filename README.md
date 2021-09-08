# Synonyms_interview

##Task description

In this task, your job will be to write a program that can decide whether two words are synonyms or not. You will get a
synonym dictionary describing pairs of synonymous words. Afterwards, you will answer several queries asking whether
given two words are synonyms or not.

Use the following rules to decide:
1. If the pair of words is declared synonymous in the input, then they are synonyms.
1. Being synonyms doesn’t depend on order, e.g. if big is a synonym for large then large is a synonym for big.
1. We can derive the synonymous relationship indirectly: if big is a synonym for large and large is a synonym for huge
   then big is a synonym for huge.
1. If two words differ only by case, they are synonyms, e.g. same is a synonym for both SAmE, SAME and also same
   (itself).
1. If none of the above rules can be used to decide whether two words are synonyms, then they are not.

**Input**

   Input starts with a number of test cases T (0 ≤ T ≤ 100). Each test case begins with a line containing a single number N (0
   ≤ N ≤ 100) — the length of a synonym dictionary. On each of the following N lines, there is exactly one pair of synonyms
   separated by a single space. Next line contains a single number Q (0 ≤ Q ≤ 100) — number of queries. Each of the
   following lines contains a pair of query words separated by a single space.
   Each word consists only of English alphabet letters ([a-zA-Z]) and is at most 20 characters long.

**Output**

For each pair of query words output either string synonyms or different .

**Sample input**

      2
      5
      big large
      large huge
      small little
      apple banana
      banana little
      7
      same same
      big huge
      huge big
      apple peach
      big tall
      peach PEACH
      apple little
      5   
      wood FORest
      meadoW PrAirIe
      WOOD Lumber
      lumber forest
      lumber forest
      2
      wood LUMBER
      mEADOw fire>`


**Sample output**

      synonyms
      synonyms
      synonyms
      different
      different
      synonyms
      synonyms
      synonyms
      different

**Explanation of the sample problem**
   
In the first test-case there are 6 queries:
1. Words are the same.
1. Words are derived synonyms.
1. Symmetric to 2nd query.
1. No rule can be used to derive the synonym pair.
1. No rule can be used to derive the synonym pair, even though they are synonyms in English.
1. Words differ only in case.

2 test case:
   
1. Defined as synonyms by 3rd rule. The case does not matter.
1. Different.
   
You can download the example from above as a file(s):
   * [example input](https://drive.google.com/open?id=1uv7I0b3ToOvJ1L60yAanA4UrkGgwR2A7)
   * [example output](https://drive.google.com/open?id=1q4hAY6-MurTwb8-1chx9D5TAyd0VclmP)
   
You can also test your code on the bigger file:
   * [bigger example input](https://drive.google.com/open?id=1CTQZAeTsTJz4SCbzCmz2EaW4tJMGqCDJ)
   * [bigger example output](https://drive.google.com/open?id=19yn8CI2UqFfVrRVgtcFCE-ubatEp0Zpo)
   
**Goal**

   Solve the problem for the [test input file](https://drive.google.com/open?id=14ad4U4Q82kmH5NBGG5nQhjntSQ2kzTGY) and send us the solution.
   