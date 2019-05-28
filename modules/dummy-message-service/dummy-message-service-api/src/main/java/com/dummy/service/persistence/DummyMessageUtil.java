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

package com.dummy.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.dummy.model.DummyMessage;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dummy message service. This utility wraps {@link com.dummy.service.persistence.impl.DummyMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyMessagePersistence
 * @see com.dummy.service.persistence.impl.DummyMessagePersistenceImpl
 * @generated
 */
@ProviderType
public class DummyMessageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DummyMessage dummyMessage) {
		getPersistence().clearCache(dummyMessage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DummyMessage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DummyMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DummyMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DummyMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DummyMessage> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DummyMessage update(DummyMessage dummyMessage) {
		return getPersistence().update(dummyMessage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DummyMessage update(DummyMessage dummyMessage,
		ServiceContext serviceContext) {
		return getPersistence().update(dummyMessage, serviceContext);
	}

	/**
	* Caches the dummy message in the entity cache if it is enabled.
	*
	* @param dummyMessage the dummy message
	*/
	public static void cacheResult(DummyMessage dummyMessage) {
		getPersistence().cacheResult(dummyMessage);
	}

	/**
	* Caches the dummy messages in the entity cache if it is enabled.
	*
	* @param dummyMessages the dummy messages
	*/
	public static void cacheResult(List<DummyMessage> dummyMessages) {
		getPersistence().cacheResult(dummyMessages);
	}

	/**
	* Creates a new dummy message with the primary key. Does not add the dummy message to the database.
	*
	* @param id the primary key for the new dummy message
	* @return the new dummy message
	*/
	public static DummyMessage create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the dummy message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message that was removed
	* @throws NoSuchDummyMessageException if a dummy message with the primary key could not be found
	*/
	public static DummyMessage remove(long id)
		throws com.dummy.exception.NoSuchDummyMessageException {
		return getPersistence().remove(id);
	}

	public static DummyMessage updateImpl(DummyMessage dummyMessage) {
		return getPersistence().updateImpl(dummyMessage);
	}

	/**
	* Returns the dummy message with the primary key or throws a {@link NoSuchDummyMessageException} if it could not be found.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message
	* @throws NoSuchDummyMessageException if a dummy message with the primary key could not be found
	*/
	public static DummyMessage findByPrimaryKey(long id)
		throws com.dummy.exception.NoSuchDummyMessageException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the dummy message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message, or <code>null</code> if a dummy message with the primary key could not be found
	*/
	public static DummyMessage fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the dummy messages.
	*
	* @return the dummy messages
	*/
	public static List<DummyMessage> findAll() {
		return getPersistence().findAll();
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
	public static List<DummyMessage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<DummyMessage> findAll(int start, int end,
		OrderByComparator<DummyMessage> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<DummyMessage> findAll(int start, int end,
		OrderByComparator<DummyMessage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dummy messages from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dummy messages.
	*
	* @return the number of dummy messages
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DummyMessagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DummyMessagePersistence, DummyMessagePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DummyMessagePersistence.class);

		ServiceTracker<DummyMessagePersistence, DummyMessagePersistence> serviceTracker =
			new ServiceTracker<DummyMessagePersistence, DummyMessagePersistence>(bundle.getBundleContext(),
				DummyMessagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}