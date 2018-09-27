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

package com.liferay.apio.architect.exception.mapper.internal;

import static javax.ws.rs.core.Response.Status.METHOD_NOT_ALLOWED;

import com.liferay.apio.architect.error.APIError;
import com.liferay.apio.architect.exception.mapper.ExceptionMapper;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;

/**
 * Converts a {@code NotAllowedException} to its {@link APIError}
 * representation.
 *
 * @author Alejandro Hernández
 */
@Component(service = ExceptionMapper.class)
public class NotAllowedExceptionMapper
	extends WebApplicationExceptionMapper
	implements ExceptionMapper<NotAllowedException> {

	@Override
	public APIError map(NotAllowedException exception) {
		return super.convert(exception);
	}

	@Override
	protected Response.StatusType getStatusType() {
		return METHOD_NOT_ALLOWED;
	}

	@Override
	protected String getType() {
		return "not-allowed";
	}

}