import pandas as pd
import numpy as np

def generate_dataframe(file_path):
    data_frame = pd.read_csv(file_path, sep = r"\s+")
   
    return data_frame
