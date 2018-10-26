package com.github.FlorianSteenbuck.other.settings.model.provider.single;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingProviderBase;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

public class DoubleInputProvider extends SettingProviderBase<Double> {
    public DoubleInputProvider(Double defaultData) throws WrongSettingsDataException {
        super(defaultData, SettingsTyp.INPUT_DOUBLE);
    }
}
