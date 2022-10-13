from operator import indexOf


def solution(skill, skill_trees):
    answer = 0
    skill_list = []
    for i in skill:
            skill_list.append(i)
    
    for i in skill_trees:
        check_list = [False] * len(skill_list)
        check = False
        for j in i:
            if j not in skill_list:
                continue
            index = skill_list.index(j)
            if index == 0:
                check_list[index] = True
            elif check_list[index - 1] == False:
                check = True
                break
            else :
                check_list[index] = True
        if check:
            continue
        answer += 1
    return answer

print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))