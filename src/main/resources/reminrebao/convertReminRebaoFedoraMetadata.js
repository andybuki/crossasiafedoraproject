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
          "@type": "pcdm:Object",
          "@id": "",
          "id":p.id,
          "dc:title":p.title,
          "dcterms:publicationPlace" : "北京",
          "dcterms:issued":p.wholeDate,
          "schema:isPartOf":"人民日报电子版",
          "dcterms:medium":"newspaper"
    }
    })
})
