var _ = require('underscore');
var moment = require('moment');


var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.products, function(p) {
    return p;
});

request.body = JSON.stringify({
   "products": b.products,
    "products": _.map(books, function(p) {
      return {
          "id":p.id+'_airiti',
          "hasModel":"Page",
          "book_id": p.book_id,
          "position":p.position,
          "text":p.text
      }
    })
})
