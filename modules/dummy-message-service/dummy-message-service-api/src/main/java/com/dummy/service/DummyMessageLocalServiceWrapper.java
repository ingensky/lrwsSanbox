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

package com.dummy.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DummyMessageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DummyMessageLocalService
 * @generated
 */
@ProviderType
public class DummyMessageLocalServiceWrapper implements DummyMessageLocalService,
	ServiceWrapper<DummyMessageLocalService> {
	public DummyMessageLocalServiceWrapper(
		DummyMessageLocalService dummyMessageLocalService) {
		_dummyMessageLocalService = dummyMessageLocalService;
	}

	/**
	* Adds the dummy message to the database. Also notifies the appropriate model listeners.
	*
	* @param dummyMessage the dummy message
	* @return the dummy message that was added
	*/
	@Override
	public com.dummy.model.DummyMessage addDummyMessage(
		com.dummy.model.DummyMessage dummyMessage) {
		return _dummyMessageLocalService.addDummyMessage(dummyMessage);
	}

	/**
	* Creates a new dummy message with the primary key. Does not add the dummy message to the database.
	*
	* @param id the primary key for the new dummy message
	* @return the new dummy message
	*/
	@Override
	public com.dummy.model.DummyMessage createDummyMessage(long id) {
		return _dummyMessageLocalService.createDummyMessage(id);
	}

	/**
	* Deletes the dummy message from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyMessage the dummy message
	* @return the dummy message that was removed
	*/
	@Override
	public com.dummy.model.DummyMessage deleteDummyMessage(
		com.dummy.model.DummyMessage dummyMessage) {
		return _dummyMessageLocalService.deleteDummyMessage(dummyMessage);
	}

	/**
	* Deletes the dummy message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message that was removed
	* @throws PortalException if a dummy message with the primary key could not be found
	*/
	@Override
	public com.dummy.model.DummyMessage deleteDummyMessage(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyMessageLocalService.deleteDummyMessage(id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyMessageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dummyMessageLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _dummyMessageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dummy.model.impl.DummyMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _dummyMessageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dummy.model.impl.DummyMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _dummyMessageLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _dummyMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _dummyMessageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.dummy.model.DummyMessage fetchDummyMessage(long id) {
		return _dummyMessageLocalService.fetchDummyMessage(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dummyMessageLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the dummy message with the primary key.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message
	* @throws PortalException if a dummy message with the primary key could not be found
	*/
	@Override
	public com.dummy.model.DummyMessage getDummyMessage(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyMessageLocalService.getDummyMessage(id);
	}

	/**
	* Returns a range of all the dummy messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dummy.model.impl.DummyMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dummy messages
	* @param end the upper bound of the range of dummy messages (not inclusive)
	* @return the range of dummy messages
	*/
	@Override
	public java.util.List<com.dummy.model.DummyMessage> getDummyMessages(
		int start, int end) {
		return _dummyMessageLocalService.getDummyMessages(start, end);
	}

	/**
	* Returns the number of dummy messages.
	*
	* @return the number of dummy messages
	*/
	@Override
	public int getDummyMessagesCount() {
		return _dummyMessageLocalService.getDummyMessagesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dummyMessageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _dummyMessageLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyMessageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the dummy message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dummyMessage the dummy message
	* @return the dummy message that was updated
	*/
	@Override
	public com.dummy.model.DummyMessage updateDummyMessage(
		com.dummy.model.DummyMessage dummyMessage) {
		return _dummyMessageLocalService.updateDummyMessage(dummyMessage);
	}

	@Override
	public DummyMessageLocalService getWrappedService() {
		return _dummyMessageLocalService;
	}

	@Override
	public void setWrappedService(
		DummyMessageLocalService dummyMessageLocalService) {
		_dummyMessageLocalService = dummyMessageLocalService;
	}

	private DummyMessageLocalService _dummyMessageLocalService;
}