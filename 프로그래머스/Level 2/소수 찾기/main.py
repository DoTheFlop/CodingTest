from itertools import permutations

def solution(numbers):
    answer = 0
    numbers = list(numbers)
    for i in range(len(numbers)):
        for j in permutations(numbers, i+1):
            if prime_check(int("".join(j))):
                answer += 1
    return answer


import math
def prime_check(n):
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True

print(solution("17"))