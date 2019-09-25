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

import {ClayButtonWithIcon} from '@clayui/button';
import {ClayInput} from '@clayui/form';
import React, {
	useRef,
	useState,
	useEffect,
	useContext,
	useCallback,
	useLayoutEffect
} from 'react';
import Sidebar from '../../components/sidebar/Sidebar.es';
import classNames from 'classnames';
import {useKeyDown} from '../../hooks/index.es';
import CustomObjectFieldsList from './CustomObjectFieldsList.es';
import FormViewContext from './FormViewContext.es';
import ClayDropDown, {Align} from '@clayui/drop-down';
import {ADD_CUSTOM_OBJECT_FIELD} from './actions.es';

const DropDown = () => {
	const [{fieldTypes}, dispatch] = useContext(FormViewContext);
	const [active, setActive] = useState(false);
	const [showFieldTypes, setShowFieldTypes] = useState(false);

	const onActiveChange = newVal => {
		setActive(newVal);
		setShowFieldTypes(false);
	};

	const onClickFieldType = fieldTypeName => {
		setActive(false);
		dispatch({payload: {fieldTypeName}, type: ADD_CUSTOM_OBJECT_FIELD});
	};

	useLayoutEffect(() => {
		if (active) {
			const {parentElement} = document.querySelector(
				'.custom-object-dropdown-list'
			);

			parentElement.classList.add('custom-object-dropdown-menu');
		}
	}, [active]);

	return (
		<ClayDropDown
			active={active}
			alignmentPosition={Align.BottomRight}
			className="custom-object-dropdown"
			onActiveChange={onActiveChange}
			trigger={
				<ClayButtonWithIcon displayType="unstyled" symbol="plus" />
			}
		>
			<ClayDropDown.ItemList className="custom-object-dropdown-list">
				{showFieldTypes ? (
					fieldTypes.map(({icon, label, name}) => (
						<ClayDropDown.Item
							key={name}
							onClick={() => onClickFieldType(name)}
							symbolLeft={icon}
						>
							{label}
						</ClayDropDown.Item>
					))
				) : (
					<>
						<ClayDropDown.Item
							key={'add'}
							onClick={() => setShowFieldTypes(true)}
						>
							{Liferay.Language.get('add-field-to-object')}
						</ClayDropDown.Item>
						<ClayDropDown.Item key={'import'}>
							{Liferay.Language.get(
								'import-fields-from-spreadsheet'
							)}
						</ClayDropDown.Item>
					</>
				)}
			</ClayDropDown.ItemList>
		</ClayDropDown>
	);
};

const Header = ({keywords, onCloseSearch, onSearch}) => {
	const [searchMode, setSearchMode] = useState(false);

	const closeSearch = useCallback(() => {
		setSearchMode(false);
		onCloseSearch();
	}, [onCloseSearch, setSearchMode]);

	const onClickClose = () => closeSearch();
	const onClickSearch = () => setSearchMode(true);

	const onChangeSearchInput = ({target}) => onSearch(target.value);

	useKeyDown(() => {
		if (searchMode) {
			closeSearch();
		}
	}, 27);

	const searchInputRef = useRef();

	useEffect(() => {
		if (searchMode && searchInputRef.current) {
			searchInputRef.current.focus();
		}
	}, [searchInputRef, searchMode]);

	const [{dataDefinition}] = useContext(FormViewContext);
	const {
		name: {en_US: dataDefinitionName = ''}
	} = dataDefinition;

	return (
		<div
			className={classNames(
				'custom-object-sidebar-header',
				'mt-4',
				'p-2',
				{
					'ml-4': !searchMode
				}
			)}
		>
			<div className="autofit-row autofit-row-center">
				{searchMode ? (
					<>
						<div className="autofit-col autofit-col-expand">
							<ClayInput.Group>
								<ClayInput.GroupItem>
									<ClayInput
										aria-label={Liferay.Language.get(
											'search'
										)}
										className="input-group-inset input-group-inset-after"
										onChange={onChangeSearchInput}
										placeholder={Liferay.Language.get(
											'search'
										)}
										ref={searchInputRef}
										type="text"
										value={keywords}
									/>
									<ClayInput.GroupInsetItem after>
										<ClayButtonWithIcon
											displayType="unstyled"
											symbol="search"
										/>
									</ClayInput.GroupInsetItem>
								</ClayInput.GroupItem>
							</ClayInput.Group>
						</div>
						<div className="autofit-col ml-2" key="closeButton">
							<ClayButtonWithIcon
								displayType="unstyled"
								onClick={onClickClose}
								symbol="times"
							/>
						</div>
					</>
				) : (
					<>
						<div className="autofit-col autofit-col-expand">
							<h3>{dataDefinitionName}</h3>
						</div>

						<div className="autofit-col" key="searchButton">
							<ClayButtonWithIcon
								displayType="unstyled"
								onClick={onClickSearch}
								symbol="search"
							/>
						</div>

						<div className="autofit-col" key="dropdown">
							<DropDown />
						</div>
					</>
				)}
			</div>
		</div>
	);
};

export default () => {
	const [keywords, setKeywords] = useState('');
	const sidebarRef = useRef();

	return (
		<Sidebar closeable={false} ref={sidebarRef}>
			<>
				<Header
					keywords={keywords}
					onCloseSearch={() => setKeywords('')}
					onSearch={keywords => setKeywords(keywords)}
				/>

				<Sidebar.Body>
					<CustomObjectFieldsList keywords={keywords} />
				</Sidebar.Body>
			</>
		</Sidebar>
	);
};
