def solution(s):
    answer = []
    s = s[:-2].replace('{','').replace(',',' ').split('}')
    
    s = [ i.split()  for i in s]
    
    s.sort(key = len)
	
    for i in s:
        for j in i:
            if int(j) not in answer:
                answer.append(int(j))
    
    return answer

print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))