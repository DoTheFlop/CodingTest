import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    A, B = map(int, input().split())
    if len(str(A)) == 2 or len(str(B)) == 2:
        print("#%s %s" %(test_case, -1))
    else:
        print("#%s %s" % (test_case, A * B))