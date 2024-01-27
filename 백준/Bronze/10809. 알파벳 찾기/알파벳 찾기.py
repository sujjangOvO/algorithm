s=input()
arr=['a','b','c','d','e','f','g','h','i','j','k',
'l','m','n','o','p','q','r','s','t','u','v',
'w','x','y','z']
location=[-1 for i in range(len(arr))]

for i in range(len(arr)):
    if arr[i] in s:
        location[arr.index(arr[i])]=s.index(arr[i])

for i in range(len(arr)):
    print(location[i], end=' ')
    