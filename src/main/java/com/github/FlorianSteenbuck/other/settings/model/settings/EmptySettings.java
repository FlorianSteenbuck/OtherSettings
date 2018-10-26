package com.github.FlorianSteenbuck.other.settings.model.settings;

import com.github.FlorianSteenbuck.other.settings.model.provider.interfaces.SettingProvider;
import com.github.FlorianSteenbuck.other.settings.model.settings.interfaces.Settings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmptySettings implements Settings {
    @Override
    public int getId() {
        return -1;
    }

    @Override
    public Collection<String> getMandatories() {
        return new ArrayList<String>();
    }

    @Override
    public Map<String, SettingProvider> getSettingProviders() {
        return new HashMap<String, SettingProvider>();
    }

    @Override
    public boolean has(String id) {
        return false;
    }

    @Override
    public Object get(String id) {
        return null;
    }

    @Override
    public String getString(String id) {
        return null;
    }

    @Override
    public Number getNumber(String id) {
        return null;
    }

    @Override
    public Boolean getBoolean(String id) {
        return null;
    }
}
