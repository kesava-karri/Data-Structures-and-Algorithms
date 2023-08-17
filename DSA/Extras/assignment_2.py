class ThreeConsecutiveOddsQ5:
    def alt_approach_1(arr: list[int]) -> bool:
        count = 0
        idx = 0

        while idx < len(arr):
            if arr[idx] % 2 == 0:
                count = 0
            else:
                count += 1
                if count == 3:
                    return True
            idx += 1
        return False

    def alt_approach(arr: list[int]) -> bool:
        count = 0
        idx = 0

        while count < 3 and idx < len(arr):
            if arr[idx] % 2 != 0:
                count += 1
            else:
                count = 0
            idx += 1
        return count == 3

    def brute_force(arr: list[int]) -> bool:
        count = 0

        for i in range(len(arr)):
            if arr[i] % 2 != 0:
                count += 1
                if count == 3:
                    return True
            else:
                count = 0
        return False

q5Obj = ThreeConsecutiveOddsQ5
print(q5Obj.alt_approach([2,6,4,1]))

print(q5Obj.brute_force([2,6,4,1]))
print(q5Obj.brute_force([1,2,34,3,4,5,7,23,12]))


class MinAbsoluteDifferenceQ4:
    def alt_approach(arr: list[int]) -> list[list[int]]:
        minDiff = float("inf")
        result = []

        arr.sort()

        for i in range(1, len(arr)):
            currentDiff = arr[i] - arr[i - 1]
            if currentDiff < minDiff:
                minDiff = currentDiff
                result = []
            if currentDiff == minDiff:
                result.append([arr[i - 1], arr[i]])

        return result

    def not_sure_bubble_sort(arr: list[int]) -> list[list[int]]:
        minDiff = float("inf")
        result = []
        swapped = True

        while swapped:
            swapped = False
            for i in range(1, len(arr)):
                if arr[i - 1] > arr[i]:
                    temp = arr[i - 1]
                    arr[i - 1] = arr[i]
                    arr[i] = temp
                    swapped = True

        for i in range(1, len(arr)):
            currentDiff = arr[i] - arr[i - 1]
            if currentDiff < minDiff:
                minDiff = currentDiff

        for i in range(1, len(arr)):
            currentDiff = arr[i] - arr[i - 1]
            if currentDiff == minDiff:
                result.append([arr[i - 1], arr[i]])

        return result

    def brute_force(arr: list[int]) -> list[list[int]]:
        minDiff = float("inf")
        result = []
        
        for i in range(len(arr)):
            for j in range(i, len(arr)):
                if arr[i] > arr[j]:
                    temp = arr[j]
                    arr[j] = arr[i]
                    arr[i] = temp

        for i in range(1, len(arr)):
            currentDiff = arr[i] - arr[i - 1]
            if currentDiff < minDiff:
                minDiff = currentDiff

        for i in range(1, len(arr)):
            currentDiff = arr[i] - arr[i - 1]
            if currentDiff == minDiff:
                result.append([arr[i - 1], arr[i]])

        return result

    def builtins(arr: list[int]) -> list[list[int]]:
        arr.sort()
        minDiff = float("inf")
        result = []

        for i in range(1, len(arr)):
            currentDiff = arr[i] - arr[i - 1]
            if currentDiff < minDiff:
                minDiff = currentDiff

        for i in range(1, len(arr)):
            currentDiff = arr[i] - arr[i - 1]
            if currentDiff == minDiff:
                result.append([arr[i - 1], arr[i]])

        return result

q4Obj= MinAbsoluteDifferenceQ4

"""
print(q4Obj.not_sure_bubble_sort([4,2,1,3]))
print(q4Obj.not_sure_bubble_sort([1,3,6,10,15]))
print(q4Obj.not_sure_bubble_sort([3,8,-10,23,19,-4,-14,27]))


print(q4Obj.brute_force([4,2,1,3]))
print(q4Obj.brute_force([1,3,6,10,15]))
print(q4Obj.brute_force([3,8,-10,23,19,-4,-14,27]))

print(q4Obj.builtins([4,2,1,3]))
print(q4Obj.builtins([1,3,6,10,15]))
print(q4Obj.builtins([3,8,-10,23,19,-4,-14,27]))
"""


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
# print(q3Obj.solution("aA", "aAAbbbb"))
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
