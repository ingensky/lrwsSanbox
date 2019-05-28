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

package com.dummy.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DummyMessage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyMessage
 * @generated
 */
@ProviderType
public class DummyMessageWrapper implements DummyMessage,
	ModelWrapper<DummyMessage> {
	public DummyMessageWrapper(DummyMessage dummyMessage) {
		_dummyMessage = dummyMessage;
	}

	@Override
	public Class<?> getModelClass() {
		return DummyMessage.class;
	}

	@Override
	public String getModelClassName() {
		return DummyMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("text", getText());
		attributes.put("tag", getTag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}
	}

	@Override
	public Object clone() {
		return new DummyMessageWrapper((DummyMessage)_dummyMessage.clone());
	}

	@Override
	public int compareTo(DummyMessage dummyMessage) {
		return _dummyMessage.compareTo(dummyMessage);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dummyMessage.getExpandoBridge();
	}

	/**
	* Returns the ID of this dummy message.
	*
	* @return the ID of this dummy message
	*/
	@Override
	public long getId() {
		return _dummyMessage.getId();
	}

	/**
	* Returns the primary key of this dummy message.
	*
	* @return the primary key of this dummy message
	*/
	@Override
	public long getPrimaryKey() {
		return _dummyMessage.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dummyMessage.getPrimaryKeyObj();
	}

	/**
	* Returns the tag of this dummy message.
	*
	* @return the tag of this dummy message
	*/
	@Override
	public String getTag() {
		return _dummyMessage.getTag();
	}

	/**
	* Returns the text of this dummy message.
	*
	* @return the text of this dummy message
	*/
	@Override
	public String getText() {
		return _dummyMessage.getText();
	}

	@Override
	public int hashCode() {
		return _dummyMessage.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _dummyMessage.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dummyMessage.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dummyMessage.isNew();
	}

	@Override
	public void persist() {
		_dummyMessage.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dummyMessage.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dummyMessage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dummyMessage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dummyMessage.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this dummy message.
	*
	* @param id the ID of this dummy message
	*/
	@Override
	public void setId(long id) {
		_dummyMessage.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_dummyMessage.setNew(n);
	}

	/**
	* Sets the primary key of this dummy message.
	*
	* @param primaryKey the primary key of this dummy message
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dummyMessage.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dummyMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tag of this dummy message.
	*
	* @param tag the tag of this dummy message
	*/
	@Override
	public void setTag(String tag) {
		_dummyMessage.setTag(tag);
	}

	/**
	* Sets the text of this dummy message.
	*
	* @param text the text of this dummy message
	*/
	@Override
	public void setText(String text) {
		_dummyMessage.setText(text);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DummyMessage> toCacheModel() {
		return _dummyMessage.toCacheModel();
	}

	@Override
	public DummyMessage toEscapedModel() {
		return new DummyMessageWrapper(_dummyMessage.toEscapedModel());
	}

	@Override
	public String toString() {
		return _dummyMessage.toString();
	}

	@Override
	public DummyMessage toUnescapedModel() {
		return new DummyMessageWrapper(_dummyMessage.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _dummyMessage.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DummyMessageWrapper)) {
			return false;
		}

		DummyMessageWrapper dummyMessageWrapper = (DummyMessageWrapper)obj;

		if (Objects.equals(_dummyMessage, dummyMessageWrapper._dummyMessage)) {
			return true;
		}

		return false;
	}

	@Override
	public DummyMessage getWrappedModel() {
		return _dummyMessage;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dummyMessage.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dummyMessage.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dummyMessage.resetOriginalValues();
	}

	private final DummyMessage _dummyMessage;
}