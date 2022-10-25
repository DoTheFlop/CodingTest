import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    L, U, X = map(int, input().split())
    if L <= X <= U:
        answer = 0
    elif X < L:
        answer = L - X
    else:
        answer = -1

    print('#' + str(test_case), answer)