var _ = require('underscore');
var moment = require('moment');


var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b, function(p) {
    return p;
});

request.body = JSON.stringify({
    "@context": {
        "fedora": "http://fedora.info/definitions/v4/2016/10/18/repository#",
        "pcdm": "http://pcdm.org/models#",
        "book_id": "http://schema.org/dc:identifier",
        "position": "http://schema.org/position",
        "text": "http://schema.org/text",
        "dc": "http://purl.org/dc/elements/1.1/",
        "dcndl":"http://ndl.go.jp/dcndl/terms",
        "schema":"http://schema.org/",
        "dcterms":"http://purl.org/dc/terms/"

    },
    "@id": "urn:x-arq:DefaultGraphNode",
    "@graph": b,
    "@graph": _.map(books, function(p) {
      return {
          "fedora:hasModel": "Book",
          "@type": "pcdm:Object",
          "@id": "",
          "id":p.nodeId+"book",
          "book_id": p.book_id,
          "identifier": p.identifier,
          "dc:title": p.title,
          //"dc:creator": p.author,
          "dc:date": p.date,
          //"dcndl:publicationPlace": p.publication_place,
          "dc:edition": p.edition,
          //"dcterms:rightsHolder": p.source,
          //"dc:description": p.description,
          "dcterms:spatial" : p.spatial,
          "schema:Person" : p.person,
          "schema:keywords": p.keywords,
          //"dc:subject": p.subject,
          //"schema:Organization" :  p.organization,
          "dc:medium": p.medium,
          //"dcndl:seriesTitle": p.series_title,
          "dc:language": p.language
          //"dc:publisher": [p.publisher  + "", "" +  p.publication_name],
          //"dcndl:publicationVolume": p.publication_volume,
          //"dcndl:issue": p.volume_number
      }
    })
})
