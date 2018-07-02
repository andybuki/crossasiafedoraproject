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
          "id":p.schema_ISBN+"book",
          "hasModel":"Book",
          "title": p.dcterms_title,
          "title_transcription":[[p.dcndl_titleTranscription]+"",""+[p.dcndl_titleTranscription2]+"",""+[p.dcndl_titleTranscription3]],
          "creator_transcription": [[ p.dcndl_creatorTranscription]+"",""+[p.dcndl_creatorTranscription2]+"",""+[p.dcndl_creatorTranscription3]+"",""+[p.dcndl_creatorTranscription4]+"",""+[p.dcndl_creatorTranscription5]+"",""+[p.dcndl_creatorTranscription6]],
          "author": [[p.dcterms_creator]+"",""+[p.dcterms_creator2]+"",""+ [p.dcterms_creator3]],
          "language": p.dcterms_language,
          "medium": [[p.mods_physicalDescription]+"",""+[p.mods_physicalDescription2]],
          "book_id": p.schema_ISBN,
          "issued": p.dcterms_issued,
          "keywords":[[p.schema_keywords]+"",""+[p.schema_keywords2]+"",""+[p.schema_keywords3]],
          "series_title": p.dcndl_seriesTitle,
          "series_title_transcription": p.dcndl_seriesTitleTranscription,
          "alternative":p.dcterms_alternative,
          "publication_place":p.dcndl_publicationPlace,
          "publisher":p.dcterms_publisher,
          "description":p.dcterms_description,
          "mods_genre":p.mods_genre,
          "identifier_type_ISSN":p.dcterms_identifier_type_ISSN,
          "extent":p.dcterms_extent,
          "subject_xsi_type":p.dcterms_subject_xsi_type,
          "subject":p.dcterms_subject,
          "identifier":p.dcterms_identifier,
          "identifier_xsi_type_CrossAsia_Link":p.dcterms_identifier_xsi_type_CrossAsia_Link,
          "source":p.schema_source,
          "publication_id":p.dcterms_identifier_xsi_type_CrossAsia_Link.replace('http://erf.sbb.spk-berlin.de/han/airiti/www.airitibooks.com/detail.aspx?PublicationID=','')
      }
    })
})
