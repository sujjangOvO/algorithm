# 곱하기 혹은 더하기

s = list(map(int,input())) # 0부터 9로 이루어진 문자열을 각 자리 숫자로 나누기 위해 리스트 형식으로 변환
result = s[0] # 첫번째 수

# 두 수가 둘 다 2이상일 때만 곱하기
for i in range(1,len(s)):
    second = s[i]
    if result > 1 and second > 1:
        result *= second
    else :
        result += second

print(result) 



"""
s = list(map(int,input())) 
result = 1 

for i in range(len(s)):
    if s[i] not in [0,1]:
        result *= s[i] 
        continue
    result += s[i] 

print(result)

# 이렇게 하면 result가 1이고 s[i]도 1일때 result가 2가 되어버리기 때문에 틀린 답
# result 초기값을 0으로 바꾼다면? 만약 s[i]가 0,1이 아니라면 곱해도 0이 되어버리기 때문에 틀린 답

"""

