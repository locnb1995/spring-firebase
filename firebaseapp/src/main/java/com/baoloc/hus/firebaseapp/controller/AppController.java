package com.baoloc.hus.firebaseapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class AppController
{
	@GetMapping("/")
	public String getIndex()
	{
		return "index";
	}
}
