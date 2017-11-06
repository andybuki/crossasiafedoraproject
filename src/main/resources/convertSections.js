var _ = require('underscore');
var moment = require('moment');


var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.products, function(p) {
    return p;
});

request.body = JSON.stringify({
   "products": b.products,
    "products": _.map(books, function(p) {
      // noinspection JSAnnotator
        return {
          "id": p.identifier+"chapter",
          "chapter_id":p.identifier,
          "hasModel":"Chapter",
          "book_id": p.isPartOf,
          "title": p.title,
          "pageStart":p.pageStart,
          "pageEnd":p.pageEnd,
          "value":p.value
      }
    })
})
