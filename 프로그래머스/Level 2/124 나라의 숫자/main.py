def solution(n):
    list = ['4', '1', '2']
    answer = ''
    while n :
        answer = list[n % 3] + answer
        n = n // 3 - (n % 3 == 0)
    return answer

print(solution(12))