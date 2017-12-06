var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.dataExport, function(p) {
    return p;
});

request.body = JSON.stringify({
    "book": b.dataExport,
    "book": _.map(books, function(p) {
                return {
                    "id": p.nodeId + "book",
                    "hasModel": "Book",
                    "nodeId": p.nodeId,
                    "book_id": p.ImageDirectory,
                    "identifier": p.Url,
                    "title": p.Title,
                    "author": p.Author,
                    "date": p.Date,
                    "publication_place": p.PlaceofPublication,
                    "publication_name": [[p.Publisher] + "", "" + [p.PrintedBy]],
                    "edition": [[p.Reference] + "", "" + [p.Library]],
                    "description": [[p.Description] + "", "" + [p.Notes]],
                    "medium": [["text"]+ "", "" +["Records (Documents)"]+ "", "" +[p.DocumentType] + "", "" + [p.PhysicalCharacteristics]],
                    "subject": [[p.Themes] + "", "" + [p.Countries] + "", "" + [p.Region]],
                    "organization" :  p.Organisations,
                    "keywords": p.Topics.split(";"),
                    "source": p.Copyright,
                    "spatial" : p.Places.split(";"),
                    "person" : p.People.split(";"),
                    "series_title": [[p.TopLevelCollection] + "", "" + [p.Collection]],
                    "publisher": p.Office,
                    "language": p.Language,
                    "publication_volume": p.VolumeNumber,
                    "volume_number": p.IssueNumber
                }
    })
})
