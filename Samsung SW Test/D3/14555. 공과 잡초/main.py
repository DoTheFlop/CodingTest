import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    answer = 0
    field = input()
    N = len(field)
    for i in range(N):
        if field[i] == '(':
            if field[i + 1] == ')':
                i += 1
                answer += 1
                continue
            else:
                answer += 1
        elif field[i] == ')':
            if field[i-1] != '(':
                answer += 1
    print('#' + str(test_case), answer)
