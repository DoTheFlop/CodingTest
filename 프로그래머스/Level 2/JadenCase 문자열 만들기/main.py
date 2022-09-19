def solution(s):
    answer = ''
    str_list = list(map(str, s.split(' ')))
    for i in str_list:
        answer = answer + ' ' + i.lower().capitalize()
    return answer[1:]

solution('3people unFollowed me')