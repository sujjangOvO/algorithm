# 문자열 뒤집기
# 111000110011 애는 왜 답이 2로 안ㅇ나오지

data = input()
count0 = 0
count1 = 0 # 전부 0으로 바뀌는 경우, 전부 1으로 바뀌는 경우

if data[0] == '1': # 첫번쨰 원소
    count0 += 1
else:
    count1 += 1

for i in range(len(data)-1): # 범위에 -1을 해줘야 i+1에서 범위 예외가 발생하지 않는다. 
    if data[i] != data[i+1]: # 연속되지 않은 경우
        if data[i+1] == '1': # 0에서 1으로 바뀌는 경우
            count0 += 1
        else : # 1에서 0으로 바뀌는 경우
            count1 += 1

print(min(count0,count1)) # 둘 중에 횟수가 적은 걸로 선택


""" 왜지 ㅜㅜ
s = list(map(int,input()))
c0 = s.count(0)
c1 = s.count(1)
count = 0

if c0 >= c1: # 0이 더 많으니 1을 뒤집고
    location = s.index(1)
    for i in range(location,len(s)-1): # 연속되는 1을 찾아서 바꾸자 
        if(s[i] != s[i+1] and s[i+1] !=1) : # 1에서 0으로 바뀔 떄만 count한다. 0에서 1으로 바뀔 떈 count X
            count += 1

else: # 1이 더 많으니 0을 뒤집자, c0과 c1이 같다면 둘 중 뭐로 바꿔도 같으니 상관 없음.
    location = s.index(0)
    for i in range(location, len(s)-1):
        if(s[i] != s[i+1] and s[i+1] != 0): # 0에서 1으로 바뀔 떄만 count한다. 1에서 0으로 바뀔 땐 count X
            count += 1

print(count)

"""
