def solution(s):
    answer = []
    for i in s:
        stack = []
        cnt = 0
        for j in i:
            if ''.join(stack[-2:]) == '11' and j == '0':
                cnt += 1
                stack.pop()
                stack.pop()
                continue
            stack.append(j)

        if cnt == 0:
            answer.append(''.join(stack))
        else:
            stack = ''.join(stack)
            if stack.rfind('0') == -1:
                answer.append('110' * cnt + stack)
            else:
                index = stack.rfind('0')
                answer.append(stack[:index + 1] + '110' * cnt + stack[index + 1:])
    return answer

print(solution(["1110","100111100","0111111010"]))