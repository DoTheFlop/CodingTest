import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N, M = input().split()

    print('#' + str(test_case), (int(N) + int(M)) % 24)