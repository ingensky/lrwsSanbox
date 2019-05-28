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

import com.dummy.exception.NoSuchDummyMessageException;

import com.dummy.model.DummyMessage;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the dummy message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dummy.service.persistence.impl.DummyMessagePersistenceImpl
 * @see DummyMessageUtil
 * @generated
 */
@ProviderType
public interface DummyMessagePersistence extends BasePersistence<DummyMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DummyMessageUtil} to access the dummy message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, DummyMessage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	* Caches the dummy message in the entity cache if it is enabled.
	*
	* @param dummyMessage the dummy message
	*/
	public void cacheResult(DummyMessage dummyMessage);

	/**
	* Caches the dummy messages in the entity cache if it is enabled.
	*
	* @param dummyMessages the dummy messages
	*/
	public void cacheResult(java.util.List<DummyMessage> dummyMessages);

	/**
	* Creates a new dummy message with the primary key. Does not add the dummy message to the database.
	*
	* @param id the primary key for the new dummy message
	* @return the new dummy message
	*/
	public DummyMessage create(long id);

	/**
	* Removes the dummy message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message that was removed
	* @throws NoSuchDummyMessageException if a dummy message with the primary key could not be found
	*/
	public DummyMessage remove(long id) throws NoSuchDummyMessageException;

	public DummyMessage updateImpl(DummyMessage dummyMessage);

	/**
	* Returns the dummy message with the primary key or throws a {@link NoSuchDummyMessageException} if it could not be found.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message
	* @throws NoSuchDummyMessageException if a dummy message with the primary key could not be found
	*/
	public DummyMessage findByPrimaryKey(long id)
		throws NoSuchDummyMessageException;

	/**
	* Returns the dummy message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message, or <code>null</code> if a dummy message with the primary key could not be found
	*/
	public DummyMessage fetchByPrimaryKey(long id);

	/**
	* Returns all the dummy messages.
	*
	* @return the dummy messages
	*/
	public java.util.List<DummyMessage> findAll();

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
	public java.util.List<DummyMessage> findAll(int start, int end);

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
	public java.util.List<DummyMessage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DummyMessage> orderByComparator);

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
	public java.util.List<DummyMessage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DummyMessage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the dummy messages from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of dummy messages.
	*
	* @return the number of dummy messages
	*/
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();
}