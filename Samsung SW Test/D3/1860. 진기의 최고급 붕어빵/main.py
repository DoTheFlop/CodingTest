import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N, M, K = map(int, input().split())
    peoples = list(map(int, input().split()))
    bread = 0
    time = 0
    for i in range(max(peoples)):
        time += 1
        if time % M:
            bread += K