package com.github.FlorianSteenbuck.other.settings.model.provider.single;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingProviderBase;

import static com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp.INPUT_NUMBER;

public class NumberInputProvider extends SettingProviderBase<Number> {
    public NumberInputProvider(Number defaultData) throws WrongSettingsDataException {
        super(defaultData, INPUT_NUMBER);
    }
}
