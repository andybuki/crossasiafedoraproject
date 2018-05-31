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
        "dc": "http://purl.org/dc/elements/1.1/",
        "dcndl":"http://ndl.go.jp/dcndl/",
        "schema":"http://schema.org/",
        "dcterms":"http://purl.org/dc/terms/",
        "rdf": "http://www.w3.org/1999/02/22-rdf-syntax-ns#",
        "rdfs": "http://www.w3.org/2000/01/rdf-schema#",
        "xsd": "http://www.w3.org/2001/XMLSchema#",
        "xsi": "http://www.w3.org/2001/XMLSchema-instance",
        "CHGIS": "dcterms:identifier",
        "TGAZ API":"dcterms:identifier",
        "Erudition LocGaz":"dcterms:identifier",
        "CrossAsia Lizenz":"dcterms:identifier",
        "mods": "http://www.loc.gov/mods/modsrdf/v1#",
        "book_id": "http://schema.org/identifier",
        "note":"mods:note",
        "dc": "http://purl.org/dc/elements/1.1/",
        "crossasia":"http://crossasia.org/schema/v1#"
    },
    "@id": "urn:x-arq:DefaultGraphNode",

    "@graph": b,
    "@graph": _.map(books, function(p) {
      return {
          "Erudition LocGaz":"type=\"Erudition LocGaz\" "+p.identifierErudition_LocGaz,
          "dc:title": p.title,
          "dcndl:titleTranscription":[[p.titleTranscription]+"",""+[p.titleTranscription1]],
          "dcndl:seriesTitle":p.seriesTitle,
          "dc:creator": [[p.creator]+"",""+[p.creator1]+"",""+ [p.creator2]],
          "dcndl:creatorTranscription":[[ p.creatorTranscription]+"",""+[p.creatorTranscription1]+"",""+[p.creatorTranscription2]+"",""+[p.creatorTranscription3]+"",""+[p.creatorTranscription4]],
          "mods:physicalDescription":[[p.physicalDescription]+"",""+[p.physicalDescription1]],
          "dcterms:issued":p.issued,
          "dc:date": p.date,
          "mods:edition":p.edition,
          "dcterms:temporal": p.temporal,
          "@id": "",
          "fedora:hasModel": "Book",
          "@type": "pcdm:Object",
          "dc:spatial": p.spatial,
          "TGAZ API":"type=\"TGAZ API\" "+p.identifierTGAZ_API,
          "CHGIS":"type=\"CHGIS\" "+p.identifierCHGIS,
          "schema:latitude": p.latitude,
          "schema:longitude": p.longitude,
          "dc:language": p.language,
          "schema:comment": p.comment,
          "CrossAsia Lizenz": "type=\"CrossAsia Lizenz\" "+p.identifierCrossAsia_Lizenz,
          "note":"type=\"statement of responsibility\" "+p.note,
          "dcterms:extent":p.extent,
          "mods:genre":p.genre,
          "dc:identifier":p.identifierErudition_LocGaz,
          "book_id":p.identifierErudition_LocGaz+"book",
          "crossasia:admin_level_1":p.admin_level_1,
          "crossasia:admin_level_2":p.admin_level_2,
          "crossasia:admin_type":p.admin_type
      }
    })
})
