var _ = require('underscore');
var moment = require('moment');


var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.products, function(p) {
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
    "@graph": b.products,
    "@graph": _.map(books, function(p) {
      return {
          "fedora:hasModel": "Page",
          "@type": "pcdm:Object",
          "@id": "",
          "id":p.id,
          "dcterms:isPartOf": p.book_id,
          "identifier": p.identifier,
          "schema:position":p.position,
          "schema:text": p.text,
          "schema:image":p.image_file,
          "dcterms:identifier":p.image_url
    }
    })
})
