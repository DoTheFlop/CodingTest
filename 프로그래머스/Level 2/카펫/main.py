def solution(brown, yellow):
    entire_scale = brown + yellow
    for i in range(3, entire_scale):
        cnt = 0
        if entire_scale % i == 0:
            a = [[0] * i for _ in range(entire_scale // i)]
            for j in range(i):
                a[0][j] = 1
                a[-1][j] = 1
            for j in range(entire_scale // i):
                a[j][0] = 1
                a[j][-1] = 1

            for j in range(entire_scale // i):
                cnt += a[j].count(0)
            if cnt == yellow:
                answer = [i, entire_scale//i]
    return answer

print(solution(24, 24))