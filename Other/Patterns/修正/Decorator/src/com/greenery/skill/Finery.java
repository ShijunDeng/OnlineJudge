package com.greenery.skill;

import com.greenery.animals.Appearance;

public abstract class Finery extends Appearance {
	protected Appearance component;

	public Finery() {
		super();
	}

	public Finery(String name) {
		super(name);
	}

	public void Decorate(Appearance component) {
		this.component = component;
	}

	public void Show() {
		if (component != null) {
			component.show();
		}
	}
}
