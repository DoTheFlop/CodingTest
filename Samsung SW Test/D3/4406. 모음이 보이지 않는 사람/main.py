import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    alpha = ['a', 'e', 'i', 'o', 'u']
    word = input()
    answer = ''
    for i in word:
        if i in alpha:
            continue
        answer += i
    print('#' + str(test_case), answer)