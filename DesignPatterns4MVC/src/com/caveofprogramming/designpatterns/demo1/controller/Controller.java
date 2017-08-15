package com.caveofprogramming.designpatterns.demo1.controller;

import com.caveofprogramming.designpatterns.demo1.model.Model;
import com.caveofprogramming.designpatterns.demo1.view.View;

public class Controller {
	private View view;
	private Model model;
	
	public Controller(Model model, View view) {
		super();
		this.view = view;
		this.model = model;
	}
}
