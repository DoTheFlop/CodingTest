import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    up, down = 0, 0
    block = list(map(int, input().split()))
    for i in range(N-1):
        if block[i] > block[i+1] and down < block[i] - block[i+1]:
            down = block[i] - block[i+1]
        elif block[i] < block[i+1] and up < block[i+1] - block[i]:
            up = block[i+1] - block[i]

    print('#' + str(test_case), up, down)