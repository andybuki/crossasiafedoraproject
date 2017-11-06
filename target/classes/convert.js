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
          "books_id": p.identifiert,
          "title": p.title,
          "title_transcription": p.titleTranscription +' '+ p.titleTranscription1,
          "series_titles": p.seriesTitle,
          "creator": p.creator +' '+ p.creator1 +' '+ p.creator2,
          "creator_transcription": p.creatorTranscription+' '+p.creatorTranscription1+' '+p.creatorTranscription2+' '+p.creatorTranscription3+' '+p.creatorTranscription4,
          "physical_description": p.physicalDescription+' '+p.physicalDescription1,
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
