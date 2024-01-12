from flask import Flask
from flask import request, redirect
import random
import joblib

app = Flask(__name__)



nextId=4
topics = [{'id':1, 'title':'html', 'body':'html is'},
{'id':2, 'title':'css', 'body':'css is'},
{'id':3, 'title':'js', 'body':'js is'}
 ]

def getContents():
    liTags = ''
    for topic in topics:
        liTags = liTags + f'<li><a href="{topic["id"]}">{topic["title"]}</a></li>'
    return liTags


def template(contents, content):
    return f'''
    <!doctype html>
    <html>
        <body>
            <h1><a href="/">WEB</a></h1>
            <ol>
                {contents}
            </ol>
            {content}
            <ul>
            <li><a href="/create/">create</a></li>
            </ul>
        </body>
    </html>'''
@app.route("/")
def index():

    return template(getContents(), '<h2>Welcome</h2>Hello, WEB')

@app.route("/read/<int:id>") # 값이 들어오고
def read(id):  # 함수 실행

    title=''
    body=''
    for topic in topics:
        if id==topic["id"]:
            title=topic["title"]
            body=topic["body"]
            break

    return template(getContents(), f'<h2>{title}</h2>{body}')

@app.route("/create/", methods=['GET','POST'])
def create():
    # action ="" 어떤 서버에 전송할 것인가
    print("request.method",request.method)
    if (request.method=='GET'):
        content='''
        <form action="/create/" method="POST"> 
        <p><input type="text" name="title" placeholder="title"></p>
        <p><textarea name="body" placeholder="body"></textarea></p>
        <p><input type="submit" value="create"></p>
        '''
        return template(getContents(),content)
    elif (request.method=='POST'):
        global nextId
        title=request.form['title']
        body=request.form['body']
        newtopic={"id":nextId,"title":title,"body":body}
        topics.append(newtopic)
        url='/read/'+str(nextId)
        nextId+=1
        return redirect(url)



app.run(port=5000, debug=True)