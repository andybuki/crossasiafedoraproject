var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var pages = _.filter(b.dataExport.document.images.image, function(page) {
    return page;
});

request.body = JSON.stringify({
    "images": b.dataExport.document.images.image,
    "images": _.map(pages, function(page) {

        return {
            "id": page.id,
            "image_text":page.imageText,
            "image_file":page.imageFile,
            "image_url":page.imageUrl

        }

    }),
})
