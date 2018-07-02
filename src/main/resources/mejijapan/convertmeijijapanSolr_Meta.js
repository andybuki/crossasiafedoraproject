var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b, function(p) {
    return p;
});

/*var pages = _.filter(b.dataExport.document.images.image, function(page) {
    return page;
});*/

request.body = JSON.stringify({
    //"products": b.dataExport,
    "products": _.map(books, function(p) {
        //var bookId = page.book_id.toString();
        return {
            "id": p.id,
            "hasModel": p.hasModel,
            "nodeId": p.nodeId,
            "book_id": p.book_id,
            "identifier": p.identifier,
            "title": p.title,
            "date": p.date,
            "edition": p.edition,
            //"description": p.description,//.split(";"),
            "medium": p.medium,
            "keywords": p.keywords,
            "collection":p.collection,
            "spatial" : p.spatial,
            "person" : p.person,
            "language": p.language

            /*"images": _.map(pages, function(page) {
                    return {
                        "id":page.id+"page_"+ page.imageUrl.replace("http://www.aap.amdigital.co.uk/Contents/image-viewer.aspx?imageid=", "").split('/')[0],
                        "position": page.id,
                        "hasModel": "Page",
                        "collection":"Meiji Japan",
                        //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " "),
                        "text": page.imageText.replace(/(\r\n|\n|\r)/gm, " ").replace('\"', "").replace("\\","").replace("�",""),
                        //"text": page.imageText,
                        "image_file": page.imageFile,
                        "image_url": "http://erf.sbb.spk-berlin.de/han/AmericaAsiaandthePacific/"+page.imageUrl,
                        "book_id": p.nodeId

                    }

            })*/
        }
    })
})
