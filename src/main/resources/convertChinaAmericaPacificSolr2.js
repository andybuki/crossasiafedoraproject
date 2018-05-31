var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.products, function(p) {
    return p;
});



request.body = JSON.stringify({
    //"products": b.dataExport,
    "products": _.map(books, function(p) {

        return {
            "id": p.id,
            "hasModel": p.hasModel,
            "nodeId": p.nodeId,
            "book_id": p.book_id,
            "identifier": p.identifier,
            "title": p.title,
            "author": p.author,
            "date": p.date,
            "publication_place": p.publication_place,
            "publication_name": p.publication_name,
            "edition": p.edition,
            "description": p.description,
            "medium": p.medium,
            "subject":(p.subject+ "," +p.subject1.split(";")).split(","),
            "keywords": p.keywords,
            "collection": p.collection,
            "source": p.source,
            "spatial": p.spatial,
            "person": p.person,
            "series_title": p.series_title,
            "publisher": p.publisher,
            "language": p.language,
            "issued": p.issued


        }
    })
})
