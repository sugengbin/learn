package info.sugengbin.learn.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

public class BaseEntityDao<T> extends BaseDao implements IEntityDao<T> {

	// entityClass
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseEntityDao() {
		entityClass = (Class<T>) getInitEntityClass();
	}

	protected Class<?> getInitEntityClass() {
		Class<?> cls = getArgTypesFrom(getClass());
		if (cls == null) {
			cls = getFirstArgTypes(getClass());
		}
		return cls;
	}

	private Class<?> getFirstArgTypes(Class<?> beanClass) {
		Type type = beanClass.getGenericSuperclass();
		if (type != null) {
			if (ParameterizedType.class.isInstance(type)) { // NOPMD
				ParameterizedType pType = (ParameterizedType) type;
				if (pType.getActualTypeArguments().length >= 1) {
					Type argType1 = pType.getActualTypeArguments()[0];
					if ((argType1 instanceof Class)) {
						return (Class<?>) argType1;
					}
				}
				return null;
			}
		}
		return getFirstArgTypes(beanClass.getSuperclass());
	}

	protected Class<?> getArgTypesFrom(Class<?> beanClass) {
		if (BaseEntityDao.class.isAssignableFrom(beanClass)) {
			Type type = beanClass.getGenericSuperclass();
			if (type != null) {
				if (ParameterizedType.class.isInstance(type)) {
					ParameterizedType pType = (ParameterizedType) type;
					if (pType.getRawType().equals(BaseEntityDao.class) && pType.getActualTypeArguments().length >= 1) {
						Type argType1 = pType.getActualTypeArguments()[0];
						if ((argType1 instanceof Class)) {
							return (Class<?>) argType1;
						}
						return null;
					}
				}
			}
			return getArgTypesFrom(beanClass.getSuperclass());
		}
		return null;
	}

	// basic methods
	@SuppressWarnings("unchecked")
	public T load(String id) {
		if (id == null) {
			return null;
		}
		return (T) super.currentSession().get(entityClass, id);
	}

	public int countBy(DetachedCriteria criteria) {
		Criteria criteriaExe = criteria.getExecutableCriteria(currentSession());
		Number countTmp = (Number) criteriaExe.setProjection(Projections.rowCount()).uniqueResult();
		if (null == countTmp) {
			throw new HibernateException(
					"The entity class of current criteria does not mapping or has mapping mistake.");
		}
		return countTmp.intValue();

	}

	public void save(T entity) {
		super.currentSession().save(entity);
	}

	public void saveBatch(List<T> entityList) {
		for (T e : entityList) {
			this.save(e);
		}
	}

	public void update(T entity) {
		super.currentSession().update(entity);
	}

	public void updateBatch(List<T> entityList) {
        for (T o : entityList) {
            this.update(o);
        }
    }

	public void saveOrUpdate(T entity) {
        super.currentSession().saveOrUpdate(entity);
        }

	public void saveOrUpdateBatch(List<T> entityList) {
        for (T o : entityList) {
            this.saveOrUpdate(o);
        }
    }

	public void remove(T entity) {
        super.currentSession().delete(entity);
        }

	public void removeBatch(Collection<T> entityList) {
        for (T e : entityList) {
            this.remove(e);
        }
    }

	public List<T> findBy(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findAny(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findByBean(T bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
        super.currentSession().flush();
        }

	public List<T> find(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findAny(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
