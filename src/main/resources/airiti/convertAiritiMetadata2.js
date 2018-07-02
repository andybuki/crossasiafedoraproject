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
          "id":p.id+"airiti",
          "hasModel":"Book",
          "title": p.title,
          "title_transcription":p.title_transcription,
          "creator_transcription": p.creator_transcription,
          "author": p.author,
          "language": p.language,
          "medium": p.medium,
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
