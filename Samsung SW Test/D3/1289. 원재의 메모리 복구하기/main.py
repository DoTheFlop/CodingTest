import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    answer = 0
    memory = list(input())
    if memory[0] == '1':
        answer += 1
    for i in range(1, len(memory)):
        if memory[i-1] != memory[i]:
            answer += 1
    print('#' + str(test_case), answer)