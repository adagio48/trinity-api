package services

import com.google.inject.Inject
import domain.Content
import repositories.ContentRepository

public class ContentService {

    @Inject
    ContentRepository repository

    Content findById(String id) {
        repository.findById(id)
    }

    List<Content> findByType(String type) {
        repository.findByType(type)
    }

    List<Content> all() {
        repository.findAll()
    }

}