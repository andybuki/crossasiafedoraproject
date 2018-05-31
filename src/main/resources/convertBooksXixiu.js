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
          "contained_in":p.contained_in,
          "creator":p.creator,
          "creator_transcription": p.creator_transcription,
          "edition":p.edition,
          "genre": p.genre,
          "hasModel": p.hasModel,
          "collection": p.collection,
          "id": p.id,
          "book_id": p.identifier[1],
          "identifier": p.identifier,
          "issued":p.issued,
          "language": p.language,
          "note": p.note,
          "physical_description":p.physical_description,
          "spatial":p.spatial,
          "publisher":p.publisher,
          "series_title":p.series_title,
          "series_title_transcription":p.series_title_transcription,
          "subject":p.subject,
          "thumbnail_path":p.thumbnail_path,
          "title":p.title,
          "title_transcription":p.title_transcription

      }
    })
})
