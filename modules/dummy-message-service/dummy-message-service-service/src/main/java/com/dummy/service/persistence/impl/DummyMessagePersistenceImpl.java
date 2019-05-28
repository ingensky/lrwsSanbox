/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dummy.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.dummy.exception.NoSuchDummyMessageException;

import com.dummy.model.DummyMessage;
import com.dummy.model.impl.DummyMessageImpl;
import com.dummy.model.impl.DummyMessageModelImpl;

import com.dummy.service.persistence.DummyMessagePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the dummy message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyMessagePersistence
 * @see com.dummy.service.persistence.DummyMessageUtil
 * @generated
 */
@ProviderType
public class DummyMessagePersistenceImpl extends BasePersistenceImpl<DummyMessage>
	implements DummyMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DummyMessageUtil} to access the dummy message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DummyMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DummyMessagePersistenceImpl() {
		setModelClass(DummyMessage.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");
			dbColumnNames.put("text", "text_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the dummy message in the entity cache if it is enabled.
	 *
	 * @param dummyMessage the dummy message
	 */
	@Override
	public void cacheResult(DummyMessage dummyMessage) {
		entityCache.putResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
			DummyMessageImpl.class, dummyMessage.getPrimaryKey(), dummyMessage);

		dummyMessage.resetOriginalValues();
	}

	/**
	 * Caches the dummy messages in the entity cache if it is enabled.
	 *
	 * @param dummyMessages the dummy messages
	 */
	@Override
	public void cacheResult(List<DummyMessage> dummyMessages) {
		for (DummyMessage dummyMessage : dummyMessages) {
			if (entityCache.getResult(
						DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
						DummyMessageImpl.class, dummyMessage.getPrimaryKey()) == null) {
				cacheResult(dummyMessage);
			}
			else {
				dummyMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dummy messages.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DummyMessageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dummy message.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DummyMessage dummyMessage) {
		entityCache.removeResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
			DummyMessageImpl.class, dummyMessage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DummyMessage> dummyMessages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DummyMessage dummyMessage : dummyMessages) {
			entityCache.removeResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
				DummyMessageImpl.class, dummyMessage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dummy message with the primary key. Does not add the dummy message to the database.
	 *
	 * @param id the primary key for the new dummy message
	 * @return the new dummy message
	 */
	@Override
	public DummyMessage create(long id) {
		DummyMessage dummyMessage = new DummyMessageImpl();

		dummyMessage.setNew(true);
		dummyMessage.setPrimaryKey(id);

		return dummyMessage;
	}

	/**
	 * Removes the dummy message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dummy message
	 * @return the dummy message that was removed
	 * @throws NoSuchDummyMessageException if a dummy message with the primary key could not be found
	 */
	@Override
	public DummyMessage remove(long id) throws NoSuchDummyMessageException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dummy message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dummy message
	 * @return the dummy message that was removed
	 * @throws NoSuchDummyMessageException if a dummy message with the primary key could not be found
	 */
	@Override
	public DummyMessage remove(Serializable primaryKey)
		throws NoSuchDummyMessageException {
		Session session = null;

		try {
			session = openSession();

			DummyMessage dummyMessage = (DummyMessage)session.get(DummyMessageImpl.class,
					primaryKey);

			if (dummyMessage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDummyMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dummyMessage);
		}
		catch (NoSuchDummyMessageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DummyMessage removeImpl(DummyMessage dummyMessage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dummyMessage)) {
				dummyMessage = (DummyMessage)session.get(DummyMessageImpl.class,
						dummyMessage.getPrimaryKeyObj());
			}

			if (dummyMessage != null) {
				session.delete(dummyMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dummyMessage != null) {
			clearCache(dummyMessage);
		}

		return dummyMessage;
	}

	@Override
	public DummyMessage updateImpl(DummyMessage dummyMessage) {
		boolean isNew = dummyMessage.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dummyMessage.isNew()) {
				session.save(dummyMessage);

				dummyMessage.setNew(false);
			}
			else {
				dummyMessage = (DummyMessage)session.merge(dummyMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(_finderPathWithoutPaginationFindAll,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
			DummyMessageImpl.class, dummyMessage.getPrimaryKey(), dummyMessage,
			false);

		dummyMessage.resetOriginalValues();

		return dummyMessage;
	}

	/**
	 * Returns the dummy message with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dummy message
	 * @return the dummy message
	 * @throws NoSuchDummyMessageException if a dummy message with the primary key could not be found
	 */
	@Override
	public DummyMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDummyMessageException {
		DummyMessage dummyMessage = fetchByPrimaryKey(primaryKey);

		if (dummyMessage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDummyMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dummyMessage;
	}

	/**
	 * Returns the dummy message with the primary key or throws a {@link NoSuchDummyMessageException} if it could not be found.
	 *
	 * @param id the primary key of the dummy message
	 * @return the dummy message
	 * @throws NoSuchDummyMessageException if a dummy message with the primary key could not be found
	 */
	@Override
	public DummyMessage findByPrimaryKey(long id)
		throws NoSuchDummyMessageException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dummy message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dummy message
	 * @return the dummy message, or <code>null</code> if a dummy message with the primary key could not be found
	 */
	@Override
	public DummyMessage fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
				DummyMessageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DummyMessage dummyMessage = (DummyMessage)serializable;

		if (dummyMessage == null) {
			Session session = null;

			try {
				session = openSession();

				dummyMessage = (DummyMessage)session.get(DummyMessageImpl.class,
						primaryKey);

				if (dummyMessage != null) {
					cacheResult(dummyMessage);
				}
				else {
					entityCache.putResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
						DummyMessageImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
					DummyMessageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dummyMessage;
	}

	/**
	 * Returns the dummy message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dummy message
	 * @return the dummy message, or <code>null</code> if a dummy message with the primary key could not be found
	 */
	@Override
	public DummyMessage fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, DummyMessage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DummyMessage> map = new HashMap<Serializable, DummyMessage>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DummyMessage dummyMessage = fetchByPrimaryKey(primaryKey);

			if (dummyMessage != null) {
				map.put(primaryKey, dummyMessage);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
					DummyMessageImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DummyMessage)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DUMMYMESSAGE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DummyMessage dummyMessage : (List<DummyMessage>)q.list()) {
				map.put(dummyMessage.getPrimaryKeyObj(), dummyMessage);

				cacheResult(dummyMessage);

				uncachedPrimaryKeys.remove(dummyMessage.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
					DummyMessageImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the dummy messages.
	 *
	 * @return the dummy messages
	 */
	@Override
	public List<DummyMessage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dummy messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummy messages
	 * @param end the upper bound of the range of dummy messages (not inclusive)
	 * @return the range of dummy messages
	 */
	@Override
	public List<DummyMessage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dummy messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummy messages
	 * @param end the upper bound of the range of dummy messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dummy messages
	 */
	@Override
	public List<DummyMessage> findAll(int start, int end,
		OrderByComparator<DummyMessage> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dummy messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummy messages
	 * @param end the upper bound of the range of dummy messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of dummy messages
	 */
	@Override
	public List<DummyMessage> findAll(int start, int end,
		OrderByComparator<DummyMessage> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DummyMessage> list = null;

		if (retrieveFromCache) {
			list = (List<DummyMessage>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DUMMYMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DUMMYMESSAGE;

				if (pagination) {
					sql = sql.concat(DummyMessageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DummyMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DummyMessage>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dummy messages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DummyMessage dummyMessage : findAll()) {
			remove(dummyMessage);
		}
	}

	/**
	 * Returns the number of dummy messages.
	 *
	 * @return the number of dummy messages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(_finderPathCountAll,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DUMMYMESSAGE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(_finderPathCountAll, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DummyMessageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dummy message persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
				DummyMessageModelImpl.FINDER_CACHE_ENABLED,
				DummyMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
				DummyMessageModelImpl.FINDER_CACHE_ENABLED,
				DummyMessageImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
				new String[0]);

		_finderPathCountAll = new FinderPath(DummyMessageModelImpl.ENTITY_CACHE_ENABLED,
				DummyMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
				new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(DummyMessageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DUMMYMESSAGE = "SELECT dummyMessage FROM DummyMessage dummyMessage";
	private static final String _SQL_SELECT_DUMMYMESSAGE_WHERE_PKS_IN = "SELECT dummyMessage FROM DummyMessage dummyMessage WHERE id_ IN (";
	private static final String _SQL_COUNT_DUMMYMESSAGE = "SELECT COUNT(dummyMessage) FROM DummyMessage dummyMessage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dummyMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DummyMessage exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(DummyMessagePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "text"
			});
}