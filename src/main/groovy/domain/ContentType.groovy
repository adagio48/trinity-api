package domain

import groovy.transform.Canonical
import org.springframework.data.annotation.Id

@Canonical
class ContentType {

    @Id
    String id
    String name
    String uri
    boolean publishable
    List<Field> fields
}
