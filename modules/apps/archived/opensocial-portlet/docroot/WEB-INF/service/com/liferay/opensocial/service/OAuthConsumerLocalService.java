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

package com.liferay.opensocial.service;

import com.liferay.opensocial.model.OAuthConsumer;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for OAuthConsumer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConsumerLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OAuthConsumerLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.opensocial.service.impl.OAuthConsumerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the o auth consumer local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link OAuthConsumerLocalServiceUtil} if injection and service tracking are not available.
	 */
	public OAuthConsumer addOAuthConsumer(
		long companyId, String gadgetKey, String serviceName,
		String consumerKey, String consumerSecret, String keyType);

	/**
	 * Adds the o auth consumer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OAuthConsumerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param oAuthConsumer the o auth consumer
	 * @return the o auth consumer that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OAuthConsumer addOAuthConsumer(OAuthConsumer oAuthConsumer);

	/**
	 * Creates a new o auth consumer with the primary key. Does not add the o auth consumer to the database.
	 *
	 * @param oAuthConsumerId the primary key for the new o auth consumer
	 * @return the new o auth consumer
	 */
	@Transactional(enabled = false)
	public OAuthConsumer createOAuthConsumer(long oAuthConsumerId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the o auth consumer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OAuthConsumerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param oAuthConsumerId the primary key of the o auth consumer
	 * @return the o auth consumer that was removed
	 * @throws PortalException if a o auth consumer with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public OAuthConsumer deleteOAuthConsumer(long oAuthConsumerId)
		throws PortalException;

	/**
	 * Deletes the o auth consumer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OAuthConsumerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param oAuthConsumer the o auth consumer
	 * @return the o auth consumer that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public OAuthConsumer deleteOAuthConsumer(OAuthConsumer oAuthConsumer);

	public void deleteOAuthConsumers(String gadgetKey);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.opensocial.model.impl.OAuthConsumerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.opensocial.model.impl.OAuthConsumerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuthConsumer fetchOAuthConsumer(long oAuthConsumerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuthConsumer fetchOAuthConsumer(
		String gadgetKey, String serviceName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the o auth consumer with the primary key.
	 *
	 * @param oAuthConsumerId the primary key of the o auth consumer
	 * @return the o auth consumer
	 * @throws PortalException if a o auth consumer with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuthConsumer getOAuthConsumer(long oAuthConsumerId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuthConsumer getOAuthConsumer(String gadgetKey, String serviceName)
		throws PortalException;

	/**
	 * Returns a range of all the o auth consumers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.opensocial.model.impl.OAuthConsumerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of o auth consumers
	 * @param end the upper bound of the range of o auth consumers (not inclusive)
	 * @return the range of o auth consumers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OAuthConsumer> getOAuthConsumers(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OAuthConsumer> getOAuthConsumers(String gadgetKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OAuthConsumer> getOAuthConsumers(
		String gadgetKey, int start, int end);

	/**
	 * Returns the number of o auth consumers.
	 *
	 * @return the number of o auth consumers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOAuthConsumersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOAuthConsumersCount(String gadgetKey);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public OAuthConsumer updateOAuthConsumer(
			long oAuthConsumerId, String consumerKey, String consumerSecret,
			String keyType, String keyName, String callbackURL)
		throws PortalException;

	/**
	 * Updates the o auth consumer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OAuthConsumerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param oAuthConsumer the o auth consumer
	 * @return the o auth consumer that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OAuthConsumer updateOAuthConsumer(OAuthConsumer oAuthConsumer);

}