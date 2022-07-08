def solution(arr, divisor):
    answer = []
    for i in arr:
        if i % divisor == 0:
            answer.append(i)
    if answer == []:
        answer.append(-1)
    answer.sort()
    return answer

solution([5, 9, 7, 10], 5)