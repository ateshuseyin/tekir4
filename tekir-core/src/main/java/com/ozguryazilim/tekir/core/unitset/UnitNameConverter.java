/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ozguryazilim.tekir.core.unitset;

import com.ozguryazilim.telve.unit.UnitName;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * UnitName için JSF Converter
 * 
 * @author Hakan Uygun
 */
@FacesConverter("unitNameConverter")
public class UnitNameConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return UnitName.of(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if( o instanceof UnitName ){
            return ((UnitName)o).toString();
        }
        
        return "";
    }
    
}
