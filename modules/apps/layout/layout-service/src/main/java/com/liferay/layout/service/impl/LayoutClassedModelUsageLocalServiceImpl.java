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

package com.liferay.layout.service.impl;

import com.liferay.layout.model.LayoutClassedModelUsage;
import com.liferay.layout.service.base.LayoutClassedModelUsageLocalServiceBaseImpl;
import com.liferay.layout.util.constants.LayoutClassedModelUsageConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = "model.class.name=com.liferay.layout.model.LayoutClassedModelUsage",
	service = AopService.class
)
public class LayoutClassedModelUsageLocalServiceImpl
	extends LayoutClassedModelUsageLocalServiceBaseImpl {

	@Override
	public LayoutClassedModelUsage addDefaultLayoutClassedModelUsage(
		long groupId, long classNameId, long classPK,
		ServiceContext serviceContext) {

		return addLayoutClassedModelUsage(
			groupId, classNameId, classPK, StringPool.BLANK, 0, 0,
			LayoutClassedModelUsageConstants.TYPE_DEFAULT, serviceContext);
	}

	@Override
	public LayoutClassedModelUsage addLayoutClassedModelUsage(
		long groupId, long classNameId, long classPK, String containerKey,
		long containerType, long plid, int type,
		ServiceContext serviceContext) {

		long layoutClassedModelUsageId = counterLocalService.increment();

		LayoutClassedModelUsage layoutClassedModelUsage =
			layoutClassedModelUsagePersistence.create(
				layoutClassedModelUsageId);

		layoutClassedModelUsage.setUuid(serviceContext.getUuid());
		layoutClassedModelUsage.setGroupId(groupId);
		layoutClassedModelUsage.setCreateDate(new Date());
		layoutClassedModelUsage.setModifiedDate(new Date());
		layoutClassedModelUsage.setClassNameId(classNameId);
		layoutClassedModelUsage.setClassPK(classPK);
		layoutClassedModelUsage.setContainerKey(containerKey);
		layoutClassedModelUsage.setContainerType(containerType);
		layoutClassedModelUsage.setPlid(plid);
		layoutClassedModelUsage.setType(type);

		return layoutClassedModelUsagePersistence.update(
			layoutClassedModelUsage);
	}

	@Override
	public void deleteLayoutClassedModelUsages(long classNameId, long classPK) {
		layoutClassedModelUsagePersistence.removeByC_C(classNameId, classPK);
	}

	@Override
	public void deleteLayoutClassedModelUsages(
		String containerKey, long containerType, long plid) {

		layoutClassedModelUsagePersistence.removeByCK_CT_P(
			containerKey, containerType, plid);
	}

	@Override
	public void deleteLayoutClassedModelUsagesByPlid(long plid) {
		layoutClassedModelUsagePersistence.removeByPlid(plid);
	}

	@Override
	public LayoutClassedModelUsage fetchLayoutClassedModelUsage(
		long classNameId, long classPK, String containerKey, long containerType,
		long plid) {

		return layoutClassedModelUsagePersistence.fetchByC_C_CK_CT_P(
			classNameId, classPK, containerKey, containerType, plid);
	}

	@Override
	public List<LayoutClassedModelUsage> getLayoutClassedModelUsages(
		long classNameId, long classPK) {

		return layoutClassedModelUsagePersistence.findByC_C(
			classNameId, classPK);
	}

	@Override
	public List<LayoutClassedModelUsage> getLayoutClassedModelUsages(
		long classNameId, long classPK, int type, int start, int end,
		OrderByComparator<LayoutClassedModelUsage> orderByComparator) {

		return layoutClassedModelUsagePersistence.findByC_C_T(
			classNameId, classPK, type, start, end, orderByComparator);
	}

	@Override
	public List<LayoutClassedModelUsage> getLayoutClassedModelUsages(
		long classNameId, long classPK, int start, int end,
		OrderByComparator<LayoutClassedModelUsage> orderByComparator) {

		return layoutClassedModelUsagePersistence.findByC_C(
			classNameId, classPK, start, end, orderByComparator);
	}

	@Override
	public List<LayoutClassedModelUsage> getLayoutClassedModelUsagesByPlid(
		long plid) {

		return layoutClassedModelUsagePersistence.findByPlid(plid);
	}

	@Override
	public int getLayoutClassedModelUsagesCount(
		long classNameId, long classPK) {

		return layoutClassedModelUsagePersistence.countByC_C(
			classNameId, classPK);
	}

	@Override
	public int getLayoutClassedModelUsagesCount(
		long classNameId, long classPK, int type) {

		return layoutClassedModelUsagePersistence.countByC_C_T(
			classNameId, classPK, type);
	}

	@Override
	public int getUniqueLayoutClassedModelUsagesCount(
		long classNameId, long classPK) {

		return layoutClassedModelUsageFinder.countByC_C(classNameId, classPK);
	}

	@Override
	public boolean hasDefaultLayoutClassedModelUsage(
		long classNameId, long classPK) {

		LayoutClassedModelUsage layoutClassedModelUsage =
			layoutClassedModelUsageLocalService.fetchLayoutClassedModelUsage(
				classNameId, classPK, StringPool.BLANK, 0, 0);

		if (layoutClassedModelUsage != null) {
			return true;
		}

		return false;
	}

}