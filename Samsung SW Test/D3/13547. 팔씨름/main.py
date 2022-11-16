import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for test_case in range(1, T + 1):
    match = list(input())
    count = match.count('o')
    if count + (15-len(match)) > 7:
        print('#' + str(test_case), 'YES')
    else:
        print('#' + str(test_case), 'NO')
