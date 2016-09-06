package com.pelayolluna.filmviewerservice.controllerTEST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pelayolluna.filmviewerservice.domainTEST.Shop;

@Controller
@RequestMapping("/shops")
public class ShopController
{

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON(@PathVariable String name)
	{

		Shop shop = new Shop();
		shop.setId(1L);
		shop.setName(name);
		shop.setStaffName(new String[] { "mkyong1", "mkyong2" });

		return shop;
	}

}
