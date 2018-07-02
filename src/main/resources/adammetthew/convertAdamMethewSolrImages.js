var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var pages = _.filter(b.dataExport.document.images.image, function(page) {
    return page;
});

request.body = JSON.stringify({
    "images": b.dataExport.document.images.image,
    "images": _.map(pages, function(page) {
        if (page.imageText!=null) {
            return {
                "id": page.id,
                "position": page.id,
                "hasModel": "Page",
                //"text": page.imageText.replace(/(\r\n|\n|\r)/gm, " "),
                "text": page.imageText,
                "image_file": page.imageFile,
                "image_url": page.imageUrl,
                "book_id": page.imageUrl.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Images/", "").split('/')[0]

            }
        }else {
            return {
                "id": page.id,
                "position": page.id,
                "hasModel": "Page",
                "image_file": page.imageFile,
                "image_url": page.imageUrl,
                "book_id": page.imageUrl.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Images/", "").split('/')[0]

            }
        }
    }),
})
