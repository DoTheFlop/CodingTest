def solution(n):
    d = [0, 1, 1]
    for i in range(3, n + 2):
        d.append((d[i-1] + d[i-2]))
    return d[n + 1] % 1234567

print(solution(4))