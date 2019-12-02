import pandas as pd
import numpy as np

def test_feather():
    afile = 'test_a_file'
    sz =1000000
    df = pd.DataFrame({'A': np.random.randn(sz), 'B': [1] * sz})
    df.to_hdf(afile, 'test', mode='w')
    df = pd.read_hdf(afile, 'test')
    print(df)
    df = pd.read_hdf(afile, '')


test_feather()
