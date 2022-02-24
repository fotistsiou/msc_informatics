import random, hashlib

am="210**"

tmp=hashlib.sha256(am.encode()).hexdigest()

seed=int(tmp,16)

random.seed(seed)

lst=list(range(1,14))

random.shuffle(lst)

print(lst[:4])