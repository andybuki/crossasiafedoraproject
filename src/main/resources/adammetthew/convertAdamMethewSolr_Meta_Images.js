var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.dataExport, function(p) {
    return p;
});

var pages = _.filter(b.dataExport.document.images.image, function(page) {
    return page;
});

request.body = JSON.stringify({
    "products": b.dataExport,

    "products": _.map(books, function(p) {
        //var bookId = page.book_id.toString();
        return {
            /*"id": p.nodeId + "book",
            "hasModel": "Book",
            "nodeId": p.nodeId,
            "book_id": p.ImageDirectory,
            "identifier": p.Url,
            "title": p.Title,
            "author": p.Author,
            "date": p.Date,
            "publication_place": p.PlaceofPublication,
            "publication_name": [[p.Publisher] + "", "" + [p.PrintedBy]],
            "edition": [[p.Reference] + "", "" + [p.Library]],
            "description": [[p.Description] + "", "" + [p.Notes]],
            "medium": [["text"]+ "", "" +["Records (Documents)"]+ "", "" +[p.DocumentType] + "", "" + [p.PhysicalCharacteristics]],
            "subject": [[p.Themes] + "", "" + [p.Countries] + "", "" + [p.Region]],
            "organization" :  p.Organisations,
            "keywords": p.Topics,
            "source": p.Copyright,
            "spatial" : p.Places,
            "person" : p.People,
            "series_title": [[p.TopLevelCollection] + "", "" + [p.Collection]],
            "publisher": p.Office,
            "language": p.Language,
            "publication_volume": p.VolumeNumber,
            "volume_number": p.IssueNumber,*/
            "images": b.dataExport.document.images.image,
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
            }),
        }
    })
})
