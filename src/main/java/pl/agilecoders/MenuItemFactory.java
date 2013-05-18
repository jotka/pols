package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 07:58
 */
public interface MenuItemFactory {
    MenuItem create(String name);
    MenuItem createWithSubs(String name, String... subMenus);
}
