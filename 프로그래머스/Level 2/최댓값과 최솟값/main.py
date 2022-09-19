def solution(s):
    answer = ''
    int_list = list(map(int, s.split(" ")))
    answer = str(min(int_list)) + ' ' + str(max(int_list))
    return answer

solution("1 2 3 4")
