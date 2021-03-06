package com.linnik.wickiup.patterns._1_creational._4_factory_method.sites;

import com.linnik.wickiup.patterns._1_creational._4_factory_method.pages.AboutPage;
import com.linnik.wickiup.patterns._1_creational._4_factory_method.pages.CommentPage;
import com.linnik.wickiup.patterns._1_creational._4_factory_method.pages.ContactPage;
import com.linnik.wickiup.patterns._1_creational._4_factory_method.pages.PostPage;

/**
 * @author LinnykOleh
 */
public class Blog extends Website {

	@Override
	public void createWebsite() {
		pages.add(new PostPage());
		pages.add(new AboutPage());
		pages.add(new CommentPage());
		pages.add(new ContactPage());
	}
}
