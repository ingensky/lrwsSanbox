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

package com.dummy.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.dummy.model.DummyMessage;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DummyMessage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DummyMessage
 * @generated
 */
@ProviderType
public class DummyMessageCacheModel implements CacheModel<DummyMessage>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DummyMessageCacheModel)) {
			return false;
		}

		DummyMessageCacheModel dummyMessageCacheModel = (DummyMessageCacheModel)obj;

		if (id == dummyMessageCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", text=");
		sb.append(text);
		sb.append(", tag=");
		sb.append(tag);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DummyMessage toEntityModel() {
		DummyMessageImpl dummyMessageImpl = new DummyMessageImpl();

		dummyMessageImpl.setId(id);

		if (text == null) {
			dummyMessageImpl.setText("");
		}
		else {
			dummyMessageImpl.setText(text);
		}

		if (tag == null) {
			dummyMessageImpl.setTag("");
		}
		else {
			dummyMessageImpl.setTag(tag);
		}

		dummyMessageImpl.resetOriginalValues();

		return dummyMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		text = objectInput.readUTF();
		tag = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(text);
		}

		if (tag == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tag);
		}
	}

	public long id;
	public String text;
	public String tag;
}