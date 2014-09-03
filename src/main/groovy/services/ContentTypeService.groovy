package services

import com.google.inject.Inject
import domain.ContentType
import repositories.ContentTypeRepository

class ContentTypeService {

    @Inject
    ContentTypeRepository repository

    List<ContentType> all() {
        repository.findAll()
    }
}
