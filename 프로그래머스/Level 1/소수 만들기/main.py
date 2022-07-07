from itertools import combinations

def solution(nums):
    answer = 0
    cmb = list(combinations(nums,3))
    for i in cmb:
        if prime_number(sum(i))==True:
            answer+=1
    return answer
            
            
def prime_number(number):
    for k in range(2, number):
        if number % k == 0:
            return False
    return True

print(solution([1,2,3,4]))