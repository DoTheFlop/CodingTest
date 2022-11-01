def solution(x):
    answer = False
    sum = 0
    n = x
    while n > 0:
        sum += n % 10
        n = n//10
    if (x / sum).is_integer():
        return True
    return answer

print(solution(10))