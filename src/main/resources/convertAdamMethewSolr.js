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
          "id":p.identifiert+"book",
          "hasModel":"Book",
          "book_id": p.identifiert,

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
          "comment": p.comment,
          "ID":p.ImageDirectory,
          "identifier":p.Url,
          "title": p.Title,
          "description":p.Reference,
          "author":p.Author,
          "date":p.Date,
          "publication-place":p.PlaceofPublication,
          "publication-name":p.Publisher,
          "description":p.Library,
          "description":p.Copyright,
          "description":p.Notes,
          "medium":p.DocumentType,
          "description":p.Description,
          "subject":p.Themes,
          "keywords":p.Places,
          "keywords":p.People,
          "keywords":p.Topics,

          "publisher":p.Office,
          "subject":p.Countries,
          "subject":p.Region,
          "keywords":p.Organisations,
          "medium":p.PhysicalCharacteristics,
          "language":p.Language,
          "series-title":p.Collection,
          "series-title":p.TopLevelCollection,
          "publication-name":p.PrintedBy,
          "volume-number":p.VolumeNumber,
          "issue-number":p.IssueNumber




    }
    })
})
