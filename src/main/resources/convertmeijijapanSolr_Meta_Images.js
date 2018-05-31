var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var books = _.filter(b.dataExport, function(p) {
    return p;
});

var pages = _.filter(b.dataExport.document.images, function(page) {
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
            "identifier": "http://erf.sbb.spk-berlin.de/han/AmericaAsiaandthePacific/"+p.Url,
            "title": [[p.Title]+ "", "" +[p.Description] + " Box:"+ [p.BoxNumber] + ", Folder: "+ [p.FolderNumber]],
            "author": p.Author,
            "date": p.Date,
            "publication_place": p.PlaceofPublication,
            "publication_name": [[p.Publisher] + "", "" + [p.PrintedBy]],
            "edition": [[p.Reference] + "", "" + [p.Library] + "", "" +[p.Source]],
            "description": [[p.Description] + "", "" + [p.Notes]],
            "medium": [["text"]+ "", "" +["Records (Documents)"]+ "", "" +[p.DocumentType] + "", "" + [p.PhysicalCharacteristics]+ "", "" +[p.Category]],
            "subject": [[p.Themes] + "", "" + [p.Countries] + "", "" + [p.Region]],
            "organization" :  p.Organisations,
            "keywords": p.Topics,
            "collection":"Meiji Japan",
            "source": p.Copyright,
            "spatial" : p.Places,
            "person" : [[p.People]+ "", "" + [p.Names]],
            "series_title": [[p.TopLevelCollection] + "", "" + [p.Collection]],
            "publisher": p.Office,
            "language": "jpn",
            "publication_volume": p.VolumeNumber,
            "volume_number": p.IssueNumber,
            */
            "images": _.map(pages, function(page) {
                    return {
                        "id":page.id+"page_"+ page.imageUrl.replace("http://www.aap.amdigital.co.uk/Contents/image-viewer.aspx?imageid=", "").split('/')[0],
                        "position": page.id,
                        "hasModel": "Page",
                        "collection":"Meiji Japan",
                        //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " "),
                        //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " ").replace('\"', "").replace("\\","").replace("�",""),
                        "text": page.imageText,
                        "image_file": page.imageFile,
                        "image_url": "http://erf.sbb.spk-berlin.de/han/AmericaAsiaandthePacific/"+page.imageUrl,
                        "book_id": p.nodeId,
                        "language": "jpn",

                    }

            })
        }
    })
})
