print ("------- Linear Search -------")
print("\n")

def linear_search(arr,target):
    for i in range(len(arr)):
        print(f"Checking index {i}, value: {(arr[i])}")

        if arr[i] == target:
            print("match found")
            return i
    
    print("No match found")
    return -1

marks = [20, 50, 170, 230, 322, 421, 552, 670, 705, 891, 913]
target = 705

result = linear_search(marks, target)
print(result)
print("\n")


print ("------- Binary Search -------")
print("\n")

def binary_search(arr, target):
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2
        print(f"Left: {left}, Right: {right}, Mid: {mid}, value: {arr[mid]}")

        if arr[mid] == target:
            print("Match Found")
            return mid
    
        elif arr[mid] < target:
            print("Going right")
            left = mid + 1
    
        else:
            print("Going left")
            right = mid - 1
        
    print("No match")
    return -1

marks = [20, 50, 170, 230, 322, 421, 552, 670, 705, 891, 913]
target = 705

result = binary_search(marks, target)
print(result)