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
    if answer == 0:
        return -1
    return answer

#좀더 간결하고 직관적인 코드
def solution2(skill, skill_trees):
    answer = 0
    for i in skill_trees:
        skills = list(skill)
        for j in i:
            if j in skills:
                if skills.pop(0) != j:
                    break
        else:
            answer += 1
    return answer

print(solution2("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))