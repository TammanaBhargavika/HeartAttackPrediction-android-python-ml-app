import numpy as np
import pickle

from flask import Flask, redirect, url_for, jsonify, request,render_template
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
   
   name=request.json['name']
   #values.append(name)
   
   age=request.json['age']
   values.append(age)
   
   sex=request.json['sex']
   values.append(sex)

   cp=request.json['cp']
   values.append(cp)

   trp=request.json['trp']
   values.append(trp)

   cholestrol=request.json['cholesterol']
   values.append(cholestrol)

   fbs=request.json['fbs']
   values.append(fbs)

   ecg=request.json['Ecg']
   values.append(ecg)

   Thalaz=request.json['Thalaz']
   values.append(Thalaz)

   Exong=request.json['Exong']
   values.append(Exong)

   Oldpeak=request.json['Old Peak']
   values.append(Oldpeak)

   slope=request.json['slope']
   values.append(slope)

   ca=request.json['ca']
   values.append(ca)

   thal=request.json['thal']
   values.append(thal)
   
   final_values=[np.array(values)]
   print(final_values)
   
   prediction=model.predict(final_values)
   print(prediction)
   
   result=prediction
   print(result)
   
   if result==0:
       return render_template('result.html',name=name,age=age,sex=sex,cp=cp,trp=trp,cholestrol=cholestrol,fbs=fbs,ecg=ecg,Thalaz=Thalaz,Exong=Exong,Oldpeak=Oldpeak,slope=slope,ca=ca,thal=thal,rrr=0)
   else:
       return render_template('result.html',name=name,age=age,sex=sex,cp=cp,trp=trp,cholestrol=cholestrol,fbs=fbs,ecg=ecg,Thalaz=Thalaz,Exong=Exong,Oldpeak=Oldpeak,slope=slope,ca=ca,thal=thal,rrr=1)


if __name__ == '__main__':
   app.run(debug=True,use_reloader=False)
