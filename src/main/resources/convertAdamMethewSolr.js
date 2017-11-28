var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))
var books = _.filter(b.dataExport, function(p) {
    return p;
});

request.body = JSON.stringify({
    "dataExport": b.dataExport,
    "dataExport": _.map(books, function(p) {

                return {
                    "name": p.name,
                    "id": p.nodeId + "book",
                    "hasModel": "Book",
                    "nodeId": p.nodeId,
                    "ID": p.ImageDirectory,
                    "identifier": p.Url,
                    "title": p.Title,
                    "author": p.Author,
                    "date": p.Date,
                    "publication_place": p.PlaceofPublication,
                    "publication_name": [[p.Publisher] + "", "" + [p.PrintedBy]],
                    "description": [[p.Reference] + "", "" + [p.Library] + "", "" + [p.Copyright] + "", "" + [p.Notes] + "", "" + [p.Description]],
                    "medium": [[p.DocumentType] + "", "" + [p.PhysicalCharacteristics]],
                    "subject": [[p.Themes] + "", "" + [p.Countries] + "", "" + [p.Region]],
                    "keywords": [[p.Places] + "", "" + [p.People] + "", "" + [p.Topics] + "", "" + [p.Organisations]],
                    "series_title": [[p.TopLevelCollection] + "", "" + [p.Collection]],
                    "publisher": p.Office,
                    "language": p.Language,
                    "volume_number": p.VolumeNumber,
                    "issue_number": p.IssueNumber
                }

    })
})
