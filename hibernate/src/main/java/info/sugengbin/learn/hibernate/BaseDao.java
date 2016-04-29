package info.sugengbin.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao implements BeanFactoryAware {

	protected BeanFactory beanFactory;

    @Autowired(required = false)
    protected SessionFactory sessionFactory;

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * currentSession
	 * @return
	 */
	protected Session currentSession() {
        return getSessionFactory().getCurrentSession();
    }
}
