def solution(land):
    r = len(land)
    
    for i in range(1, r):
        land[i][0] = max(land[i-1][1], land[i-1][2], land[i-1][3]) + land[i][0]
        land[i][1] = max(land[i-1][0], land[i-1][2], land[i-1][3]) + land[i][1]
        land[i][2] = max(land[i-1][0], land[i-1][1], land[i-1][3]) + land[i][2]
        land[i][3] = max(land[i-1][0], land[i-1][1], land[i-1][2]) + land[i][3]

    return max(land[-1])

print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]))