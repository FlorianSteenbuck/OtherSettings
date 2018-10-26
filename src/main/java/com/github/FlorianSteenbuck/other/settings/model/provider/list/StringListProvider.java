package com.github.FlorianSteenbuck.other.settings.model.provider.list;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingProviderBase;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

import java.util.List;

public class StringListProvider extends SettingProviderBase<List<String>> {
    public StringListProvider(List<String> defaultData) throws WrongSettingsDataException {
        super(defaultData, SettingsTyp.LIST);
    }
}
