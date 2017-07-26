package com.example.leoberteck.cardcrud.utils;

import android.util.Log;

import com.example.leoberteck.cardcrud.annotations.Profile;
import com.example.leoberteck.cardcrud.mvp.ModelFormMvp;
import com.example.leoberteck.cardcrud.mvp.impl.ModelFormPresenter;
import com.example.leoberteck.cardcrud.repository.impl.BrandRepository;
import com.example.leoberteck.cardcrud.repository.impl.ModelRepository;
import com.example.leoberteck.cardcrud.repository.impl.TypeRepository;
import com.example.leoberteck.cardcrud.repository.interfaces.IBrandRepository;
import com.example.leoberteck.cardcrud.repository.interfaces.IModelRepository;
import com.example.leoberteck.cardcrud.repository.interfaces.ITypeRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public final class DependencyCacheHelper {

    private static final String TAG = DependencyCacheHelper.class.getSimpleName();

    private static Map<Class, Set<Object>> dependencyCache = new HashMap<>();
    private static Map<Class, Set<Class>> dependencyLinks = new HashMap<>();

    static {
        link(IModelRepository.class, ModelRepository.class);
        link(IBrandRepository.class, BrandRepository.class);
        link(ITypeRepository.class, TypeRepository.class);
        link(ModelFormMvp.IModelFormPresenter.class, ModelFormPresenter.class);
    }

    public static <T> void disposeInstance(Class<T> tClass){
        dependencyCache.remove(tClass);
    }

    public static Map<Class, Set<Class>> getDependencyLinks() {
        return dependencyLinks;
    }

    public static <T> T getInstance(Class<T> tClass){
        return getInstance(tClass, null);
    }

    public static <T> T getInstance(Class<T> tClass, String profile){
        T value = null;
        if(dependencyCache.containsKey(tClass)){
            Set<Object> implementationSet = dependencyCache.get(tClass);
            Object valueToCast = null;
            Class valueClass = getClassBasedOnProfile(dependencyLinks.get(tClass), profile);
            Iterator valuesIterator = implementationSet.iterator();
            while(valuesIterator.hasNext()){
                Object _value = valuesIterator.next();
                if(_value.getClass().equals(valueClass)){
                    valueToCast = _value;
                    break;
                }
            }
            if(valueToCast != null) {
                value = tClass.cast(valueToCast);
            }
            else {
                value = instantiateNew(tClass, profile);
            }
        }else if(dependencyLinks.containsKey(tClass)){
            value = instantiateNew(tClass, profile);
        }
        return value;
    }

    private static <T> T instantiateNew(Class<T> tClass, String profile){
        T value = null;
        Set<Class> classSet = dependencyLinks.get(tClass);
        //Entre as várias implementações de uma interface, tenta encontrar a que bate com o profile
        Class valueClass = getClassBasedOnProfile(classSet, profile);
        if(valueClass == null){
            Log.e(TAG, "No implementation of " + tClass.getName() + " matches profile : " + profile);
        }
        else
        {
            try {
                value = tClass.cast(valueClass.newInstance());
                if(!dependencyCache.containsKey(tClass)){
                    dependencyCache.put(tClass, new HashSet<>());
                }
                dependencyCache.get(tClass).add(value);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return value;
    }

    private static Class getClassBasedOnProfile(Set<Class> classSet, String profile){
        Class valueClass = null;
        if(classSet.size() > 1){
            if(StringUtils.isNotNullOrEmpty(profile)){
                Iterator<Class> classIterator = classSet.iterator();
                while (classIterator.hasNext()){
                    Class candidate = classIterator.next();
                    if(candidate.isAnnotationPresent(Profile.class)){
                        Profile annotaion = (Profile) candidate.getAnnotation(Profile.class);
                        String[] profiles = annotaion.profiles();
                        for (String _profile: profiles) {
                            if(_profile.equals(profile)){
                                valueClass = candidate;
                                break;
                            }
                        }
                    }
                    if(valueClass != null){
                        break;
                    }
                }
            }else {
                throw new IllegalArgumentException("If an interface has more than one implementation, a profile must be informed");
            }
        } else if(classSet.size() > 0) {
            valueClass = classSet.iterator().next();
        }
        return valueClass;
    }

    public static void link(Class _interface, Class _implementation){
        if(!dependencyLinks.containsKey(_interface)){
            dependencyLinks.put(_interface, new HashSet<Class>());
        }
        dependencyLinks.get(_interface).add(_implementation);
    }
}
