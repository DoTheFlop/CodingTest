def solution(line):
    answer = ''
    line = list(line)
    answer += line[0]
    for i in range(1, len(line)):
        if answer[-1] == line[i] and line[i] == line[i-1]:
            answer += '*'
        elif answer[-1] == '*' and line[i] == line[i-1]:
            continue
        else:
            answer += line[i]
    return answer

print(solution("aabbc"))