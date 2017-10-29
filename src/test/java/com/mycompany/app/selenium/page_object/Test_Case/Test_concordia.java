package com.mycompany.app.selenium.page_object.Test_Case;

import com.mycompany.app.selenium.page_object.Page_Elements.Home_Page_Top_Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_concordia extends TestBase {

    @Before
    public void setup() {
        super.pageLoad();
    }

    @Test
    public void testAbout() throws Exception {
        Home_Page_Top_Menu Hp_TopMenu = new Home_Page_Top_Menu();
        Hp_TopMenu.top_menu();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();

    }
}