nuxeo-custom-force-locale
===

## About this module

This module allows to force a language in the JSF UI whatever language the users have defined in their profile.

## Building

        mvn clean install

## Using

All you have to do is:

 - copy the bundle in `nxserver/plugins` or `nxserver/bundles`

 - contribute a configuration property named `nuxeo.force-locale` which value is the language code you want to force i.e. `en`, `fr`, ...:

   * contribute a `XML extension` in **Studio**:
```xml
    <extension target="org.nuxeo.runtime.ConfigurationService" point="configuration">

      <property name="nuxeo.force-locale">en</property>

    </extension>
```

   * or create a file in `$NUXEO_HOME/nxserver/config/` (make sure the name ends with `-config.xml`) with the following XML:

```xml
    <component name="org.nuxeo.ecm.user.center.profile.locale.contrib.custom.configuration" >

      <extension target="org.nuxeo.runtime.ConfigurationService" point="configuration">

        <property name="nuxeo.force-locale">en</property>

      </extension>

    </component>
```

- restart the server

