package com.github.FlorianSteenbuck.other.settings.model.provider.single;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingProviderBase;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

public class IntInputProvider extends SettingProviderBase<Integer> {
    public IntInputProvider(Integer defaultData) throws WrongSettingsDataException {
        super(defaultData, SettingsTyp.INPUT_INT);
    }
}
