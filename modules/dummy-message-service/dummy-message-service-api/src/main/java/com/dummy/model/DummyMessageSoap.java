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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class DummyMessageSoap implements Serializable {
	public static DummyMessageSoap toSoapModel(DummyMessage model) {
		DummyMessageSoap soapModel = new DummyMessageSoap();

		soapModel.setId(model.getId());
		soapModel.setText(model.getText());
		soapModel.setTag(model.getTag());

		return soapModel;
	}

	public static DummyMessageSoap[] toSoapModels(DummyMessage[] models) {
		DummyMessageSoap[] soapModels = new DummyMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DummyMessageSoap[][] toSoapModels(DummyMessage[][] models) {
		DummyMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DummyMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DummyMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DummyMessageSoap[] toSoapModels(List<DummyMessage> models) {
		List<DummyMessageSoap> soapModels = new ArrayList<DummyMessageSoap>(models.size());

		for (DummyMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DummyMessageSoap[soapModels.size()]);
	}

	public DummyMessageSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	private long _id;
	private String _text;
	private String _tag;
}