package hu.unideb.prog2.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hu.unideb.prog2.DiContext;

public class DiContextImpl implements DiContext {

	private Map<String, Object> context = new HashMap<>();
	private Map<Class<?>, List<Object>> contextMappedByType = new HashMap<>();

	public void addBean(String beanName, Object bean) {
		if (context.containsKey(beanName)) {
			throw new IllegalArgumentException("Bean has been already created: " + beanName);
		}
		context.put(beanName, bean);
		if (contextMappedByType.containsKey(bean.getClass())) {
			contextMappedByType.get(bean.getClass()).add(bean);
		} else {
			List<Object> objectList = new LinkedList<>();
			objectList.add(bean);
			contextMappedByType.put(bean.getClass(), objectList);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> Optional<T> getBean(String beanName, Class<T> clazz) {
		return (Optional<T>) context.entrySet().stream()
				.filter(e -> e.getKey().equals(beanName)).map(Map.Entry::getValue).findFirst();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Optional<T> getBean(Class<T> clazz) {
		Optional<T> ret = null;
		List<Object> objectList = contextMappedByType.get(clazz);
		if (objectList == null) {
			ret = Optional.empty();
		} else if (objectList.size() != 1) {
			throw new IllegalArgumentException("There are multiple bean available for type: " + clazz);
		} else {
			ret = Optional.of((T) objectList.get(0));
		}
		return ret;
	}

}
