def solution(n, left, right):
    answer = []
    
    for i in range(left, right + 1):
        answer.append(max(i//n, i%n) + 1)
    print(answer)
    return answer

solution(3, 2, 5)