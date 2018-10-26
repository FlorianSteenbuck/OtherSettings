package com.github.FlorianSteenbuck.other.settings.model.settings.abstracts;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.single.BooleanCheckboxProvider;
import com.github.FlorianSteenbuck.other.settings.model.provider.single.NumberInputProvider;
import com.github.FlorianSteenbuck.other.settings.model.provider.interfaces.SettingProvider;
import com.github.FlorianSteenbuck.other.settings.model.provider.single.StringLineProvider;
import com.github.FlorianSteenbuck.other.settings.model.settings.interfaces.Settings;

import java.util.*;

public abstract class OverrideDynamicSettings extends PreSupportDynamicWriteableSettings {
    protected Map<String, SettingProvider> liveProviders = new HashMap<String, SettingProvider>();
    protected Map<String, SettingProvider> overrideProviders = new HashMap<String, SettingProvider>();

    protected boolean needUpdateCache = true;
    protected Map<String, SettingProvider> cachedProviders = new HashMap<String, SettingProvider>();

    @Override
    public Collection<String> getMandatories() {
        return new ArrayList<String>();
    }

    @Override
    public Map<String, SettingProvider> getSettingProviders() {
        if (needUpdateCache) {
            cachedProviders = liveProviders;
            for (Map.Entry<String, SettingProvider> provider : overrideProviders.entrySet()) {
                cachedProviders.put(provider.getKey(), provider.getValue());
            }
            needUpdateCache = false;
        }
        return cachedProviders;
    }

    @Override
    public void setString(String id, String settingValue) throws WrongSettingsDataException {
        SettingProvider settingProvider = new StringLineProvider(settingValue);
        if (has(id)) {
            settingProvider = getSettingProviders().get(id);
            settingProvider.setData(settingValue);
        }
        overrideProviders.put(id, settingProvider);
        needUpdateCache = true;
    }

    @Override
    public void setNumber(String id, Number settingValue) throws WrongSettingsDataException {
        SettingProvider settingProvider = new NumberInputProvider(settingValue);
        if (has(id)) {
            settingProvider = getSettingProviders().get(id);
            settingProvider.setData(settingValue);
        }
        overrideProviders.put(id, settingProvider);
        needUpdateCache = true;
    }

    @Override
    public void setBoolean(String id, Boolean settingValue) throws WrongSettingsDataException {
        SettingProvider settingProvider = new BooleanCheckboxProvider(settingValue);
        if (has(id)) {
            settingProvider = getSettingProviders().get(id);
            settingProvider.setData(settingValue);
        }
        overrideProviders.put(id, settingProvider);
        needUpdateCache = true;
    }

    @Override
    public boolean has(String id) {
        return getSettingProviders().containsKey(id);
    }

    @Override
    public Object get(String id) {
        return getSettingProviders().get(id).getData();
    }

    @Override
    public String getString(String id) {
        return (String) getSettingProviders().get(id).getData();
    }

    @Override
    public Number getNumber(String id) {
        return (Number) getSettingProviders().get(id).getData();
    }

    @Override
    public Boolean getBoolean(String id) {
        return (Boolean) getSettingProviders().get(id).getData();
    }
}
