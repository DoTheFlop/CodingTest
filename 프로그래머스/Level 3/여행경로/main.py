#케이스 1, 2 시간초과
def solution_fail(tickets):
    answer = []
    tickets.sort(key=lambda x: (x[1], x[0]))
    n = len(tickets)

    def dfs():
        visited = [0]*n
        stack = ["ICN"]
        while stack:
            start = stack[-1]
            if len(stack) == n+1:
                for j in stack:
                    answer.append(j)
                stack.clear()
                break
            for i in range(len(tickets)):
                if tickets[i][0] == start and visited[i] == 0:
                    visited[i] = 1
                    stack.append(tickets[i][1])
                    break
    dfs()
    return answer

from collections import defaultdict

def solution(tickets):
    answer = []
    tickets.sort(key=lambda x: (x[1], x[0]))
    dic = defaultdict(list)

    for i in tickets:
        dic[i[0]].append(i[1])
    for i in dic.keys():
        dic[i].sort(reverse=True)

    def dfs():
        stack = ["ICN"]
        while stack:
            start = stack[-1]
            if not dic[start]:
                answer.append(stack.pop())
            else:
                stack.append(dic[start].pop())
    dfs()
    return answer[::-1]

print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))