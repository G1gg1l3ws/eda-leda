import matplotlib.pyplot as plt
import numpy as np
from organizador_dados import generate_dataframe

plt.ion()

df = generate_dataframe("../../data/sample.txt")

fig, ax = plt.subplots()
plt.plot(df["size"], df["time"])

plt.show()
