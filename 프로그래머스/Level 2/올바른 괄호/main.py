def solution(s):
    answer = True
    stack = []

    for i in s:
        if i in ['{', '[', '(']:
            stack.append(i)
        else:
            if not stack:
                return False
            pop = stack.pop()
            if i == ']' and pop != '[':
                return False
            elif i == '}' and pop != '{':
                return False
            elif i == ')' and pop != '(':
                return False
    
    if stack:
        return False
    return True

print(solution("(())()"))