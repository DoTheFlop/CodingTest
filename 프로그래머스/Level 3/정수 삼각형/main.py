def solution(triangle):

    n = len(triangle)
    dp = [[0] * n for _ in range(n)]

    dp[0][0] = triangle[0][0]

    for i in range(1, n):
        for j in range(len(triangle[i])-1):
            dp[i][j] = max(dp[i][j], dp[i-1][j] + triangle[i][j])
            dp[i][j + 1] = max(dp[i][j + 1], triangle[i][j + 1] + dp[i-1][j])

    return max(dp[-1])

print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))