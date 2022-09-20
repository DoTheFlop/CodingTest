def solution(s):
    count ,zero_count = 0, 0
    while(s != '1'):
        count += 1
        zero_count = zero_count + (len(s) - len(s.replace('0', '')))
        s = s.replace('0', '')
        s = format(len(s), 'b')
    return [count, zero_count]


solution("110010101001")