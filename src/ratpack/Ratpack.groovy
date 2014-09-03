import domain.Content
import modules.MongoModule
import ratpack.http.MediaType
import services.ContentService
import services.ContentTypeService

import static groovy.json.JsonOutput.toJson
import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        add new MongoModule()
    }
    handlers { ContentService contentService ->
        get {
            render groovyTemplate("index.html", title: "My Ratpack App")
        }

        get("content/show/:id") {
            def id = pathTokens["id"]
            Content content = contentService.findById(id)
            if (content) {
                context.response.send("application/json", toJson(content))
            } else {
                context.response.send("application/json", toJson("No content found for id : $id"))
            }
        }

        get("content/list/:type") {
            def type = pathTokens["type"]
            List<Content> contents = contentService.findByType(type)
            if (contents) {
                context.response.send("application/json", toJson(contents))
            } else {
                context.response.send("application/json", toJson("No content found for type : $type"))
            }
        }

        get('content/list') {
            response.send MediaType.APPLICATION_JSON, toJson(contentService.all())
        }

        get('contentType/list') { ContentTypeService contentTypeService ->
            response.send MediaType.APPLICATION_JSON, toJson(contentTypeService.all())
        }

        assets "public"
    }
}