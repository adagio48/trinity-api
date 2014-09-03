package modules

import com.google.inject.AbstractModule
import com.google.inject.spring.SpringIntegration
import org.springframework.beans.factory.BeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import repositories.ContentRepository
import repositories.ContentTypeRepository
import services.ContentService
import services.ContentTypeService

class MongoModule extends AbstractModule {

    @Override
    protected void configure() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mongoConfig.xml")
        bind(BeanFactory).toInstance(context)

        bind(ContentTypeRepository).toProvider(SpringIntegration.fromSpring(ContentTypeRepository, 'contentTypeRepository'))
        bind(ContentTypeService)

        bind(ContentRepository).toProvider(SpringIntegration.fromSpring(ContentRepository, 'contentRepository'))
        bind(ContentService)
    }
}
