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