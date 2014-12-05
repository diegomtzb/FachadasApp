from multiprocessing import Process
#from paste import httpserver
from bottledaemon import daemon_run
import re
import json
import bottle
import pymongo
import os
from bottle import route, run, request, abort 
from pymongo import MongoClient
from json import JSONEncoder
from bson.objectid import ObjectId
from bson.json_util import dumps


class MongoEncoder(JSONEncoder):
    def _iterencode(self, o, markers=None):
        if isinstance(o, ObjectId):
            return """ObjectId("%s")""" % str(o)
        else:
            return JSONEncoder._iterencode(self,o,markers)

uri = "mongodb://alorot:123456@ds041140.mongolab.com:41140/my_database" 
connection = MongoClient(uri)
db = connection.my_database

template = """<html>
<head><title>Home</title></head>
<body>
<h1>Upload a file</h1>
<form method="POST" enctype="multipart/form-data" action="/">
<label>Level:</label> <input type="text" name="level" value="42"/><br>
<input type="file" name="uploadfile" /><br>
<input type="submit" value="Submit" />
</form>
</body>
</html>"""

@route('/')
def home():
	return template

@route('/', method='POST')
def upload():
    upload_file = request.POST['uploadfile']
    level = int(request.POST['level'])
    save_path = '/tp'
    if not os.path.exists(save_path):
        os.makedirs(save_path)
    file_path='/tp/pip.png'
    upload_file.save(file_path)
    return 'Ok'
 
@route('/documents', method='POST')
def post_document():
    print "+++++IN******"
    data = request.body.readline()
    print "DATA"
    print data
    if not data:
        abort(400, 'No data received')
    json_string = json.dumps(data)
    print "json llega: " + json_string
    #json_string = json_string.replace('=', ':')
    #json_string = '{' + json_string + '}'
    #json_string = json_string.replace('&', ',')
    #json_string = json_string.replace('"', '')
    #json_string = json_string[5:]
    #m = re.search('_id=(.+?)&', json_string)
    #if m:
        #found = m.group(1)
    #id=found

    m = re.search('descripcion=(.+?)&', json_string)
    if m:
        found = m.group(1)
    descripcion = found
    
    m = re.search('autor=(.+?)"', json_string)
    if m:
        found = m.group(1)
    autor = found

    #json_string = '{"_id": "' + id + '", "descripcion": "' + descripcion + '", "apellido": "' + apellido + '"}'
    json_string = '{"descripcion": "' + descripcion + '", "autor": "' + autor + '"}'
    print json_string
    entity = json.loads(json_string)
    #if not entity.has_key('_id'):
        #abort(400, 'No _id specified')
    try:
        db['documents'].save(entity)
    except ValidationError as ve:
        abort(400, str(ve))
     
@route('/documents/:id', method='GET')
def get_document(id):
    entity = db['documents'].find_one({'_id':id})
    if not entity:
        abort(404, 'No document with id %s' % id)
    return entity

@route('/documents', method='GET')
def get_documents():
    print("here")
    print ("/documents method GET")
    #response.content_type = 'application/json'
    
    #objdb = db['documents'].find()
    #entries = [entry for entry in objdb]
    #return MongoEncoder().encode(entries)
    
    #json_docs = []
    #entity  = db['documents'].find()
    #for doc in db['documents'].find():
        #json_doc = json.dumps(doc, default=json_util.default)
        #json_docs.append(json_doc)
    #print (json_docs)
    lista = []
    for doc in db['documents'].find():
        doc = dumps(doc)
        #print("SOY DOC: " + doc)
        lista.append(doc)
    print("ESTA ES LA LISTA DE RESPUESTA") 
    #print(lista)
    return '{"documents" :[%s]}' % ', '.join(map(str, lista))
    #return {"documents" :[{"descripcion": "Descripcion", "autor": "autor", "_id": "ID"}]}
    #entity = db.documents.find()
    #if not entity:
        #abort(404, 'No documents')
    #print(entity)
    #entity = dumps(entity)
    #print("ok")    
    #return entity

@route('/upload', method='POST')
def do_upload():
    category = request.forms.get('category')
    #upload = request.files.get('upload')
    upload = request.body.readline()
    #name, ext = os.path.splitext(upload.filename)
    ext = '.png'
    if ext not in ('.png','.jpg','.jpeg'):
        return 'File extension not allowed.'
    #save_path = get_save_path_for_category(category)
    save_path = '/tmp'
    upload.save(save_path) # appends upload.filename automatically
    return 'OK'

#run(host='0.0.0.0', port=8080)

#if __name__ == "__main__":
    #daemon_run()
#Process(target=daemon_run(),kwargs=dict(host='0.0.0.0', port=8080))
#httpserver.serve(daemon_run(),host='0.0.0.0', port=80)


run(host='0.0.0.0',port=8080)
