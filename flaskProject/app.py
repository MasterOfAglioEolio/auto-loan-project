import json

from flask import Flask, request, redirect
from flask_restful import Resource, Api
from flask_cors import CORS
import traceback
import os
import prediction
from flask import jsonify

app = Flask(__name__)



@app.route("/api/judgment", methods=['POST'])
def post():
    try:
        print("post")
        print(request)
        data = request.get_json()
        if 'customerInfo' in data:
            customer_info = data['customerInfo']
            print("[customer_info]", customer_info)
            data.update(customer_info)
            del data['customerInfo']
            print("[update_data]", data)
        response = json.dumps(prediction.predict_data(data))
        print("result:", response)
        return response

    except Exception as error:
        # return {'error':'error'}
        error_msg = traceback.format_exc()
        print(error_msg)
        return {'error': error_msg}

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5001))
    app.run(port=port, debug=True)
