import operator

def solution(routes):
    answer = 0
    routes = sorted(routes, key = operator.itemgetter(1))
    camera = []
    camera.append(routes.pop(0)[1])
    for i in routes:
        for j in camera:
            check = 0
            if i[0] <= j and j <= i[1]:
                check += 1
        if check == 0:
            camera.append(i[1])
    return len(camera)

print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]))