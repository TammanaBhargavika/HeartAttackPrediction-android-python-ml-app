import numpy as np
import pickle

from flask import Flask, redirect, url_for,jsonify, request,render_template
app = Flask(__name__)
model = pickle.load(open('model.pkl', 'rb'))

@app.route('/')
def index():
   return render_template("index.html")

@app.route('/ff',methods = ['POST', 'GET'])
def ff():
   return render_template("predict.html")

@app.route('/predict',methods = ['POST', 'GET'])
def predict():
   # Age Gender Trp Cholestrol Fbs Ecg Thalach Exang OldPeak Slope
   values=[]
   
   name=request.form['name']
   
   age=request.form['age']
   values.append(age)
   
   sex=request.form['sex']
   values.append(sex)

   cp=request.form['cp']
   values.append(cp)

   trp=request.form['trp']
   values.append(trp)

   cholestrol=request.form['cholesterol']
   values.append(cholestrol)

   fbs=request.form['fbs']
   values.append(fbs)

   ecg=request.form['Ecg']
   values.append(ecg)

   Thalaz=request.form['Thalaz']
   values.append(Thalaz)

   Exong=request.form['Exong']
   values.append(Exong)

   Oldpeak=request.form['Old Peak']
   values.append(Oldpeak)

   slope=request.form['slope']
   values.append(slope)

   ca=request.form['ca']
   values.append(ca)

   thal=request.form['thal']
   values.append(thal)
   
   final_values=[np.array(values)]
   print(final_values)
   
   prediction=model.predict(final_values)
   print(prediction)
   
   result=prediction
   print(result)
   
   if result==0:
      return {'message':'You are Diagnised'}      
   else:
      return {'message':'You are not Diagnised'}     


if __name__ == '__main__':
   app.run(debug=True,use_reloader=False)
