import heapq
def solution(phone_book):
    answer = True

    num = heapq.heappop(phone_book)

    while phone_book:
        num_len = len(num)
        if num == phone_book[0][:num_len]:
            return False
        num = heapq.heappop(phone_book)

    return answer

print(solution(["119", "97674223", "1195524421"]))