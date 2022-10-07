def solution(s):
    answer = True
    s = s.lower()
    a, b = s.count('p'), s.count('y')
    if a != b:
        answer = False

    return answer

print(solution("Pyy"))