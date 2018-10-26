package com.github.FlorianSteenbuck.other.settings.model.provider.single;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingProviderBase;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

public class StringLineProvider extends SettingProviderBase<String> {
    public StringLineProvider(String defaultData) throws WrongSettingsDataException {
        super(defaultData, SettingsTyp.TEXT_LINE);
    }
}
