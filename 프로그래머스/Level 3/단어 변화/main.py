from collections import deque

def solution(begin, target, words):
    answer = float('inf')

    queue = deque([])
    visited = []
    cnt = 0
    queue.append([begin, cnt])
    while queue:
        word, cnt = queue.popleft()
        if word == target:
            answer = min(answer, cnt)
        visited.append(word)
        for i in words:
            if i in visited:
                continue
            count = 0
            for j in range(len(word)):
                if i[j] != word[j]:
                    count += 1
            if count == 1:
                queue.append([i, cnt+1])
                visited.append(i)
        
    return answer


print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))