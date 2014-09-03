package domain

class Content {

    String id
    String type
    PublishedState publishedState = PublishedState.UNPUBLISHED
    Map<String, Object> fields
}
