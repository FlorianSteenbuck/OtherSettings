package com.github.FlorianSteenbuck.other.settings.model.provider.abstracts;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.helper.SettingsHelper;
import com.github.FlorianSteenbuck.other.settings.model.provider.interfaces.SettingProvider;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsOutput;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class SettingProviderBase<D> implements SettingProvider<D> {
    private D data;
    private SettingsTyp typ;

    public SettingProviderBase(D defaultData, SettingsTyp typ) throws WrongSettingsDataException {
        this.typ = typ;
        setData(defaultData);
    }

    @Override
    public D getData() {
        return data;
    }

    @Override
    public boolean valid(Object data) {
        return true;
    }

    @Override
    public void setData(D data) throws WrongSettingsDataException {
        if (!SettingsHelper.instanceOfSettingsTyp(data, typ)) {
            throw new WrongSettingsDataException("data is not compatible with the SettingsTyp "+typ.name());
        }

        if (data instanceof Collection) {
            int i = 0;
            for (Object singleData:(Collection) data) {
                if (!valid(singleData)) {
                    throw new WrongSettingsDataException("data["+i+"] is not valid by SettingProvider");
                }
                i++;
            }
        } else {
            if (!valid(data)) {
                throw new WrongSettingsDataException("data is not valid by SettingProvider");
            }
        }
        this.data = data;
    }
}
