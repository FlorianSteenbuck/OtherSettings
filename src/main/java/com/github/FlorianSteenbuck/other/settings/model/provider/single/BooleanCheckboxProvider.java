package com.github.FlorianSteenbuck.other.settings.model.provider.single;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingProviderBase;

import static com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp.CHECKBOX;

public class BooleanCheckboxProvider extends SettingProviderBase<Boolean> {
    public BooleanCheckboxProvider(Boolean defaultData) throws WrongSettingsDataException {
        super(defaultData, CHECKBOX);
    }
}
