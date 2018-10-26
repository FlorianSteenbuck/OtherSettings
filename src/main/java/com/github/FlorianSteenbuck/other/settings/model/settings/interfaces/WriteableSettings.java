package com.github.FlorianSteenbuck.other.settings.model.settings.interfaces;

import com.github.FlorianSteenbuck.other.settings.exceptions.UnsupportedSettingValueException;
import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;

public interface WriteableSettings extends Settings {
    void set(String id, Object settingValue) throws UnsupportedSettingValueException, WrongSettingsDataException;
    void setString(String id, String settingValue) throws WrongSettingsDataException;
    void setNumber(String id, Number settingValue) throws WrongSettingsDataException;
    void setBoolean(String id, Boolean settingValue) throws WrongSettingsDataException;
}
