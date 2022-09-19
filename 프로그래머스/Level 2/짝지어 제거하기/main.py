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

    print(answer)
    if len(answer) == 0:
        return 1
    else:
        return 0

solution('baabaa')