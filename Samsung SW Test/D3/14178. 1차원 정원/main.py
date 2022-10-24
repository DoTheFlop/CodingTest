import sys
sys.stdin = open("input.txt", "r")

import math
T = int(input())

for test_case in range(1, T + 1):
    a = input()
    N, D = a.split()
    print('#' + str(test_case), math.ceil(int(N)/(2*int(D)+1)))