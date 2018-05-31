var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b, function(p) {
    return p;
});

request.body = JSON.stringify({
    //"book": b,
    "": _.map(books, function(p) {
                return {
                    "id": p.id,
                    "title":p.title,
                    "hasModel":p.hasModel,
                    "collection":p.collection,
                    "wholeDate":p.wholeDate,
                    "date":p.wholeDate.substr(0,4),
                    "page": p.page,
                    "medium":p.medium,
                    "language":p.language,
                    "text":p.text,
                    "description":p.description,
                    "journal_title":p.journal_title
                }
    })
})
