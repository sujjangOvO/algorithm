n=int(input())
score=[]
for i in range(n):
    score.append(0)

scores=input().split()

for i in range(n):
    score[i]=int(scores[i])

Max=max(score) # 최고점

for i in range(len(score)):
    score[i]=(score[i]/Max)*100

print(sum(score)/len(score))