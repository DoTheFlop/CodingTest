import math

def solution(n, k):
    people = [i for i in range(1, n+1)]
    answer = []
    k -= 1
    while people:
        temp = k // math.factorial(n-1)
        answer.append(people.pop(temp))
        k = k % math.factorial(n-1)
        n -= 1
    return answer

print(solution(3,  6))