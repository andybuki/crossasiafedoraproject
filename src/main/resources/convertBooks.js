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
          "id":p.identifiert+"book",
          "hasModel":"Book",
          "book_id": p.identifiert,
          "title": p.title,
          "author": [[p.creator]+"",""+[p.creator1]+"",""+ [p.creator2]],
          "title_transcription": [[p.titleTranscription]+"",""+[p.titleTranscription1]],
          "creator_transcription": [[ p.creatorTranscription]+"",""+[p.creatorTranscription1]+"",""+[p.creatorTranscription2]+"",""+[p.creatorTranscription3]+"",""+[p.creatorTranscription4]],
          "medium": [[p.physicalDescription]+"",""+[p.physicalDescription1]],
          "series_title": p.series_title,
          "issued": p.issued,
          "date": p.date,
          "edition": p.edition,
          "temporal": p.temporal,
          "admin_level_1": p.admin_level_1,
          "admin_level_2": p.admin_level_2,
          "admin_type": p.admin_type,
          "spatial": p.spatial,
          "tgaz_api": p.tgaz_api,
          "chgis": p.chgis,
          "latitude": p.latitude,
          "longitude": p.longitude,
          "language": p.language,
          "url": p.url,
          "responsibility":p.responsibility,
          "comment": p.comment
      }
    })
})
