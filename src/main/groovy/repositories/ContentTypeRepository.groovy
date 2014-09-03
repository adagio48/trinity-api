package repositories

import domain.ContentType
import org.springframework.data.mongodb.repository.MongoRepository

interface ContentTypeRepository extends MongoRepository<ContentType, String> {

    List<ContentType> findAll()

}
