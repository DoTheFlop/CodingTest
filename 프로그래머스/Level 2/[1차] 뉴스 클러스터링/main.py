import math
def solution(str1, str2):
    str1 = str1.upper()
    str2 = str2.upper()
    str1_list = []
    str2_list = []
    
    for i in range(len(str1)-1):
        if str1[i:i+2].isalpha():
            str1_list.append(str1[i:i+2])
        
    for i in range(len(str2)-1):
        if str2[i:i+2].isalpha():
            str2_list.append(str2[i:i+2])
    
    str1_list_copy = str1_list.copy()
    
    ins = []
    for i in str1_list_copy:
        if i in str2_list:
            ins.append(i)
            str1_list.remove(i)
            str2_list.remove(i)
    uni = ins + str1_list  + str2_list 
    
    if not  uni:
        answer = 1 * 65536
    else :
        answer = math.floor(len(ins) / len(uni) * 65536)
        
    return answer

#print(solution("FRANCE", "french"))

print(solution("aa1+aa2", "AAAA12"))

#print(solution("E=M*C^2", "e=m*c^2"))