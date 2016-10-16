var express = require('express');
var app = express();

app.set('port', (process.env.PORT || 5000));

var bodyParser = require("body-parser");
app.use(bodyParser.json()); // soporte para codificar json
app.use(bodyParser.urlencoded({ extended: true})); // soporte para decodificar las url

var firebase = require("firebase");

//var firebase = require("firebase"); ******************************
firebase.initializeApp({
  serviceAccount: "Mascotas-6ed53c049a5e.json",
  databaseURL: "https://mascotas-d90a9.firebaseio.com"
});

app.use(express.static(__dirname + '/public'));

// views is directory for all template files
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/android', function(request, response) {
  response.render('pages/index');
});

//POST
//https://gentle-cove-88606.herokuapp.com/token-device
//token
//user
var tokenDevicesURI = "token-device";
app.post("/token-device", function(request, response) {
    var token = request.body.token; // **************************************
    var user = request.body.user;
    
    var db = firebase.database();
    var tokenDevices = db.ref("/token-device").push(); // *****AQUI SE INSERTAN LOS REGISTROS
    tokenDevices.set({
        token: token,
        user: user
    });
    
    var path = tokenDevices.toString(); // se guarda --> https://mascotas-d90a9.firebaseio.com/-KU40HT4vLWgt_geHf4F
    var pathSplit = path.split("token-device/") //se genera un arreglo con los 2 trozos
    var idAutoGenerado = pathSplit[1]; // se guarda --> -KU40HT4vLWgt_geHf4F
    
    var respuesta = generarRespuestaAToken(db, idAutoGenerado);
    response.setHeader("Content-Type", "application/json");
    response.send(JSON.stringify(respuesta)); 
});

function generarRespuestaAToken(db, idAutoGenerado){
    var respuesta = {};
    var usuario = "";
    var ref = db.ref("token-device");
    ref.on("child_added" , function(snapshot, prevChildKey){
        usuario = snapshot.val(); // se guarda el ultimo registro insertado
        respuesta = {
            id: idAutoGenerado,
            token: usuario.token,
            user: usuario.user
            
        };
    });
    return respuesta;
}


//GET
//https://gentle-cove-88606.herokuapp.com/toque-usuario
//id
//user
app.get("/toque-usuario/:id/:user", function(request, response){
    var id      = request.params.id;
    var user    = request.params.user;
    
    var db = firebase.database();
    var ref = db.ref("token-device/" + id);
    var usuario = "";
    var respuesta = {};
    ref.on("value", function(snapshot) {
        usuario = snapshot.val();
        var mensaje = user + " Te dió un toque";
        respuesta = {
            id: id,
            token: usuario.token,
            user: usuario.user
            
        };
        response.send(JSON.stringify(respuesta));
    }, function (errorObject) {
        console.log("The read failed: " + errorObject.code);
        respuesta = {
            id: "",
            token: "",
            user: ""
        };
        response.send(JSON.stringify(respuesta));
    
    });
    
});

app.listen(app.get('port'), function() {
  console.log('Node app is running on port', app.get('port'));
});


