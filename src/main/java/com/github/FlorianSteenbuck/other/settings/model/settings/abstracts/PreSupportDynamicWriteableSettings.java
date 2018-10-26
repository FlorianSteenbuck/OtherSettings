package com.github.FlorianSteenbuck.other.settings.model.settings.abstracts;

import com.github.FlorianSteenbuck.other.settings.exceptions.UnsupportedSettingValueException;
import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.settings.interfaces.DynamicWriteableSettings;

public abstract class PreSupportDynamicWriteableSettings implements DynamicWriteableSettings {
    @Override
    public void set(String id, Object settingValue) throws UnsupportedSettingValueException, WrongSettingsDataException {
        if (settingValue instanceof String) {
            setString(id, (String) settingValue);
        } else if (settingValue instanceof Number) {
            setNumber(id, (Number) settingValue);
        } else if (settingValue instanceof Boolean) {
            setBoolean(id, (Boolean) settingValue);
        } else {
            throw new UnsupportedSettingValueException(settingValue.getClass().getName()+" is unsupported");
        }
    }
}
