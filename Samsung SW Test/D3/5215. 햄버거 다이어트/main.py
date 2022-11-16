import sys
sys.stdin = open('input.txt')

T = int(input())

def dfs(index, score, cal):
    global best_score
    if cal > L:
        return

    if score > best_score:
        best_score = score

    if index == N:
        return

    dfs(index + 1, score,cal)

    dfs(index + 1, score + ingredient[index][0], cal + ingredient[index][1])

for test_case in range(1, T + 1):
    N, L = map(int, input().split())
    ingredient = []
    best_score = 0

    for i in range(N):
        ingredient.append(list(map(int, input().split())))

    dfs(0, 0, 0)

    print("#{} {}".format(test_case, best_score))