var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b, function(p) {
    return p;
});

var pages = _.filter(b.images, function(page) {
    return page;
});

request.body = JSON.stringify({
    //"products": b.dataExport,
    "products": _.map(books, function(p) {
        //var bookId = page.book_id.toString();
        return {
            /*"id": p.nodeId + "book",
            "hasModel": "Book",
            "nodeId": p.nodeId,
            "book_id": p.ImageDirectory,
            "identifier": p.Url,
            "title": p.Title,
            "author": p.AuthorCreator,
            "date": p.Date,
            "publication_place": p.PlaceofPublication,
            "publication_name": [[p.Publisher] + "", "" + [p.PrintedBy]],
            "edition": [[p.Reference] + "", "" + [p.Library]],
            "description": ["\Company:"+p.Company +""+  "", "" + "\Ships:"+ p.Ships +""+ "", "" + "\Ports:"+ p.Ports+""+ "", "" +p.Description+ "", "" +p.AdditionalInformation],
            "medium": [["text"]+ "", "" +["Records (Documents)"]+ "", "" +[p.DocumentType]],
            "subject": p.Countries.split(";"),
            "subject1":p.Theme,
            "organization" :  p.Organisations,
            "keywords": p.Keywords.split(","),
            "collection":"Adam Matthew - China America Pacific",
            "source": p.Copyright,
            "spatial" : p.Places.split(";"),
            "person" : p.People.split(";"),
            "series_title":  [p.Collection],
            "publisher": p.Office,
            "language": p.Language.split(","),
            //"publication_volume": p.VolumeNumber,
            "issued": p.SearchableDate,*/
            //"volume_number": p.IssueNumber
            //,

            "images": _.map(pages, function(page) {
                   if (page.text!="") {
                       return {
                           //"id":page.id+"page_"+ page.imageUrl,
                           "id":page.id,
                           "position": page.position,
                           "hasModel": page.hasModel,
                           "collection":page.collection,
                           //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " "),
                           //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " ").replace('\"', "").replace("\\","").replace("�",""),
                           //"text": page.imageText.replace("_"," "),
                           "text": page.text.replace("_"," "),
                           "image_file": page.image_file,
                           "image_url": page.image_url,
                           "book_id": page.book_id/*,
                        "language": "jpn",*/

                       }
                   }
                   else {
                       return {
                           //"id":page.id+"page_"+ page.imageUrl,
                           "id":page.id,
                           "position": page.position,
                           "hasModel": page.hasModel,
                           "collection":page.collection,
                           //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " "),
                           //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " ").replace('\"', "").replace("\\","").replace("�",""),
                           //"text": page.imageText.replace("_"," "),
                           "text": page.text,
                           "image_file": page.image_file,
                           "image_url": page.image_url,
                           "book_id": page.book_id/*,
                        "language": "jpn",*/

                       }
                   }


            })
        }
    })
})
