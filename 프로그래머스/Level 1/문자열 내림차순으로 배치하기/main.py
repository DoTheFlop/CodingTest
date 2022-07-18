def solution(s):
    s = list(s)
    s.sort(reverse=True)
    answer = ''.join(i for i in s)
    return answer

solution("Zbcdefg")