def solution(m, n, puddles):
    answer = 0
    
    map = [[0] * (m+1) for i in range(n+1)]
    map[1][1] = 1
    for i in range(1, n+1):
        for j in range(1, m+1):
            if [j, i] in puddles or [i, j] == [1, 1]:
                continue
            else:
                map[i][j] = map[i][j-1] + map[i-1][j]
    return map[n][m] % 1000000007

print(solution(4, 3, [[2, 3]]))