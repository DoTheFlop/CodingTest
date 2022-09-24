import math

def solution(n, k):
    temp = ''
    n = int(n)
    while n > 0:
        n, r= divmod(n, k)
        temp += str(r)

    temp = temp[::-1].split('0')

    answer = 0
    for i in temp:
        if i == '1':
            continue
        if i and prime_check(int(i)):
            answer += 1
    return answer

def prime_check(n):
    if n == 1:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

    
print(solution(110011, 10))