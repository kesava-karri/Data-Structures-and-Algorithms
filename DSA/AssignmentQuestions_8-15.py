class FirstEvenNumQ8:
    def brute_force(nums: list) -> list:
        for num in nums:
            if num % 2 == 0:
                return num
        return -1

q8Obj = FirstEvenNumQ8
print(q8Obj.brute_force([1,2,6,3,5]))
print(q8Obj.brute_force([1,7,11,3,5]))
print(q8Obj.brute_force([1,7,4,8,5]))

class SumOfElementsQ7:
    def brute_force(nums: list) -> list:
        sum = 0
        for i in nums:
            sum += i
        return sum

q7Obj = SumOfElementsQ7
# print(q7Obj.brute_force([1,2,6,3,5]))

class OddElementsQ6:
    def brute_force(nums: list) -> list:
        result = []
        for i in nums:
            if i % 2 != 0:
                result.append(i)
        return result

q6Obj = OddElementsQ6
# print(q6Obj.brute_force([1,5,6,4,3,2,8]))


class SeriesQ5:
    def brute_force(n: int) -> None:
        for _ in range(n): # rows
            for j in range(1, n+1):
                print(j, end='')
            n -= 1
            print(end='\n')
            
q5Obj = SeriesQ5
# q5Obj.brute_force(5)

class SeriesQ4:
    def brute_force(n: int) -> None:
        for i in range(1, n+1):
            for j in range(1, i+1):
                print(j, end='')
            print(end='\n')

q4Obj = SeriesQ4
# q4Obj.brute_force(5)

class MedianElementQ3:
    def brute_force(elements: list) -> int:
        length = len(elements)
        for i in range(length):
            for j in (i, length - 1):
                if elements[i] <= elements[j]:
                    continue
                else:
                    temp = elements[j]
                    elements[j] = elements[i]
                    elements[i] = temp
        print(elements)
        if length % 2 == 0:
            return elements[length//2 - 1], elements[length//2]
        else:
            return elements[length//2]
        

q3Obj = MedianElementQ3
# print(q3Obj.brute_force([10, 30, 20]))
# print(q3Obj.brute_force([10, 30, 40, 20]))


class MinOfThreeQ2:
    def brute_force(elements: list) -> int:
        temp, i = 0, 1
        while i < len(elements):
            if elements[temp] < elements[i]:
                i += 1
                continue
            else:
                temp = i
            i += 1
        
        return elements[temp]

    def builtin(elements: list) -> int:
        return min(elements)

q2Obj = MinOfThreeQ2
# print(q2Obj.builtin([3, 2, 1]))
# print(q2Obj.brute_force([1, 4, 5]))
# print(q2Obj.brute_force([4, 2, 5]))
# print(q2Obj.brute_force([4, 5, 3]))
    

class MaxOfThreeQ1:
    def brute_force(elements: list) -> int:
        temp, i = 0, 1

        while i < len(elements):
            if (elements[temp]) > elements[i]:
                i += 1
                continue
            else:
                temp = i
            i += 1
            
        return elements[temp]

    def builtin(elements: list) -> int:
        return max(elements)

q1Obj = MaxOfThreeQ1
# print(q1Obj.builtin([1, 8, 10]))
# print(q1Obj.brute_force([1, 2, 10]))
# print(q1Obj.brute_force([20, 1, 2]))
# print(q1Obj.brute_force([1, 30, 2]))

