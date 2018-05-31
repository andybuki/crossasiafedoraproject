var _ = require('underscore');
var moment = require('moment');


var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b, function(p) {
    return p;
});

request.body = JSON.stringify({
   "products": b,
    "products": _.map(books, function(p) {
      return {
          "id":p.id,
          "page_id":p.page_id,
          "hasModel":p.hasModel,
          "book_id": p.book_id,
          "position":p.position,
          "collection":p.collection,
          "text":p.text,
          "language":p.language,
          "chapter_id":p.chapter_id.split(",")
      }
    })
})
