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

package com.rumbasolutions.flask.service.base;

import com.rumbasolutions.flask.service.TailgateSupplyItemServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TailgateSupplyItemServiceClpInvoker {
	public TailgateSupplyItemServiceClpInvoker() {
		_methodName66 = "getBeanIdentifier";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "setBeanIdentifier";

		_methodParameterTypes67 = new String[] { "java.lang.String" };

		_methodName72 = "addTailgateSupplyItem";

		_methodParameterTypes72 = new String[] {
				"java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName73 = "addTailgateSupplyItems";

		_methodParameterTypes73 = new String[] {
				"java.lang.String[][]", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName74 = "updateTailgateSupplyItem";

		_methodParameterTypes74 = new String[] {
				"long", "java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName75 = "getTailgateSupplyItem";

		_methodParameterTypes75 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName76 = "getItemsByTailgateId";

		_methodParameterTypes76 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName77 = "getMyTailgateSupplyItems";

		_methodParameterTypes77 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName78 = "getAllTailgateSupplyItems";

		_methodParameterTypes78 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName79 = "deleteTailgateSupplyItem";

		_methodParameterTypes79 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName80 = "deleteItemsByTailgateId";

		_methodParameterTypes80 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName81 = "deleteMyItems";

		_methodParameterTypes81 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return TailgateSupplyItemServiceUtil.getBeanIdentifier();
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			TailgateSupplyItemServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return TailgateSupplyItemServiceUtil.addTailgateSupplyItem((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return TailgateSupplyItemServiceUtil.addTailgateSupplyItems((java.lang.String[])arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return TailgateSupplyItemServiceUtil.updateTailgateSupplyItem(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return TailgateSupplyItemServiceUtil.getTailgateSupplyItem(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return TailgateSupplyItemServiceUtil.getItemsByTailgateId(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return TailgateSupplyItemServiceUtil.getMyTailgateSupplyItems((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return TailgateSupplyItemServiceUtil.getAllTailgateSupplyItems((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			TailgateSupplyItemServiceUtil.deleteTailgateSupplyItem(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			TailgateSupplyItemServiceUtil.deleteItemsByTailgateId(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			TailgateSupplyItemServiceUtil.deleteMyItems((com.liferay.portal.service.ServiceContext)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
}