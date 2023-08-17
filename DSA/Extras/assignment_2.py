class JewelsAndStonesQ3:
    def solution(jewels: str, stones: str) -> int:
        jewelsSet = set(jewels)
        jewels_in_stones = 0
        for stone in stones:
            if stone in jewelsSet:
                jewels_in_stones += 1
        return jewels_in_stones

    def alt_approach(jewels: str, stones: str) -> int:
        jewelsList = [jewel for jewel in jewels]
        jewelsCount = dict.fromkeys(jewelsList, 0)
        
        for stone in stones:
            if jewelsCount.__contains__(stone):
                jewelsCount[stone] += 1
        return sum(jewelsCount.values())

    # Continue from here, there would be a better solution
    def brute_force(jewels: str, stones: str) -> int:
        count = 0
        for stone in stones:
            for jewel in jewels:
                if stone == jewel:
                    count += 1
        return count
        
q3Obj = JewelsAndStonesQ3
print(q3Obj.solution("aA", "aAAbbbb"))
# print(q3Obj.alt_approach("aA", "aAAbbbb"))
# print(q3Obj.brute_force("aA", "aAAbbbb"))

class RunningSumQ2:
    def solution(nums: list[int]) -> list[int]:
        sum = 0
        for idx in range(len(nums)):
            sum += nums[idx]
            nums[idx] = sum
        return nums

    def brute_force(nums: list[int]) -> list[int]:
        idx = 1
        while idx < len(nums):
            nums[idx] = nums[idx] + nums[idx - 1]
            idx += 1
        return nums

q2Obj = RunningSumQ2
# print(q2Obj.solution([1,2,3,4]))
# print(q2Obj.brute_force([1,2,3,4]))

class MaximumWealthQ1:
    def solution(accounts: list[list[int]]) -> int:
        max_wealth = 0
        
        for account in accounts:
            temp = 0
            for wealth in account: 
                temp += wealth
            if temp > max_wealth:
                max_wealth = temp
        return max_wealth

    def brute_force(accounts: list[list[int]]) -> int:
        individual_total_wealth = []
        max_wealth = 0
        for account in accounts:
            temp = 0
            for wealth in account: 
                temp += wealth
            individual_total_wealth.append(temp)
        
        for wealth in individual_total_wealth:
            if wealth > max_wealth:
                max_wealth = wealth
        return max_wealth

    def builtins(accounts: list[list[int]]) -> int:
        total_individual_wealth = []
        for account in accounts:
            total_individual_wealth.append(sum(account))
        return max(total_individual_wealth)

"""
q1Obj = MaximumWealthQ1
print(q1Obj.solution([[1,2,3],[3,2,1]]))
print(q1Obj.solution([[1,5],[7,3],[3,5]]))
print(q1Obj.solution([[2,8,7],[7,1,3],[1,9,5]]))

print(q1Obj.brute_force([[1,2,3],[3,2,1]]))
print(q1Obj.brute_force([[1,5],[7,3],[3,5]]))
print(q1Obj.brute_force([[2,8,7],[7,1,3],[1,9,5]]))

print(q1Obj.builtins([[1,2,3],[3,2,1]]))
print(q1Obj.builtins([[1,5],[7,3],[3,5]]))
print(q1Obj.builtins([[2,8,7],[7,1,3],[1,9,5]]))
"""
