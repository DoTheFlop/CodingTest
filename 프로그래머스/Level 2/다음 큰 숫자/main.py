def solution(n):
    cnt =  format(n, 'b').count('1')
    while True:
        n += 1
        if cnt == format(n, 'b').count('1'):
            break
    return n

print(solution(78))