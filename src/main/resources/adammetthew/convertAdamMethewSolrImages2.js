var _ = require('underscore');
var moment = require('moment');

var b = JSON.parse(request.getBody(Java.type("java.lang.String").class))

var pages = _.filter(b.products, function(page) {
    return page;
});

request.body = JSON.stringify({
    "products": b.products,
    "products": _.map(pages, function(page) {
        if (page.image_text!=null) {
            return {
                "id": page.id+"page_"+page.book_id.replaceAll("%20", '_'),
                "position": page.position,
                "hasModel": "Page",
                "text": page.image_text,
                "image_file": page.image_file,
                "image_url": page.image_url,
                "book_id": page.book_id.replaceAll("%20", '_')
            }
        }else {
            return {
                "id": page.id+"page_"+page.book_id.replaceAll("%20", '_'),
                "position": page.position,
                "hasModel": "Page",
                "image_file": page.image_file,
                "image_url": page.image_url,
                "book_id": page.book_id.replaceAll("%20", '_')
            }
        }

    }),
})
