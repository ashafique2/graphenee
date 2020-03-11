package io.graphenee.flow;

import java.util.HashSet;
import java.util.Set;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GxFormLayout extends FormLayout {

	private static final long serialVersionUID = 1L;

	final Set<Component> fieldSet = new HashSet<>();
	private boolean expandFields;

	@Override
	public FormItem addFormItem(Component field, Component label) {
		fieldSet.add(field);
		if (expandFields) {
			field.getElement().getClassList().add("full-width");
		}
		return super.addFormItem(field, label);
	}

	public void addClassToFields(String className) {
		for (Component field : fieldSet) {
			field.getElement().getClassList().add(className);
		}
	}

	public GxFormLayout(boolean expandFields) {
		super();
		this.expandFields = expandFields;
	}

}
