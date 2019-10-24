r = []
for i in range(100):
    r.append(str(i))
print(r[::10])  
MAX_PARAM = 10  
for j in range(len(r))[::MAX_PARAM]:
    print(','.join(r[j:j + MAX_PARAM]))
