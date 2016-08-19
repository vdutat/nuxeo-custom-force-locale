/*
 * (C) Copyright 2016 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     vdutat
 *
 */
package org.nuxeo.ecm.platform.web.common.locale;

import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.services.config.ConfigurationService;

public class CustomLocaleProvider extends DefaultLocaleProvider {

    private static final Log LOGGER = LogFactory.getLog(CustomLocaleProvider.class);

	@Override
	public Locale getLocale(CoreSession session) {
		LOGGER.debug("<getLocale> " + session);
		return getLocale();
	}

	@Override
	public Locale getLocale(DocumentModel userProfileDoc) {
		LOGGER.debug("<getLocale> " + userProfileDoc);
		return getLocale();
	}

	@Override
	public TimeZone getTimeZone(CoreSession session) {
		return super.getTimeZone(session);
	}

	protected Locale getLocale() {
        ConfigurationService service = Framework.getService(ConfigurationService.class);
        String localeStr = service.getProperty("nuxeo.force-locale");
        if (localeStr == null) {
        	return Locale.getDefault();
        }
		Locale locale = LocaleUtils.toLocale(localeStr);
		LOGGER.debug("<getLocale> " + locale.toString());
		return locale;
	}

}
