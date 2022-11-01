def solution(x, n):
    answer = []
    increase = x
    for i in range(n):
        answer.append(x)
        x += increase
    return answer

print(solution(2, 5))