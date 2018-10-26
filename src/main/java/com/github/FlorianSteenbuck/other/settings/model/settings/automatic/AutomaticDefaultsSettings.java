package com.github.FlorianSteenbuck.other.settings.model.settings.automatic;

import com.github.FlorianSteenbuck.other.settings.SettingIdGeneratorExtension;
import com.github.FlorianSteenbuck.other.settings.SettingsOrganisator;
import com.github.FlorianSteenbuck.other.settings.exceptions.UnsupportedSettingValueException;
import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.interfaces.SettingProvider;
import com.github.FlorianSteenbuck.other.settings.model.provider.list.CheckboxesProvider;
import com.github.FlorianSteenbuck.other.settings.model.provider.list.GroupDoubleProvider;
import com.github.FlorianSteenbuck.other.settings.model.provider.list.GroupIntegerProvider;
import com.github.FlorianSteenbuck.other.settings.model.provider.list.StringListProvider;
import com.github.FlorianSteenbuck.other.settings.model.provider.single.*;
import com.github.FlorianSteenbuck.other.settings.model.settings.interfaces.WriteableSettings;

import java.util.*;

public class AutomaticDefaultsSettings extends SettingIdGeneratorExtension implements WriteableSettings {
    protected HashMap<String, Object> settings;

    public AutomaticDefaultsSettings(SettingsOrganisator organisator) {
        super(organisator);
        settings = new HashMap<String, Object>();
        setId(generateId(), this);
    }

    public AutomaticDefaultsSettings() {
        this(SettingsOrganisator.getInstance());
    }

    public AutomaticDefaultsSettings(Map<String, ?> defaults) {
        this(SettingsOrganisator.getInstance(), defaults);
    }

    public AutomaticDefaultsSettings(SettingsOrganisator organisator, Map<String, ?> defaults) {
        this(organisator);

        Map<String, SettingProvider> providers = new HashMap<String, SettingProvider>();
        for (Map.Entry<String, ?> defaultEntry:defaults.entrySet()){
            String key = defaultEntry.getKey();
            Object value = defaultEntry.getValue();
            if (value instanceof List) {
                List listValue = (List) value;
                HashMap<Class<?>, ArrayList> classMap = new HashMap<Class<?>, ArrayList>();

                for (Object listEntry:listValue) {
                    if (listEntry instanceof Boolean) {
                        Boolean boolEntry = (Boolean) listEntry;
                        if (!classMap.containsKey(Boolean.class)) {
                            classMap.put(Boolean.class, new ArrayList());
                        }
                        ArrayList boolList = classMap.get(Boolean.class);
                        boolList.add(boolEntry);
                        classMap.put(Boolean.class, boolList);
                    } else if (listEntry instanceof Integer) {
                        Integer intEntry = (Integer) listEntry;
                        if (!classMap.containsKey(Integer.class)) {
                            classMap.put(Integer.class, new ArrayList());
                        }
                        ArrayList intList = classMap.get(Integer.class);
                        intList.add(intEntry);
                        classMap.put(Integer.class, intList);
                    } else if (listEntry instanceof Double) {
                        Double doubleEntry = (Double) listEntry;
                        if (!classMap.containsKey(Double.class)) {
                            classMap.put(Double.class, new ArrayList());
                        }
                        ArrayList doubleList = classMap.get(Double.class);
                        doubleList.add(doubleEntry);
                        classMap.put(Double.class, doubleList);
                    } else if (listEntry instanceof String) {
                        String strEntry = (String) listEntry;
                        if (!classMap.containsKey(String.class)) {
                            classMap.put(String.class, new ArrayList());
                        }
                        ArrayList strList = classMap.get(String.class);
                        strList.add(strEntry);
                        classMap.put(String.class, strList);
                    } else {
                        Class<?> clazz = value.getClass();
                        if (!classMap.containsKey(clazz)) {
                            classMap.put(clazz, new ArrayList());
                        }
                        ArrayList otherList = classMap.get(clazz);
                        otherList.add(value);
                        classMap.put(clazz, otherList);
                    }
                }

                Set<Class<?>> types = classMap.keySet();
                if (types.size() == 1) {
                    Class<?> singleClass = types.toArray(new Class[0])[0];
                } else {
                    for (Class type:types) {
                        if (type == Boolean.class) {
                            key += "..bool";
                        } else if (type == Integer.class) {
                            key += "..int";
                        } else if (type == Double.class) {
                            key += "..double";
                        } else if (type == String.class) {
                            key += "..str";
                        } else {
                            key += ".."+type.getName();
                        }

                        List valueList = classMap.get(type);
                        if (valueList.size() == 1) {
                            settings.put(key, valueList.get(0));
                        } else {
                            key += "..s";
                            settings.put(key, value);
                        }
                    }
                }
            } else if (value instanceof Map) {
                Map mapValue = (Map) value;
                HashMap<String, ?> settingsData = new HashMap<String, Object>();
                AutomaticDefaultsSettings sett = new AutomaticDefaultsSettings(settingsData);
                settings.put(key, );
            } else {
                settings.put(key, value);
            }
        }
    }

    protected SettingProvider getListProviderFromList(Class<?> type, List value) {
        try {
            if (type == Boolean.class) {
                return new CheckboxesProvider((List<Boolean>) value);
            } else if (type == Integer.class) {
                return new GroupIntegerProvider((List<Integer>) value);
            } else if (type == Double.class) {
                return new GroupDoubleProvider((List<Double>) value);
            } else if (type == String.class) {
                return new StringListProvider((List<String>) value);
            }
        } catch (WrongSettingsDataException e) {}
        return null;
    }

    protected SettingProvider getSingleProviderFromClass(Class<?> type, Object value) {
        try {
            if (type == Boolean.class) {
                return new BooleanCheckboxProvider((Boolean) value);
            } else if (type == Integer.class) {
                return new IntInputProvider((Integer) value);
            } else if (type == Double.class) {
                return new DoubleInputProvider((Double) value);
            } else if (type == String.class) {
                String strValue = (String) value;
                if (strValue.contains("\n")) {
                    return new TextAreaProvider(strValue);
                }
                return new StringLineProvider((String) value);
            }
        } catch (WrongSettingsDataException e) {}
        return null;
    }

    @Override
    public void set(String s, Object o) throws UnsupportedSettingValueException, WrongSettingsDataException {
        settings.put(s, o);
    }

    @Override
    public void setString(String s, String s1) throws WrongSettingsDataException {
        try {
            set(s, s1);
        } catch (UnsupportedSettingValueException ex) {
            throw new WrongSettingsDataException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void setNumber(String s, Number number) throws WrongSettingsDataException {
        try {
            set(s, number);
        } catch (UnsupportedSettingValueException ex) {
            throw new WrongSettingsDataException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void setBoolean(String s, Boolean aBoolean) throws WrongSettingsDataException {
        try {
            set(s, aBoolean);
        } catch (UnsupportedSettingValueException ex) {
            throw new WrongSettingsDataException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Collection<String> getMandatories() {
        return new LinkedList<String>();
    }

    @Override
    public Map<String, SettingProvider> getSettingProviders() {
        return null;
    }

    @Override
    public boolean has(String s) {
        return settings.containsKey(s);
    }

    @Override
    public Object get(String s) {
        return settings.get(s);
    }

    @Override
    public String getString(String s) {
        return (String) get(s);
    }

    @Override
    public Number getNumber(String s) {
        return (Number) get(s);
    }

    @Override
    public Boolean getBoolean(String s) {
        return (Boolean) get(s);
    }
}