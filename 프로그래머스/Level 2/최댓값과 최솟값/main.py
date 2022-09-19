def solution(s):
    answer = ''
    int_list = list(map(int, s.split(" ")))
    print(int_list)
    answer = str(min(int_list)) + ' ' + str(max(int_list))
    print(answer)
    return answer

solution("1 2 3 4")
