import pandas as pd
data = [12, 15, 18, 15, 20]
df = pd.DataFrame(data)
print(df)
print("\n")


import numpy as np
data = [12, 15, 18, 20]
df1 = np.sort(data)
print(df1)
print("\n")


import matplotlib.pyplot as plt
df2 = [12,15,18,20]
#plt.hist(df2)
#plt.show()


import matplotlib.pyplot as plt
import numpy as np

data = [12,15,18,20,22,25,30]

#plt.hist(data, bins=5)
#plt.show()

data = np.sort(data)
cf = np.arange(1, len(data) + 1)

plt.title("Line graph 😂😂")
plt.plot(data, cf)
plt.show()


#plt.pie(data, autopct = "%1.1f%%")
#plt.show()
