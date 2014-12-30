package br.com.pacotaogames.faces.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.pacotaogames.entities.BaseEntity;

@FacesConverter("entityConverter")
public class EntityConverter implements Converter {
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			return getAttributesForm(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if ((object != null) && (!"".equals(object))) {
			BaseEntity entity = (BaseEntity) object;

			addAttribute(component, entity);
			String id = entity.getId().toString();
			if (id != null) {
				return String.valueOf(id);
			}
		}
		return (String) object;
	}

	protected void addAttribute(UIComponent component, BaseEntity entity) {
		String key = entity.getId().toString();
		getAttributesForm(component).put(key, entity);
	}

	protected Map<String, Object> getAttributesForm(UIComponent component) {
		return component.getAttributes();
	}
}
