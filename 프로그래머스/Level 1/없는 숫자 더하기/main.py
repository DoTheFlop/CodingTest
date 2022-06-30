def solution(numbers):
    zeroToNine = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    answer = 0
    for i in zeroToNine:
        if not i in numbers:
            answer += i
    print(answer)
    return answer

#풀이
def solution(numbers):
    return 45 - sum(numbers)

solution([1,2,3,4,6,7,8,0])