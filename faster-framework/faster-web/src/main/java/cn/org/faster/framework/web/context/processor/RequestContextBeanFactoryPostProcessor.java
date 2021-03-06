package cn.org.faster.framework.web.context.processor;

import cn.org.faster.framework.web.context.model.RequestContext;
import cn.org.faster.framework.web.context.model.WebContextFacade;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.io.Serializable;

/**
 * @author zhangbowen
 * @since 2018/8/27
 */
public class RequestContextBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerResolvableDependency(RequestContext.class, new RequestContextObjectFactory());
    }

    public static class RequestContextObjectFactory implements ObjectFactory<RequestContext>, Serializable {

        @Override
        public RequestContext getObject() {
            return WebContextFacade.getRequestContext();
        }
        @Override
        public String toString() {
            return WebContextFacade.getRequestContext().toString();
        }
    }

}
