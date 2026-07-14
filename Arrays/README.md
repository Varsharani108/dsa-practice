# Arrays

## Day 1

### Problem: Two Sum

**Platform:** LeetCode (#1)

**Difficulty:** Easy

### Approach
- Use a HashMap to store each number and its index.
- For every element, check whether its complement (`target - current`) already exists in the map.
- If yes, return the two indices.
- Otherwise, store the current number and continue.

### Time Complexity
O(n)

### Space Complexity
O(n)