from flask import Flask
import pickle
import pandas as pd
import test_data
import json
import sklearn
import logging
# pd.set_option('display.max_columns', None)
app = Flask(__name__)
app.logger.setLevel(logging.INFO)

retire_features=test_data.retire_features
retire={'Default':"model_retire_Default.pkl",'InterestRate':'model_retire_InterestRate.pkl'}
incumbent_features=test_data.incumbent_features
incumbent={'Default':"model_incumbent_Default.pkl",'InterestRate':'model_incumbent_InterestRate.pkl'}
keys=test_data.keys

def data_encoding(data):
    print('stattus')
    app.logger.info('Info level log')
    df = pd.DataFrame()
    for key in keys:
        if key in data:
            df[key]=pd.Series(data[key])
    print("df_CHECK",len(df.columns))
    print("keys_check",len(keys))
    for key in keys:
        if key not in df.columns:
            print("!!!!!",key)
    # if 'EmployedYears' in data:
    if 'EmployedYears' in data and data['employedYears'] == '':
        print('reitre')
        print('encoding')
        df_onehot = pd.get_dummies(df)
        for feature in incumbent_features:
            if feature not in df_onehot.columns:
                df_onehot[feature] = 0

        df_onehot = df_onehot[incumbent_features]
        df_onehot.drop(columns='employedYears', inplace=True)
        print("encoded:", df_onehot)
        return df_onehot
    else:
        print('incumbent', data["employedYears"])
        print('encoding')
        df_onehot = pd.get_dummies(df)
        for feature in incumbent_features:
            if feature not in df_onehot.columns:
                df_onehot[feature] = 0

        df_onehot = df_onehot[incumbent_features]
        print("encoded:", df_onehot)
        return df_onehot

def Employment_status(data):
    print('stattus')
    app.logger.info('Info level log')
    # if 'EmployedYears' in data:
    if data['employedYears'] == '':
        print('reitre')
        return load_models(retire)
    else:
        print('incumbent',data["employedYears"])
        return load_models(incumbent)

def load_models(model_dict):
    loaded_models = {}
    for key, value in model_dict.items():
        with open(value, 'rb') as file:
            loaded_models[key] = pickle.load(file)
    print("load_models",loaded_models)
    return loaded_models

# @app.route('/predict', methods=['POST'])
def predict_data(data):
    ##loading the model from the saved file
    print("post data:",data)
    if type(data) == dict:
        df_encoding = data_encoding(data)
    else:
        df = data
        return 'error'

    models=Employment_status(data)


    print("models",models)
    print("df",df_encoding)
    print("asd",models['Default'].predict(df_encoding))
    Default_pred = models['Default'].predict(df_encoding)
    InterestRate_pred = models['InterestRate'].predict(df_encoding)
    print(Default_pred, InterestRate_pred)

    if Default_pred == 0:
        print('y_pred', Default_pred)
        print('Interest_rate : {:.2}'.format(InterestRate_pred[0]))
        return {'judgment': 'pass','interestRate' : round(InterestRate_pred[0],2)}
    elif Default_pred == 1:
        print('y_pred', Default_pred)
        print('Interest_rate : {:.2}'.format(InterestRate_pred[0]))
        return {'judgment': 'fail','interestRate' : round(InterestRate_pred[0],2)}


# predict(data)
