# Linear Search on a music playlist
# Trying to find a specific song on a music playlist

print("\n")
print("Linear Search to find a song in a music playlist")
print("\n")

playlist = [
    "Blitz",
    "New Money",
    "Back In The Mix",
    "MM3",
    "On The Low",
    "On That Time",
    "Teenage Soldier",
    "No Brainer",
    "Holy Smokes",
    "Nightcore 2",
    "Half Off",
    "U Don't Know Lyfe",
    "Almost Back",
    "Wake up"
]

# Defining the song to search
song = "Half Off"

def linear_search(arr, song):

    #Looping through each element
    for i in range(len(arr)):

        #Checking if current element matches the song
        if arr[i] == song:
            return i    # Returning index if the index is found
    
    print("Song not found")
    return -1

index = linear_search(playlist, song)
if index != -1:
    print(f"Linear search: '{song}' found at index {index}")

print("\n")

# Linear search method is used because the songs are unsorted
# Binary search cannot be used unless the songs are sorted first
# As the data becomes larger, this method becomes slow as there are more songs to go through one by one in the playlist


# Binary Search on a music playlist
# Trying to find a song on a sorted music playlist

print("\n")
print("Binary search to find a song on a music playlist")
print("\n")

playlist = [
    "Blitz",
    "New Money",
    "Back In The Mix",
    "MM3",
    "On The Low",
    "On That Time",
    "Teenage Soldier",
    "No Brainer",
    "Holy Smokes",
    "Nightcore 2",
    "Half Off",
    "U Don't Know Lyfe",
    "Almost Back",
    "Wake up"
]

# Defining the song to search
song = "Half Off"

# Sorting the playlist before searching for the song
playlist.sort()

def binary_search(arr, song):
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2

        # Checking if the middle element is the song
        if arr[mid] == song:
            return mid
        
        # If song is greater, ignore left side
        elif arr[mid] < song:
            left = mid + 1

        # If song is less, ignore right side
        else:
            right = mid - 1

    print("Song not found")
    return -1

index = binary_search(playlist, song)

print("Sorted playlist: ", playlist)
print("\n")
print(f"Binary search: '{song}' found at {index}")
print("\n")

# Binary search is used as the songs are sorted
# Linear search can be used but it will be slower
# When the data becomes large, sorting may take some time