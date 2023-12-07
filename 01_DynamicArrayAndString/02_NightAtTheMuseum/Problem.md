https://codeforces.com/problemset/problem/731/A

Brainstorms:

- Always start from 'a'
- Wheel include 26 characters
- Shortest distance from current char to next char always less than 13
- We can rotate left or right: distance = abs(next - current)
    - rotate left if: distance > 13 => results = results + 26 - distance
    - rotate right if (else): distance < 13 => results = results + distance
    
- Solution:
    - distance_0 = abs(ASCII(input[0]) - ASCII('a'))
    - resutls = results + (distance_0 < 13 ? distance_0 : (26 - distance_0))
    
    - distance_1 = ASCII(input[1]) - ASCII(input[0]) 
    - resutls = results + (distance_1 < 13 ? distance_1 : (26 - distance_1))

    - distance_2 = ...

    -> need 1 pointer to keep previous character

    => CODE:
    Loop i -> input.length():
        - pointer = 'a'
        - distance = abs(ASCII(input[i]) - ASCII(pointer))
        - results += results + distance < 13 ? distance : (26 - distance)
        - pointer = input[i]

