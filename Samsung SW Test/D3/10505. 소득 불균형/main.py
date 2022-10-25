import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N, answer = int(input()), 0
    income = list(map(int, input().split()))
    avg = sum(income)/N
    for i in income:
        if i <= avg:
            answer += 1
    print('#' +str(test_case), answer)