var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.products, function(page) {
    return page;
});

request.body = JSON.stringify({
    "products": b.products,
    "products": _.map(books, function(page) {
     var bookId = page.book_id.toString();
            return {
                "id": page.id,
                "hasModel": "Book",
                "nodeId": page.nodeId,
                "book_id": bookId.replace(/\s/g, "_"),
                //"book_id": bookId.trim(),
                "identifier": page.identifier,
                "title": page.title,
                "author": page.author,
                "date": page.date,
                "publication_place": page.publication_place,
                "publication_name": page.publication_name,
                "edition": page.edition,
                "description": page.description,
                "medium": page.medium,
                "subject": page.subject,
                "organization": page.organization,
                "keywords": page.keywords,
                "source": page.source,
                "spatial": page.spatial,
                "person": page.person,
                "series_title": page.series_title,
                "publisher": page.publisher,
                "language": page.language,
                "publication_volume": page.publication_volume,
                "volume_number": page.volume_number
            }
    })
})
