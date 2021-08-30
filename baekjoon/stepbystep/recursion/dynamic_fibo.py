n=int(input('n='))

farr=[]
sarr=[]
result=0
string=""

		
farr.append(4)
farr.append(5)       	
sarr.append(farr[0])
	

if n>1 :
	for i in range(2,n+1):
		farr.append(farr[i-1]+farr[i-2])

		
		
if n>0:
	for i in range (1,n+1):
		sarr.append(sarr[i-1]+farr[i])


		
for i in range (0,n+1):
	result+=sarr[i]

		
string=str(result)
#print(len(string))

if len(string)>10:
    print(string[-10:])
else:
    print(string)    
		
	
	

