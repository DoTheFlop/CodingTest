import sys
sys.stdin = open("input.txt", "r")

for i in range(10):
    test_case = int(input())
    find = input()
    S = input()
    print("#%s %s" %(test_case, S.count(find)))