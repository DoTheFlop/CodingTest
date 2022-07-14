def solution(s):
    s = list(s)
    s.sort(reverse=True)
    print(str(s))
    answer = ''.join(i for i in s)
    print(answer)
    return answer


solution("Zbcdefg"	)