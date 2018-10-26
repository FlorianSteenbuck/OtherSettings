package com.github.FlorianSteenbuck.other.settings.model.provider.abstracts;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

import java.util.Collection;

public abstract class SettingsProviderWithValidValues<D> extends SettingProviderBase<D> {
    protected Collection<?> validValues;

    public SettingsProviderWithValidValues(D defaultData, Collection<?> validValues, SettingsTyp typ) throws WrongSettingsDataException {
        super(defaultData, typ);
        this.validValues = validValues;
    }

    @Override
    public boolean valid(Object data) {
        return validValues.contains(data);
    }
}
