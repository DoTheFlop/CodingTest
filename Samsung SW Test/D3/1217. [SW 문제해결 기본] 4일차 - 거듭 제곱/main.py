import sys
sys.stdin = open("input.txt", "r")

T = 10

import math

for test_case in range(1, T + 1):
    input()
    N, M = map(int, input().split())
    answer = int(math.pow(N, M))

    print('#' + str(test_case), answer)