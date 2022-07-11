def solution(s):
    answer = ''
    answer = list(s)

    if len(answer) % 2 == 1:
        return answer[int(len(answer) / 2)]
    else:
        return answer[int(len(answer)/2 - 1)] + answer[int(len(answer)/2)]

print(solution("abcde"))