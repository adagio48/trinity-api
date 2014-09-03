import handlers.ContentTypeHandler
import modules.MongoModule
import handlers.ContentHandler
import services.ContentTypeService
import services.ContentTypeServiceImpl

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        add new MongoModule()

        bind ContentHandler
        bind ContentTypeHandler
        bind ContentTypeServiceImpl
    }
    handlers { ContentTypeService contentTypeService ->
        get {
            render groovyTemplate("index.html", title: "My Ratpack App")
        }

//        handler("content", contentHandler)
//        handler("contentType", contentTypeHandler)
        handler("contentType/:id") {
            def id = pathTokens["id"]
            def contentType = contentTypeService.findById(id)
            if (contentType) {
                context.response.send("application/json", contentType.toString())
            } else {
                context.response.send("application/json", "No contentType found with id: $id")
            }
        }

        assets "public"
    }

}