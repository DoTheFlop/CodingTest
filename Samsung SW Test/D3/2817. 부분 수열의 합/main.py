import sys
from itertools import combinations

sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    num = list(map(int, input().split()))
    answer = 0

    for i in range(N):
        for j in combinations(num, i):
            if sum(j) == K:
                answer += 1

    print("#{} {}".format(test_case, answer))