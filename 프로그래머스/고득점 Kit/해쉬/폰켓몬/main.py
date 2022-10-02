def solution(nums):
    length = len(nums) // 2
    nums = set(nums)
    if length < len(nums):
        answer = length
    else :
        answer = len(nums)
    return answer

print(solution([3,1,2,3]))