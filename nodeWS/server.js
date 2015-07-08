var express = require('express'),
    devoirs = require('./routes/devoirs');
 
var app = express();
 
app.configure(function () {
    app.use(express.logger('dev'));     /* 'default', 'short', 'tiny', 'dev' */
    app.use(express.bodyParser());
});

//Methode de recherche des devoirs par date 
app.get('/devoir.json', devoirs.findByDate);

//Methode de mise a jour de la notation du groupe sur un devoir
app.post('/devoir/notation', devoirs.updateNotation);

app.listen(3000);
console.log('Listening on port 3000...');
