def solution(numbers):
    numbers = [str(x) for x in numbers]
    numbers = sorted(numbers, key = lambda x : x * 3, reverse=True)
    return str(int(''.join(numbers)))

print(solution([3, 30, 34, 5, 9]))

