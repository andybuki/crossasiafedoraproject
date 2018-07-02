var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.products, function(p) {
    return p;
});

/*var pages = _.filter(b.products.images, function(page) {
    return page;
});*/

request.body = JSON.stringify({
    "products": b.products,

    "products": _.map(books, function(p) {
        //var bookId = page.book_id.toString();
        return {
            "id": p.id,
            "hasModel": "Book",
            "nodeId": p.nodeId,
            "book_id": p.book_id,
            "identifier": p.identifier,
            "title": p.title,
            "author": p.author,
            "date": p.date,
            "publication_place": p.publication_place,
            "publication_name": p.publication_name,
            "edition": p.edition,
            "description": p.description,
            "medium": [["text"]+ "", "" +["Records (Documents)"]],
            "subject": p.subject,
            "organization" :  p.organization,
            "keywords": p.keywords.split(";"),
            "source": p.source,
            "spatial" : p.spatial.split(";"),
            "person" : p.person.split(";"),
            "series_title": p.series_title,
            "publisher": p.publisher,
            "language": "eng",
            "publication_volume": p.publication_volume,
            "volume_number": p.volume_number,
            /*"images": b.dataExport.images,
            "images": _.map(pages, function(page) {
                if (page.imageText!=null && page.book_id!=null) {
                    return {
                        "id":page.id+"page_"+ page.imageUrl.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Images/", "").split('/')[0],
                        "position": page.id,
                        "hasModel": "Page",
                        "collection":"Adam Matthew FO China",
                        //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " "),
                        "text": page.imageText.replace(/(\r\n|\n|\r)/gm, " ").replace('\"', "").replace("\\","").replace("�",""),
                        //"text": page.imageText,
                        "image_file": page.imageFile,
                        "image_url": page.imageUrl,
                        "book_id": page.imageUrl.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Images/", "").split('/')[0]

                    }
                } else if (page.book_id==null) {
                    return {
                        "id":page.id+"page_"+ page.imageUrl.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Images/", "").split('/')[0],
                        "position": page.id,
                        "hasModel": "Page",
                        "collection": "Adam Matthew FO China",
                        "text": page.imageText,
                        //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " ").replace('\"', "").replace("\\","").replace("�",""),
                        "image_file": page.imageFile,
                        "image_url": page.imageUrl,
                        "book_id": page.imageUrl.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Images/", "").split('/')[0]
                    }
                } else {
                    return {
                        "id": page.id+"page_"+ page.imageUrl.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Images/", "").split('/')[0],
                        "position": page.id,
                        "hasModel": "Page",
                        "image_file": page.imageFile,
                        "collection":"Adam Matthew FO China",
                        "image_url": page.imageUrl,
                        "book_id": page.imageUrl.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Images/", "").split('/')[0]

                    }
                }
            }),*/
        }
    })
})
