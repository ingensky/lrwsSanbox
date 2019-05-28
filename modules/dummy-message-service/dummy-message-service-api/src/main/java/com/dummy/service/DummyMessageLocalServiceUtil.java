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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DummyMessage. This utility wraps
 * {@link com.dummy.service.impl.DummyMessageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DummyMessageLocalService
 * @see com.dummy.service.base.DummyMessageLocalServiceBaseImpl
 * @see com.dummy.service.impl.DummyMessageLocalServiceImpl
 * @generated
 */
@ProviderType
public class DummyMessageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.dummy.service.impl.DummyMessageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dummy message to the database. Also notifies the appropriate model listeners.
	*
	* @param dummyMessage the dummy message
	* @return the dummy message that was added
	*/
	public static com.dummy.model.DummyMessage addDummyMessage(
		com.dummy.model.DummyMessage dummyMessage) {
		return getService().addDummyMessage(dummyMessage);
	}

	/**
	* Creates a new dummy message with the primary key. Does not add the dummy message to the database.
	*
	* @param id the primary key for the new dummy message
	* @return the new dummy message
	*/
	public static com.dummy.model.DummyMessage createDummyMessage(long id) {
		return getService().createDummyMessage(id);
	}

	/**
	* Deletes the dummy message from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyMessage the dummy message
	* @return the dummy message that was removed
	*/
	public static com.dummy.model.DummyMessage deleteDummyMessage(
		com.dummy.model.DummyMessage dummyMessage) {
		return getService().deleteDummyMessage(dummyMessage);
	}

	/**
	* Deletes the dummy message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message that was removed
	* @throws PortalException if a dummy message with the primary key could not be found
	*/
	public static com.dummy.model.DummyMessage deleteDummyMessage(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteDummyMessage(id);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.dummy.model.DummyMessage fetchDummyMessage(long id) {
		return getService().fetchDummyMessage(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the dummy message with the primary key.
	*
	* @param id the primary key of the dummy message
	* @return the dummy message
	* @throws PortalException if a dummy message with the primary key could not be found
	*/
	public static com.dummy.model.DummyMessage getDummyMessage(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDummyMessage(id);
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
	public static java.util.List<com.dummy.model.DummyMessage> getDummyMessages(
		int start, int end) {
		return getService().getDummyMessages(start, end);
	}

	/**
	* Returns the number of dummy messages.
	*
	* @return the number of dummy messages
	*/
	public static int getDummyMessagesCount() {
		return getService().getDummyMessagesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the dummy message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dummyMessage the dummy message
	* @return the dummy message that was updated
	*/
	public static com.dummy.model.DummyMessage updateDummyMessage(
		com.dummy.model.DummyMessage dummyMessage) {
		return getService().updateDummyMessage(dummyMessage);
	}

	public static DummyMessageLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DummyMessageLocalService, DummyMessageLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DummyMessageLocalService.class);

		ServiceTracker<DummyMessageLocalService, DummyMessageLocalService> serviceTracker =
			new ServiceTracker<DummyMessageLocalService, DummyMessageLocalService>(bundle.getBundleContext(),
				DummyMessageLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}