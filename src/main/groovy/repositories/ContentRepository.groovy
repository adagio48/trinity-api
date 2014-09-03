package repositories

import domain.Content
import org.springframework.data.mongodb.repository.MongoRepository

interface ContentRepository extends MongoRepository<Content, String> {

    Content findById(String id)
    List<Content> findByType(String type)
    List<Content> findAll()

}

