def solution(people, limit):
    people.sort()
    answer = 0
    i = 0
    j = len(people) - 1
    while i <= j:
        answer += 1
        if people[i] + people[j] <= limit:
            i += 1
        j -= 1
    print(answer)
    return answer

solution([70, 50, 80, 50], 100)