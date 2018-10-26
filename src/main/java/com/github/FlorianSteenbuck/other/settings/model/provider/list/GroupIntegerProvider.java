package com.github.FlorianSteenbuck.other.settings.model.provider.list;

import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingProviderBase;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

import java.util.List;

public class GroupIntegerProvider extends SettingProviderBase<List<Integer>> {
    public GroupIntegerProvider(List<Integer> defaultData) throws WrongSettingsDataException {
        super(defaultData, SettingsTyp.GROUP_INT);
    }
}
