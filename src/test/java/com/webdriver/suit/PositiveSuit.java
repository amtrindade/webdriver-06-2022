package com.webdriver.suit;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.webdriver.inter.NegativeInterface;
import com.webdriver.inter.PositiveInterface;
import com.webdriver.test.CalcTest;
import com.webdriver.test.DragAndDropTest;
import com.webdriver.test.NavigationTabs;
import com.webdriver.test.RegularExpressionTest;
import com.webdriver.test.SimulateCache;
import com.webdriver.test.WebElementsTest;

@RunWith(Categories.class)
@SuiteClasses({CalcTest.class, DragAndDropTest.class, 
		NavigationTabs.class, RegularExpressionTest.class,
		SimulateCache.class, WebElementsTest.class})
@ExcludeCategory({NegativeInterface.class, PositiveInterface.class})
public class PositiveSuit {

}
