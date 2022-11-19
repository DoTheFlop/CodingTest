import sys
sys.stdin = open("input.txt", "r")
from collections import deque

for i in range(10):
    test_case = int(input())
    password = list(map(int, input().split()))
    password = deque(password)
    while(True):
        a = password.pop()
        if a < 1:
            password.append(a)
            break
        password.append(a)
        for j in range(1, 6):
            temp = password.popleft()
            temp = temp - j
            if temp < 1:
                password.append(0)
                break
            password.append(temp)
    print("#%s" %(test_case), end='')
    for num in password:
        print('', num, end='')
    print()