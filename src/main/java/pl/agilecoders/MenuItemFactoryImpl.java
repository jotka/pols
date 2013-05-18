package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 07:58
 */
public class MenuItemFactoryImpl implements MenuItemFactory {
    @Override
    /**
     * Create single menuitem
     */
    public MenuItem create(String name) {
        return new MenuItemImpl(name);
    }

    @Override
    /**
     * Create menu with submenus (a shortcut)
     */
    public MenuItem createWithSubs(String name, String... subMenus) {
        MenuItem menu = create(name);
        for (String subName : subMenus) {
            menu.add(create(subName));
        }
        return menu;
    }
}
