import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    answer = 0
    alpha = input()
    a = ord('a')
    for i in alpha:
        if a == ord(i):
            a += 1
            answer += 1
        else:
            break
    print('#' + str(test_case), answer)

