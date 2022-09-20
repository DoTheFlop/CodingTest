def solution(s):
    answer = 0
    for i in range(len(s)):
        a = s[i:]
        b = s[:i]
        if(check(a + b)):
            answer += 1
    return answer

def check(n):
    stack = []

    for i in n:
        if i in ['[', '{', '(']:
            stack.append(i)
        else:
            if not stack: return False
            stack_pop = stack.pop()
            if i == ']' and stack_pop != '[':
                return False
            elif i == '}' and stack_pop != '{':
                return False
            elif i == ")" and stack_pop != '(':
                return False

    if stack : return False
    return True

print(solution("[](){}"))