import sys
sys.stdin = open("input.txt", "r")

import math

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    A, B = map(int, input().split())
    answer = 0
    for i in range(A, B + 1):
        if int(math.sqrt(i)) == math.sqrt(i) and str(int(math.sqrt(i))) == ''.join(reversed(str(int(math.sqrt(i))))) and str(i) == ''.join(reversed(str(i))):
            answer += 1

    print("#%s %s" %(test_case, answer))