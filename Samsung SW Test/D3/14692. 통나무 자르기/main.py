import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    log = int(input())
    if log % 2 :
        print('#' + str(test_case), 'Bob')
    else:
        print('#' + str(test_case), 'Alice')
