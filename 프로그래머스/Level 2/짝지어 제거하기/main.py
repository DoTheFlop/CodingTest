def solution(s):
    if len(s) % 2 == 1:
        return 0

    answer = []
    for i in s:
        if len(answer) < 1:
            answer.append(i)
        else:
            if answer[-1] == i:
                answer.pop()
            else:
                answer.append(i)

    return 0 if len(answer) else 1

solution('baabaa')