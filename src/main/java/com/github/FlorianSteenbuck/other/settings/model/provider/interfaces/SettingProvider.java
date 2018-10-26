package com.github.FlorianSteenbuck.other.settings.model.provider.interfaces;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;

public interface SettingProvider<D> {
    D getData();
    void setData(D data) throws WrongSettingsDataException;
    boolean valid(Object data);
}
