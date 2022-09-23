def solution(cacheSize, cities):
    cities = [i.lower() for i in cities]
    queue = []
    cacheHit=0
    cacheMiss=0
    for i in cities:
        if(i in queue):
            idx = queue.index(i)
            queue.pop( idx )
            queue.insert(0, i)
            cacheHit += 1
        else:
            queue.insert(0, i)
            cacheMiss += 5
            
        if(len(queue) > cacheSize):
            queue.pop()
    answer = cacheHit + cacheMiss
    return answer

solution(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"])

solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"])