def solution(n):
    n = list(str(n))
    n.sort(reverse=True)
    return int(''.join(n))

print(solution(118372))